const {
	spawn,
	spawnSync
} = require('child_process');
const fs = require('fs');
const path = require("path");
const xmldom = require('xmldom');
const xmlFormatter = require('xml-formatter');
const fsExtra = require('fs-extra');
const rimraf = require('rimraf');
const ora = require("ora");
const chalk = require("chalk");
const gjs = require('./parse/gradle-to-js');
const Handlebars = require('handlebars');
require('dotenv').config();
const _ = require('lodash');
const shelljs = require('shelljs');
// require('shelljs/global');
// shelljs.config.verbose = true;
const iconv = require('iconv-lite');
const {
	getBaseBuildConfig
} = require('./config/buildConfig');
const {
	output
} = require('./utils/output');
const {
	logger
} = require('../log/logger');
const {
	copyFilesWithGlob,
	deleteFile,
	removeSyncWithRetry,
	getLastDirName
} = require("./utils/io");

function normalizeJavaHome(javaHome) {
	// 当前项目通过配置窗口传入 JDKPath。
	// 这里保留 docs 核心原有的 macOS 兼容逻辑，
	// 目的是兼容直接选择 JDK 根目录或 Contents/Home 两种情况。
	if (!javaHome) {
		return '';
	}

	const candidates = process.platform === 'win32'
		? [javaHome]
		: [
			javaHome,
			path.join(javaHome, 'Contents', 'Home')
		];
	return candidates.find(item => fs.existsSync(path.join(item, 'bin', process.platform === 'win32' ? 'java.exe' : 'java'))) ?? javaHome;
}

function getJavaHomeCandidates(javaHome) {
	return [
		javaHome,
		process.env.JAVA_HOME,
		'/Applications/ServBay/package/openjdk/17/current.sdk',
		'/Applications/ServBay/package/openjdk/17/current.sdk/Contents/Home',
		'/Applications/ServBay/package/openjdk/current.sdk',
		'/Applications/ServBay/package/openjdk/current.sdk/Contents/Home',
		'/Applications/Android Studio.app/Contents/jbr/Contents/Home',
		'/Applications/HBuilderX.app/Contents/HBuilderX/plugins/uts-development-android/openjdk'
	].filter(Boolean);
}

function getJavaBinaryPath(javaHome) {
	const candidates = process.platform === 'win32'
		? [path.join(javaHome, 'bin', 'java.exe')]
		: [
			path.join(javaHome, 'bin', 'java'),
			path.join(javaHome, 'Contents', 'Home', 'bin', 'java')
		];

	return candidates.find(item => fs.existsSync(item)) ?? candidates[0];
}

function getJavaMajorVersion(javaHome) {
	try {
		const result = spawnSync(getJavaBinaryPath(javaHome), ['-version'], {
			encoding: 'utf8',
			stdio: ['ignore', 'pipe', 'pipe']
		});
		if (result.error || result.status !== 0) {
			return 0;
		}
		const output = `${result.stdout ?? ''}${result.stderr ?? ''}`;
		const versionLine = output.split('\n')[0];
		const versionMatch = versionLine.match(/version "(.*)"/);
		if (!versionMatch) {
			return 0;
		}
		const version = versionMatch[1];
		return version.startsWith('1.') ? parseInt(version.split('.')[1]) : parseInt(version);
	} catch (error) {
		return 0;
	}
}

function resolveRequiredJavaHome(javaHome, requiredVersion = 17) {
	for (const candidate of getJavaHomeCandidates(javaHome)) {
		const normalized = normalizeJavaHome(candidate);
		if (!fs.existsSync(getJavaBinaryPath(normalized))) {
			continue;
		}
		if (getJavaMajorVersion(normalized) >= requiredVersion) {
			return normalized;
		}
	}

	// 没找到满足版本的 JDK 时保留原值，让 Gradle 暴露明确错误，避免静默吞掉配置问题。
	return normalizeJavaHome(javaHome);
}

function escapeShellPath(filePath) {
	return filePath.replace(/ /g, '\\ ');
}


const NATIVE_ANDROID_PROJECT_NAME = '';
// 当前副本运行在本项目中时，默认根目录应落到 core 上级目录，
// 避免沿用 docs 独立脚本对 process.cwd() 和环境变量的假设。
const DEFAULT_CORE_ROOT = path.resolve(__dirname, '..');
const DEFAULT_WORKSPACE_ROOT = path.resolve(DEFAULT_CORE_ROOT, '..', '..', '..', '..');
const DEFAULT_BASE_PROJECT_ROOT = path.join(DEFAULT_WORKSPACE_ROOT, 'docs', 'src', 'easypackx');
let targetDirectory = path.join(DEFAULT_WORKSPACE_ROOT, NATIVE_ANDROID_PROJECT_NAME);
let _ROOT_ = DEFAULT_CORE_ROOT;
let baseProjectRoot = DEFAULT_BASE_PROJECT_ROOT;
let sdkWorkspaceRoot = DEFAULT_CORE_ROOT;
let SDK_DOWNLOAD_URL = process.env.SDK_DOWNLOAD_URL ??
	'https://web-ext-storage.dcloud.net.cn/uni-app-x/sdk/Android/Android-uni-app-x-SDK@14694-5.07.zip';
let SDK_UNZIP_NAME = '';
let local_pack = true;

let customConsoleLog = null;
let customSetStatusMessage = null;
let hx = null;
let useProjectLocalSdk = false;

let localPackCommand = './gradlew :app:packageDebug';
let uniappProjectPath = DEFAULT_WORKSPACE_ROOT;
let appAndroidPath = path.join(uniappProjectPath, 'unpackage', 'resources', 'app-android');
let unixAndroidPath = path.join(appAndroidPath, 'uniappx', 'app-android');
let APP_ID = '';
let errors = [];
let storePath = ''
let packType = '1'
let isBundle = false;
let channel = '';

let unixBuildGradlePath = path.join(targetDirectory, '/uniappx/', 'build.gradle');
let appBuildGradlePath = path.join(targetDirectory, '/app/', 'build.gradle');
let rootBuildGradlePath = path.join(targetDirectory, '/', 'build.gradle');
let settingsBuildGradlePath = path.join(targetDirectory, '/', 'settings.gradle');

/**
 * build.gradle的配置
 */
let baseBuildGradleConfig = getBaseBuildConfig();
let appBuildGradleConfig;
let unixBuildGradleConfig;
let moduleBuildGradleConfig;
let rootBuildGradleConfig;
let baseLocalSdk;
let baseSettingsGradle;
let utsHookClasses = new Set();
let collectedModuleMinSdkVersions = [];
let resolvedAppName = 'uniapp x';
let resolvedManifestMeta = {
	name: 'uniapp x',
	versionName: '',
	versionCode: ''
};

let packConfig = null;

function loadResolvedManifestMeta() {
	const manifestPath = path.join(appAndroidPath, APP_ID, '/www/', 'manifest.json');
	if (!APP_ID || !fs.existsSync(manifestPath)) {
		return;
	}
	try {
		const manifest = JSON.parse(fsExtra.readFileSync(manifestPath, 'utf-8'));
		resolvedManifestMeta = {
			name: manifest?.name || 'uniapp x',
			versionName: manifest?.versionName || manifest?.version?.name || '',
			versionCode: manifest?.versionCode || manifest?.version?.code || ''
		};
		resolvedAppName = resolvedManifestMeta.name;
	} catch (error) {
		logger.warn(`读取编译产物 manifest.json 失败：${manifestPath}，${error.message}`);
	}
}

async function syncAppNameResources(appName) {
	const normalizedAppName = appName || resolvedManifestMeta.name || resolvedAppName || 'uniapp x';
	const valuesRoot = path.join(targetDirectory, '/app/src/main/res/');
	if (!fs.existsSync(valuesRoot)) {
		return;
	}
	const entries = await fs.promises.readdir(valuesRoot, { withFileTypes: true });
	for (const entry of entries) {
		if (!entry.isDirectory() || !entry.name.startsWith('values')) {
			continue;
		}
		const stringsPath = path.join(valuesRoot, entry.name, 'strings.xml');
		if (!fs.existsSync(stringsPath)) {
			continue;
		}
		const xml = await fs.promises.readFile(stringsPath, 'utf-8');
		const doc = new xmldom.DOMParser().parseFromString(xml);
		const stringNodes = doc.documentElement?.getElementsByTagNameNS('*', 'string') || [];
		let hasAppName = false;
		for (let index = 0; index < stringNodes.length; index += 1) {
			const node = stringNodes[index];
			if (node.getAttribute('name') === 'app_name') {
				node.textContent = normalizedAppName;
				hasAppName = true;
			}
		}
		if (!hasAppName) {
			const appNameNode = doc.createElement('string');
			appNameNode.setAttribute('name', 'app_name');
			appNameNode.appendChild(doc.createTextNode(normalizedAppName));
			doc.documentElement.appendChild(appNameNode);
		}
		const updatedXmlString = new xmldom.XMLSerializer().serializeToString(doc);
		await fs.promises.writeFile(stringsPath, xmlFormatter(updatedXmlString), {
			encoding: 'utf8',
		});
	}
}

const EXT_API_MODULE_ALIASES = {
	getStorageSync: 'uni-storage',
	setStorageSync: 'uni-storage',
	removeStorageSync: 'uni-storage',
	request: 'uni-network',
	uploadFile: 'uni-network',
	downloadFile: 'uni-network',
	getNetworkType: 'uni-getNetworkType',
	connectSocket: 'uni-websocket',
	showToast: 'uni-prompt',
	showModal: 'uni-modal',
	hideModal: 'uni-modal',
	showLoading: 'uni-showLoading',
	hideLoading: 'uni-showLoading',
	showActionSheet: 'uni-actionSheet',
	hideActionSheet: 'uni-actionSheet',
	chooseImage: 'uni-media',
	saveImageToPhotosAlbum: 'uni-media',
	getImageInfo: 'uni-media',
	compressImage: 'uni-media',
	chooseVideo: 'uni-media',
	saveVideoToPhotosAlbum: 'uni-media',
	getVideoInfo: 'uni-media',
	compressVideo: 'uni-media',
	previewImage: 'uni-previewImage',
	chooseMedia: 'uni-chooseMedia',
	getFileSystemManager: 'uni-fileSystemManager',
	openDocument: 'uni-openDocument',
	scanCode: 'uni-scanCode',
	createCanvasContextAsync: 'uni-canvas',
	createVideoContext: 'uni-video',
	createMapContext: 'uni-map-tencent',
	getLocation: 'uni-getLocation',
	chooseLocation: 'uni-chooseLocation',
	getPrivacySetting: 'uni-privacy',
	resetPrivacyAuthorization: 'uni-privacy',
	onPrivacyAuthorizationChange: 'uni-privacy',
	offPrivacyAuthorizationChange: 'uni-privacy',
	getProvider: 'uni-getProvider',
	shareWithSystem: 'uni-shareWithSystem',
	createInnerAudioContext: 'uni-createInnerAudioContext',
	getBackgroundAudioManager: 'uni-getBackgroundAudioManager',
	requestPayment: 'uni-payment',
	createPushMessage: 'uni-push',
	getPushClientId: 'uni-push',
	onPushMessage: 'uni-push',
	offPushMessage: 'uni-push',
	getUniverifyManager: 'uni-verify',
	getFacialRecognitionMetaInfo: 'uni-facialRecognitionVerify',
	startFacialRecognitionVerify: 'uni-facialRecognitionVerify',
	installApk: 'uni-installApk',
	arrayBufferToBase64: 'uni-arrayBufferToBase64',
	base64ToArrayBuffer: 'uni-base64ToArrayBuffer',
	connectEventSource: 'uni-sse',
	requestMerchantTransfer: 'uni-requestMerchantTransfer',
	getRecorderManager: 'uni-recorder',
	makePhoneCall: 'uni-makePhoneCall',
	getClipboardData: 'uni-clipboard',
	setClipboardData: 'uni-clipboard',
	hideKeyboard: 'uni-keyboard',
	onKeyboardHeightChange: 'uni-keyboard',
	offKeyboardHeightChange: 'uni-keyboard',
	createRequestPermissionListener: 'uni-createRequestPermissionListener',
	createWebviewContext: 'uni-createWebviewContext',
	getAppAuthorizeSetting: 'uni-getAppAuthorizeSetting',
	openAppAuthorizeSetting: 'uni-openAppAuthorizeSetting',
	getAppBaseInfo: 'uni-getAppBaseInfo',
	getDeviceInfo: 'uni-getDeviceInfo',
	getSystemInfo: 'uni-getSystemInfo',
	getSystemSetting: 'uni-getSystemSetting',
	getWindowInfo: 'uni-getSystemInfo',
	rpx2px: 'uni-rpx2px',
	createLivePlayerContext: 'uni-live-player',
	createLivePusherContext: 'uni-live-pusher',
	createSelectorQuery: 'uni-getElementById',
	getElementById: 'uni-getElementById',
	startAccelerometer: 'uni-accelerometer',
	stopAccelerometer: 'uni-accelerometer',
	onAccelerometerChange: 'uni-accelerometer',
	offAccelerometerChange: 'uni-accelerometer',
	checkIsSupportSoterAuthentication: 'uni-authentication',
	checkIsSoterEnrolledInDevice: 'uni-authentication',
	startSoterAuthentication: 'uni-authentication',
	addPhoneCalendar: 'uni-calendar',
	startCompass: 'uni-compass',
	stopCompass: 'uni-compass',
	onCompassChange: 'uni-compass',
	offCompassChange: 'uni-compass',
	createEditorContext: 'uni-editor',
	startGyroscope: 'uni-gyroscope',
	stopGyroscope: 'uni-gyroscope',
	onGyroscopeChange: 'uni-gyroscope',
	offGyroscopeChange: 'uni-gyroscope',
	onMemoryWarning: 'uni-memory',
	offMemoryWarning: 'uni-memory',
	chooseContact: 'uni-phoneContact',
	getScreenBrightness: 'uni-screenBrightness',
	setScreenBrightness: 'uni-screenBrightness',
	setKeepScreenOn: 'uni-screenBrightness',
	vibrate: 'uni-vibrate',
	vibrateLong: 'uni-vibrate',
	vibrateShort: 'uni-vibrate'
};

function initModuleBuildGradleConfig() {
	moduleBuildGradleConfig = {
		..._.cloneDeep(baseBuildGradleConfig)
	}
	moduleBuildGradleConfig.dependencies.compileOnly = [
		'com.alibaba:fastjson:1.2.83',
		'androidx.core:core-ktx:1.9.0',
		'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8',
		'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.8'
	];
}

function initBuildConfig() {
	baseBuildGradleConfig = getBaseBuildConfig()
	appBuildGradleConfig = {
		..._.cloneDeep(baseBuildGradleConfig)
	};

	unixBuildGradleConfig = {
		..._.cloneDeep(baseBuildGradleConfig)
	};

	// moduleBuildGradleConfig = {
	// 	..._.cloneDeep(baseBuildGradleConfig)
	// };
	initModuleBuildGradleConfig()

	rootBuildGradleConfig = {
		..._.cloneDeep(baseBuildGradleConfig),
		project: {
			..._.cloneDeep(baseBuildGradleConfig.project),
			dependencies: {
				default: [],
				files: []
			}
		}
	};

	/**
	 * localSdk的配置
	 */
	baseLocalSdk = {
		localSdk: '',
		androidSdk: ''
	}

	/**
	 * settings.gradle的配置
	 */
	baseSettingsGradle = {
		appName: 'uniapp x',
		plugins: [],
		repositories: {
			maven: []
		}
	}
	utsHookClasses = new Set();
	collectedModuleMinSdkVersions = [];
	storePath = ''
	packType = '1'
	useProjectLocalSdk = false
	baseProjectRoot = DEFAULT_BASE_PROJECT_ROOT
	sdkWorkspaceRoot = DEFAULT_CORE_ROOT
}

initBuildConfig();

function buildLocalPackGradlewAppParams() {
	let gradlewAppParams = ':app:packageDebug';
	if (packType == 2) {
		gradlewAppParams = ':app:assembleRelease';
	}
	if (isBundle) {
		gradlewAppParams = ':app:bundleDebug';
		if (packType == 2) {
			gradlewAppParams = ':app:bundleRelease';
		}
	}

	return gradlewAppParams;
}

function initConfig(options) {
	// 这一层只做“根据当前打包参数重建运行时状态”，不读取 UI 配置文件。
	// UI 配置文件已经在 Electron 主进程里展开并传给 start(options)。
	useProjectLocalSdk = false;
	if (options?.apkType == 'aab') {
		isBundle = true;
		appBuildGradleConfig.bundle = true;
	}
	// 判断应用分发渠道
	if (options?.apkChannelForm) {
		const apkChannelForm = options.apkChannelForm;
		if (apkChannelForm?.channel) {
			channel = options.apkChannelForm.channel;
		}
		if (apkChannelForm.customChannel) {
			channel = apkChannelForm.customChannel;
		}
	}
	if (channel == 'none') {
		channel = '';
	}
	if (process.platform === 'darwin') {
		localPackCommand = `${targetDirectory}/gradlew ${buildLocalPackGradlewAppParams()}`;
		if (packType == 2) {
			localPackCommand = `${targetDirectory}/gradlew ${buildLocalPackGradlewAppParams()}`;
		}
		options.javaHome = resolveRequiredJavaHome(options.javaHome, 17);
		if (options.javaHome) {
			localPackCommand += ` -Dorg.gradle.java.home=${escapeShellPath(options.javaHome)}`;
		}
	} else {
		localPackCommand = `${targetDirectory}/gradlew.bat ${buildLocalPackGradlewAppParams()} --no-daemon`;
		if (packType == 2) {
			localPackCommand = `${targetDirectory}/gradlew.bat ${buildLocalPackGradlewAppParams()}`
		}
		// localPackCommand += ` -Dorg.gradle.java.home=${options.javaHome.replace(/\\/g, '\\\\')}`
	}

	appAndroidPath = path.join(uniappProjectPath, 'unpackage', 'resources', 'app-android');
	unixAndroidPath = path.join(appAndroidPath, 'uniappx', 'app-android');
	unixBuildGradlePath = path.join(targetDirectory, '/uniappx/', 'build.gradle');
	appBuildGradlePath = path.join(targetDirectory, '/app/', 'build.gradle');
	rootBuildGradlePath = path.join(targetDirectory, '/', 'build.gradle');
	settingsBuildGradlePath = path.join(targetDirectory, '/', 'settings.gradle');
	baseBuildGradleConfig.localPack = local_pack;
	if (options?.androidLocalSdk) {
		useProjectLocalSdk = true;
		SDK_DOWNLOAD_URL = options.androidLocalSdk;
	}

	baseSettingsGradle.repositories.maven = [];
	baseSettingsGradle.plugins = [];

	// initBuildConfig();

	output.console = customConsoleLog;

	errors = [];
}

const uniModulesAndroidPath = (moduleName) => {
	// return `${appAndroidPath}/uni_modules/${moduleName}/utssdk/app-android`;
	return path.join(appAndroidPath, '/uni_modules/', moduleName, '/utssdk/app-android');
}

function hasUniModuleAndroidSource(moduleName) {
	// 只有存在 Android 原生源码的依赖才加入 Gradle 工程，避免可选依赖导致 settings.gradle 指向不存在的模块。
	return fsExtra.existsSync(uniModulesAndroidPath(moduleName));
}

function addUtsHookClass(hookClass) {
	if (!hookClass) {
		return;
	}
	// UTSHooksClassArray 只能生成一个 buildConfigField；多个插件 Hook 需要先合并，否则 Gradle 最终只保留最后一个。
	utsHookClasses.add(hookClass.replace(/^\{?\\"?/, '').replace(/\\"?\}?$/, ''));
}

function applyUtsHookClasses() {
	if (utsHookClasses.size === 0) {
		return;
	}
	const hooksClassArray = Array.from(utsHookClasses).map(hookClass => `\\"${hookClass}\\"`);
	appBuildGradleConfig.buildFeatures.buildConfig = true;
	appBuildGradleConfig.defaultConfig.buildConfigField = appBuildGradleConfig.defaultConfig.buildConfigField
		.filter(item => !item.includes('"UTSHooksClassArray"'));
	appBuildGradleConfig.defaultConfig.buildConfigField.push(
		`"String[]", "UTSHooksClassArray", "{${hooksClassArray.toString()}}"`
	);
}

// 删除文件或文件夹
function deleteFileOrFolder(path, callback) {
	try {
		removeSyncWithRetry(path);
		callback?.();
	} catch (error) {
		throw error;
	}
}

async function isDirectory(filePath) {
	try {
		const stats = await fs.promises.stat(filePath);
		return stats.isDirectory();
	} catch (err) {
		console.error('获取文件信息出错:', err);
		return false;
	}
}

function removeTrailingComma(str) {
	// 检查字符串是否以逗号结尾
	if (str[str.length - 1] === ',') {
		// 删除最后的逗号
		return str.slice(0, -1);
	}
	// 如果没有逗号，返回原始字符串
	return str;
}

function getManifestDistribute(manifest) {
	return manifest?.['app-android']?.distribute ?? manifest?.app?.distribute ?? {};
}

function getManifestModules(manifest) {
	return getManifestDistribute(manifest)?.modules ?? {};
}

function collectManifestPlaceholderNames(manifestContent = '') {
	const placeholderNames = new Set();
	const placeholderRegexp = /\$\{([A-Za-z0-9_.-]+)\}/g;
	let match;
	while ((match = placeholderRegexp.exec(manifestContent)) !== null) {
		placeholderNames.add(match[1]);
	}
	return Array.from(placeholderNames);
}

function flattenObjectValues(source, target = {}) {
	if (!source || typeof source !== 'object' || Array.isArray(source)) {
		return target;
	}
	for (const [key, value] of Object.entries(source)) {
		if (value && typeof value === 'object' && !Array.isArray(value)) {
			flattenObjectValues(value, target);
			continue;
		}
		if (['string', 'number', 'boolean'].includes(typeof value)) {
			target[key] = String(value);
		}
	}
	return target;
}

function readDynamicPlaceholderValues() {
	const nativeResourcesRoot = path.join(uniappProjectPath, 'nativeResources');
	if (!fs.existsSync(nativeResourcesRoot)) {
		return {};
	}

	const valueMap = {};
	const candidateFiles = [
		path.join(nativeResourcesRoot, 'config.json'),
		path.join(nativeResourcesRoot, 'android', 'config.json'),
		path.join(nativeResourcesRoot, 'android', 'manifestPlaceholders.json'),
		path.join(nativeResourcesRoot, 'manifestPlaceholders.json'),
		path.join(nativeResourcesRoot, 'gradle.properties'),
		path.join(nativeResourcesRoot, 'android', 'gradle.properties')
	];

	for (const filePath of candidateFiles) {
		if (!fs.existsSync(filePath)) {
			continue;
		}
		try {
			if (filePath.endsWith('.json')) {
				const json = JSON.parse(fs.readFileSync(filePath, 'utf-8'));
				flattenObjectValues(json, valueMap);
				continue;
			}
			const lines = fs.readFileSync(filePath, 'utf-8').split(/\r?\n/);
			for (const rawLine of lines) {
				const line = rawLine.trim();
				if (!line || line.startsWith('#') || line.startsWith('//')) {
					continue;
				}
				const separatorIndex = line.indexOf('=');
				if (separatorIndex <= 0) {
					continue;
				}
				const key = line.slice(0, separatorIndex).trim();
				const value = line.slice(separatorIndex + 1).trim();
				if (key && value) {
					valueMap[key] = value;
				}
			}
		} catch (error) {
			logger.warn(`读取 nativeResources 占位符配置失败：${filePath}，${error.message}`);
		}
	}

	return valueMap;
}

function applyDynamicManifestPlaceholders(manifestContent = '') {
	const placeholderNames = collectManifestPlaceholderNames(manifestContent);
	if (placeholderNames.length === 0) {
		return;
	}
	const availableValues = readDynamicPlaceholderValues();
	const manifestPlaceholders = appBuildGradleConfig.defaultConfig.manifestPlaceholders;
	let hasDynamicPlaceholder = false;
	for (const placeholderName of placeholderNames) {
		const placeholderValue = availableValues[placeholderName];
		if (placeholderValue === undefined || placeholderValue === '') {
			continue;
		}
		hasDynamicPlaceholder = true;
		manifestPlaceholders[placeholderName] = placeholderValue;
	}
	if (hasDynamicPlaceholder) {
		appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
	}
}

function buildManifestPlaceholderEntries() {
	const placeholders = appBuildGradleConfig.defaultConfig.manifestPlaceholders || {};
	return Object.entries(placeholders)
		.filter(([, value]) => value !== '' && value !== undefined && value !== null)
		.map(([key, value]) => ({
			key,
			isBoolean: typeof value === 'boolean' || value === 'true' || value === 'false',
			value: typeof value === 'boolean' ? value : String(value)
		}));
}

function getOptionModules(options = {}) {
	return Object.keys(options).reduce((modules, key) => {
		if (key.startsWith('uni-') && options[key] instanceof Object) {
			modules[key] = options[key];
		}
		return modules;
	}, {});
}

function buildModuleConfig(manifest, options = {}) {
	// HBuilderX 5.x 生成的资源把模块写在 app-android.distribute.modules。
	// 这里以生成产物为主，再合并界面里手动选择的扩展模块，避免漏拷新版 ext API AAR。
	return {
		...getManifestModules(manifest),
		...getOptionModules(options)
	};
}

const ANDROID_SDK_REQUIRED_FILES = [
	'SDK/libs',
	'plugins/uts-kotlin-compiler-plugin-0.0.1.jar',
	'plugins/uts-kotlin-gradle-plugin-0.0.1.jar'
];

function getAndroidSdkCandidateNames(sdkName) {
	const names = [sdkName];
	try {
		names.push(decodeURIComponent(sdkName));
	} catch (error) {
		logger.warn(`Android SDK目录名解码失败：${sdkName}`);
	}
	return _.uniq(names.filter(Boolean));
}

function isAndroidSdkExtractedValid(sdkRoot) {
	return ANDROID_SDK_REQUIRED_FILES.every(item => fsExtra.existsSync(path.join(sdkRoot, item)));
}

function getMissingAndroidSdkFiles(sdkRoot) {
	return ANDROID_SDK_REQUIRED_FILES.filter(item => !fsExtra.existsSync(path.join(sdkRoot, item)));
}

function findValidAndroidSdkRoot(sdkLibsPath, sdkName) {
	for (const candidateName of getAndroidSdkCandidateNames(sdkName)) {
		const candidateRoot = path.join(sdkLibsPath, candidateName);
		if (isAndroidSdkExtractedValid(candidateRoot)) {
			return {
				name: candidateName,
				root: candidateRoot
			};
		}
	}

	if (!fsExtra.existsSync(sdkLibsPath)) {
		return null;
	}

	const entries = fsExtra.readdirSync(sdkLibsPath, { withFileTypes: true });
	for (const entry of entries) {
		if (!entry.isDirectory()) {
			continue;
		}
		const candidateRoot = path.join(sdkLibsPath, entry.name);
		if (isAndroidSdkExtractedValid(candidateRoot)) {
			return {
				name: entry.name,
				root: candidateRoot
			};
		}
	}

	return null;
}

function assertAndroidSdkExtracted(sdkLibsPath) {
	const validSdk = findValidAndroidSdkRoot(sdkLibsPath, SDK_UNZIP_NAME);
	if (validSdk) {
		SDK_UNZIP_NAME = validSdk.name;
		checkPass = true;
		return;
	}

	const sdkRoot = path.join(sdkLibsPath, SDK_UNZIP_NAME);
	const missingFiles = getMissingAndroidSdkFiles(sdkRoot).join('、');
	throw new Error(`Android离线打包SDK解压不完整，缺少：${missingFiles || '关键文件'}，请重新执行打包以自动修复SDK缓存。`);
}

function hasSdkLib(fileName) {
	if (!SDK_UNZIP_NAME) {
		return true;
	}
	if (useProjectLocalSdk && baseLocalSdk.localSdk) {
		const sourceDir = path.join(baseLocalSdk.localSdk, 'SDK', 'libs');
		return fsExtra.existsSync(path.join(sourceDir, fileName));
	}

	const sourceDir = path.join(sdkWorkspaceRoot, 'SDK', 'uniappx', 'libs', SDK_UNZIP_NAME, 'SDK', 'libs');
	return fsExtra.existsSync(path.join(sourceDir, fileName));
}

function getSdkLibSourceDir() {
	// 当前项目已经固定为“直接使用配置中的离线 SDK 目录”。
	// 因此这里优先返回 `uniAndroidSDK/SDK/libs`，
	// 只有保留兼容时才会退回旧的缓存结构。
	if (useProjectLocalSdk && baseLocalSdk.localSdk) {
		return path.join(baseLocalSdk.localSdk, 'SDK', 'libs');
	}
	return path.join(sdkWorkspaceRoot, 'SDK', 'uniappx', 'libs', SDK_UNZIP_NAME, 'SDK', 'libs');
}

function getSdkPluginSourcePath(plugin) {
	// 插件 jar 和编译插件现在也直接从配置目录读取，
	// 不再通过下载/复制后的临时 SDK 目录中转。
	if (useProjectLocalSdk && baseLocalSdk.localSdk) {
		return path.join(baseLocalSdk.localSdk, 'plugins', plugin);
	}
	return path.join(sdkWorkspaceRoot, 'SDK', 'uniappx', 'libs', SDK_UNZIP_NAME, 'plugins', plugin);
}

function shouldCopyModuleLib(moduleName) {
	return hasSdkLib(`${moduleName}-release.aar`);
}

function pushModuleMissingLibError(moduleName) {
	// if (!moduleName.startsWith('uni-') || shouldCopyModuleLib(moduleName)) {
	// 	return;
	// }
	// if (moduleName === 'uni-dialogPage') {
	// 	return;
	// }
	return;
	// pushConfigError(`【${moduleName}】当前 Android 离线 SDK 中缺少 ${moduleName}-release.aar，请下载与 HBuilderX 编译器匹配的新版 uni-app x Android 离线 SDK 后重试。`);
}

function ensureModule(modules, moduleName, value = {}) {
	if (!modules[moduleName]) {
		modules[moduleName] = value;
	}
}

function normalizeModuleConfig(modules) {
	const normalized = { ...modules };

	// 这些依赖在新版 HBuilderX 产物里经常只出现上层模块，离线工程仍需要同步底层 AAR。
	if (normalized['uni-previewImage']) {
		[
			'uni-media',
			'uni-network',
			'uni-fileSystemManager',
			'uni-storage',
			'uni-prompt',
			'uni-actionSheet'
		].forEach(moduleName => ensureModule(normalized, moduleName));
	}
	if (normalized['uni-chooseMedia']) {
		ensureModule(normalized, 'uni-actionSheet');
	}
	if (normalized['uni-media']) {
		ensureModule(normalized, 'uni-prompt');
		ensureModule(normalized, 'uni-actionSheet');
	}
	if (normalized['uni-camera'] || normalized['uni-scanCode'] || normalized['uni-barcode-scanning']) {
		ensureModule(normalized, 'uni-media');
	}
	if (normalized['uni-barcode-scanning'] || normalized['uni-scanCode'] || normalized['uni-showLoading'] || normalized['uni-picker']) {
		ensureModule(normalized, 'uni-getSystemInfo');
	}
	if (normalized['uni-match-media'] || normalized['uni-picker']) {
		ensureModule(normalized, 'uni-getDeviceInfo');
	}
	if (normalized['uni-live-pusher']) {
		ensureModule(normalized, 'uni-fileSystemManager');
		ensureModule(normalized, 'uni-network');
	}
	if (normalized['uni-openDocument']) {
		ensureModule(normalized, 'uni-fileSystemManager');
	}
	if (normalized['uni-createInnerAudioContext'] || normalized['uni-getBackgroundAudioManager']) {
		ensureModule(normalized, 'uni-network');
	}
	if (normalized['uni-editor']) {
		ensureModule(normalized, 'uni-web-view');
	}
	if (normalized['uni-phoneContact']) {
		ensureModule(normalized, 'uni-media');
		ensureModule(normalized, 'uni-getAppBaseInfo');
		ensureModule(normalized, 'uni-actionSheet');
	}
	if (normalized['uni-chooseLocation'] || normalized['uni-picker'] || normalized['uni-showLoading']) {
		ensureModule(normalized, 'uni-theme');
	}
	if (normalized['uni-picker']) {
		ensureModule(normalized, 'uni-getAppBaseInfo');
	}
	if (normalized['uni-cloudClient']) {
		[
			'uni-media',
			'uni-network',
			'uni-websocket',
			'uni-map-tencent',
			'uni-storage',
			'uni-prompt',
			'uni-showLoading'
		].forEach(moduleName => ensureModule(normalized, moduleName));
	}
	if (normalized['uni-chooseLocation']) {
		ensureModule(normalized, 'uni-cloudClient');
		ensureModule(normalized, 'uni-getLocation', { system: {} });
	}
	if (normalized['uni-getLocation']) {
		const locationModule = normalized['uni-getLocation'];
		if (Object.keys(locationModule).length === 0) {
			locationModule.system = {};
		}
	}

	return normalized;
}

function getTencentLBSAPIKey() {
	const value = packConfig?.moduleProvider?.TencentLBSAPIKey;
	return typeof value === 'object' ? value?.value : value;
}

function pushConfigError(error) {
	if (!errors.includes(error)) {
		errors.push(error);
	}
}

function getKotlinFiles(dirPath) {
	if (!fs.existsSync(dirPath)) {
		return [];
	}

	const entries = fsExtra.readdirSync(dirPath, { withFileTypes: true });
	return entries.flatMap(entry => {
		const entryPath = path.join(dirPath, entry.name);
		if (entry.isDirectory()) {
			return getKotlinFiles(entryPath);
		}
		if (entry.isFile() && entry.name.endsWith('.kt')) {
			return [entryPath];
		}
		return [];
	});
}

function inferModulesFromGeneratedExtApi(sourceRoot) {
	const modules = {};
	const importRegex = /import\s+io\.dcloud\.uniapp\.extapi\.([A-Za-z0-9_*]+)/g;
	const webViewRuntimeMarkers = [
		'UniWebViewElement',
		'UniWebViewErrorEvent',
		'UniWebViewLoadEvent',
		'UniWebViewMessageEvent',
		'createWebviewContext'
	];

	for (const kotlinFile of getKotlinFiles(sourceRoot)) {
		const source = fsExtra.readFileSync(kotlinFile, 'utf-8');
		let match = null;
		while ((match = importRegex.exec(source)) !== null) {
			if (match[1] === '*') {
				continue;
			}
			const moduleName = EXT_API_MODULE_ALIASES[match[1]];
			if (moduleName) {
				modules[moduleName] = {};
			}
		}
		if (webViewRuntimeMarkers.some(marker => source.includes(marker))) {
			modules['uni-web-view'] = modules['uni-web-view'] || {};
			modules['uni-createWebviewContext'] = modules['uni-createWebviewContext'] || {};
		}
	}

	return modules;
}

/**
 * 查询是否有本地打包资源
 */
function checkResourcesExists() {
	return fs.existsSync(`${appAndroidPath}`);
}

/**
 * 替换应用APPID
 */
async function updateAppid(oraSpinner) {
	try {
		// 定义要查找的目录名称的前缀
		const prefix = '__UNI__';
		const metaDataNameAppID = 'DCLOUD_UNI_APPID';
		const metaDataNameChannel = 'DCLOUD_CHANNEL';
		const metaDataNameTencentMapSDK = 'TencentMapSDK';
		const metaDataNameDebug = 'DCLOUD_DEBUG';

		// 遍历目录
		const directories = (await fs.promises.readdir(appAndroidPath)).filter(file => file.toString().startsWith(
			prefix));

		if (directories.length === 0) {
			output.error('未发现UNI应用资源包', customConsoleLog);
			oraSpinner.fail('未发现UNI应用资源包');
			logger.error('未发现UNI应用资源包');
			return;
		}

		APP_ID = directories[0];
		// 读取 AndroidMainfest.xml 文件
		// const manifestPath = `${targetDirectory}/uniappx/src/main/AndroidManifest.xml`;
		const manifestPath = path.join(targetDirectory, '/uniappx/src/main/AndroidManifest.xml');
		const xml = await fs.promises.readFile(manifestPath, 'utf-8');

		// 解析 XML 字符串
		const doc = new xmldom.DOMParser().parseFromString(xml);

		// 获取所有具有指定 name 的 meta-data 元素
		const metaDataElements = doc.getElementsByTagName('meta-data');
		for (let i = 0; i < metaDataElements.length; i++) {
			const element = metaDataElements[i];
			const nameAttribute = element.getAttribute('android:name');

			// 检查name属性是否与指定的name匹配
			if (nameAttribute === metaDataNameAppID) {
				// 替换value值
				element.setAttribute('android:value', APP_ID);
			}
			if (nameAttribute === metaDataNameChannel && channel != '') {
				element.setAttribute('android:value', channel);
			}
			if (nameAttribute === metaDataNameTencentMapSDK && getTencentLBSAPIKey()) {
				element.setAttribute('android:value', getTencentLBSAPIKey());
			}
			if (nameAttribute === metaDataNameDebug) {
				element.setAttribute('android:value', packType == 1);
			}
		}

		// 生成修改后的 XML 字符串
		const updatedXML = new xmldom.XMLSerializer().serializeToString(doc);
		// 写回 AndroidManifest.xml 文件
		await fs.promises.writeFile(manifestPath, xmlFormatter(updatedXML), {
			encoding: 'utf8',
		});

		// 判断项目根目录是否存在AndroidManifest.xml文件
		const projectAndroidManifestPath = path.join(uniappProjectPath, 'AndroidManifest.xml');
		if (fs.existsSync(projectAndroidManifestPath)) {
			const tips = '发现项目根目录存在AndroidManifest.xml，开始替换...'
			const spinner = ora(tips)
			output.warn(tips, customConsoleLog)
			logger.info(tips)
			const appAndroidManifestPath = path.join(targetDirectory, '/app/src/main/AndroidManifest.xml');
			await deleteFile(appAndroidManifestPath);
			fsExtra.copySync(projectAndroidManifestPath, path.join(targetDirectory,
				'/app/src/main/AndroidManifest.xml'));
			let appManifestContent = await fs.promises.readFile(appAndroidManifestPath, 'utf-8');
			const appManifestDoc = new xmldom.DOMParser().parseFromString(appManifestContent);
			const manifestNode = appManifestDoc.getElementsByTagName('manifest')?.[0];
			if (manifestNode?.getAttribute('package')) {
				manifestNode.removeAttribute('package');
				appManifestContent = xmlFormatter(new xmldom.XMLSerializer().serializeToString(appManifestDoc));
			}
			appManifestContent = ensureApplicationDisplayAttributes(appManifestContent, resolvedAppName);
			await fs.promises.writeFile(appAndroidManifestPath, appManifestContent, { encoding: 'utf8' });
			await syncAppNameResources(resolvedAppName);
			applyDynamicManifestPlaceholders(appManifestContent);
			spinner.succeed()
			const completeTips = 'AndroidManifest.xml替换完成'
			output.success(completeTips, customConsoleLog)
			logger.info(completeTips)
		}
		output.success('查找替换应用ID完成', customConsoleLog);
		oraSpinner.succeed('查找替换应用ID完成');
		logger.info('查找替换应用ID完成');
	} catch (e) {
		output.error(e.message, customConsoleLog);
		logger.error(e.stack);
		console.error(e);
		throw e;
	}
}

async function updateTargetResources(target, dest) {
	try {
		// 判断文件是否存在
		if (fs.existsSync(target)) {
			deleteFileOrFolder(target, () => {
				fsExtra.copySync(dest, target);
				// console.log(completeText);
			})
		} else {
			fsExtra.copySync(dest, target);
			// console.log(completeText);
		}
	} catch (e) {
		output.error(e.message, customConsoleLog);
		console.error(e);
		throw e;
	}
}

async function copyAppIcon(
	hdpi,
	hdpiType = 'hdpi',
	uniIconPath = path.join(uniappProjectPath, '/unpackage/res/icons/'),
	appIconPath = path.join(targetDirectory, '/app/src/main/res/'),
	iconName = 'ic_launcher'
) {
	try {
		const hdpiPngPath = path.join(uniIconPath, `${hdpi}x${hdpi}.png`);
		if (fs.existsSync(hdpiPngPath)) {
			const hdpiWebpPath = path.join(appIconPath, `/mipmap-${hdpiType}/`, `${iconName}.webp`);
			if (fs.existsSync(hdpiWebpPath)) {
				removeSyncWithRetry(hdpiWebpPath);
			}
			fsExtra.copyFileSync(hdpiPngPath, path.join(appIconPath, `/mipmap-${hdpiType}/`, `${iconName}.png`));
		}
	} catch (e) {
		throw e;
	}
}

async function copyNativeResources(
	iconName = 'push',
	hdpiType = 'hdpi',
	isRaw = false
) {
	try {
		const uniIconPath = path.join(uniappProjectPath, '/nativeResources/android/res/')
		const appIconPath = path.join(targetDirectory, '/app/src/main/res/')

		if (isRaw) {
			const rawPath = path.join(uniIconPath, `/raw/`, `${iconName}.mp3`);
			if (fs.existsSync(rawPath)) {
				fsExtra.copyFileSync(rawPath, path.join(appIconPath, `/raw/`, `${iconName}.mp3`));
			}
		} else {
			const hdpiPngPath = path.join(uniIconPath, `drawable-${hdpiType}`, `${iconName}.png`);
			if (fs.existsSync(hdpiPngPath)) {
				fsExtra.copyFileSync(hdpiPngPath, path.join(appIconPath, `/drawable-${hdpiType}/`,
					`${iconName}.png`));
			}
		}
	} catch (e) {
		throw e;
	}
}


async function updateAppIcon() {
	try {
		const uniIconPath = path.join(uniappProjectPath, '/unpackage/res/icons/');
		const appIconPath = path.join(targetDirectory, '/app/src/main/res/');
		const iconName = 'ic_launcher';
		if (fs.existsSync(uniIconPath)) {
			const tips = '发现自定义图标，开始替换...'
			const spinner = ora(tips)
			output.warn(tips, customConsoleLog)
			logger.info(tips)
			const anydpiPath = path.join(appIconPath, '/mipmap-anydpi-v26/');
			if (fs.existsSync(anydpiPath)) {
				fsExtra.emptyDirSync(anydpiPath)
				removeSyncWithRetry(anydpiPath)
			}
			await copyAppIcon('72')
			await copyAppIcon('96', 'mdpi')
			await copyAppIcon('144', 'xhdpi')
			await copyAppIcon('192', 'xxhdpi')
			await copyAppIcon('1024', 'xxxhdpi')
			const roundAnydpiPath = path.join(appIconPath, '/mipmap-anydpi-v26/ic_launcher_round.xml');
			const launcherAnydpiPath = path.join(appIconPath, '/mipmap-anydpi-v26/ic_launcher.xml');
			if (fs.existsSync(launcherAnydpiPath) && !fs.existsSync(roundAnydpiPath)) {
				fsExtra.copyFileSync(launcherAnydpiPath, roundAnydpiPath);
			}
			for (const hdpiType of ['ldpi', 'mdpi', 'hdpi', 'xhdpi', 'xxhdpi', 'xxxhdpi']) {
				const normalIconPath = path.join(appIconPath, `/mipmap-${hdpiType}/`, `${iconName}.png`);
				const roundIconPath = path.join(appIconPath, `/mipmap-${hdpiType}/`, 'ic_launcher_round.png');
				const roundWebpPath = path.join(appIconPath, `/mipmap-${hdpiType}/`, 'ic_launcher_round.webp');
				if (fs.existsSync(roundWebpPath)) {
					removeSyncWithRetry(roundWebpPath);
				}
				if (fs.existsSync(normalIconPath) && !fs.existsSync(roundIconPath)) {
					fsExtra.copyFileSync(normalIconPath, roundIconPath);
				}
			}
			spinner.succeed()
			const completeTips = '自定义图标替换完成'
			output.success(completeTips, customConsoleLog)
			logger.info(completeTips)
		}
	} catch (e) {
		throw e;
	}
}

async function batchCopyNativeResourcesIcon() {
	try {
		if (fs.existsSync(path.join(uniappProjectPath, '/nativeResources/android/res/'))) {
			const iconNames = ['push', 'push_small'];
			const hdpiTypes = ['ldpi', 'mdpi', 'hdpi', 'xhdpi', 'xxxhdpi'];
			for (let i = 0; i < iconNames.length; i++) {
				const iconName = iconNames[i];
				for (let j = 0; j < hdpiTypes.length; j++) {
					const hdpiType = hdpiTypes[j];
					await copyNativeResources(iconName, hdpiType);
					output.success(`替换${hdpiType}分辨率${iconName}图标完成`, customConsoleLog);
					logger.info(`替换${hdpiType}分辨率${iconName}图标完成`);
				}
			}
			const completeTips = '批量替换本地资源图标完成';
			output.success(completeTips, customConsoleLog);
			logger.info(completeTips);
		}
	} catch (e) {
		throw e;
	}
}

/**
 * 替换本地打包资源中的 `__UNI__` 发行包
 */
async function updateAppResources() {
	try {
		const target = path.join(targetDirectory, '/app/src/main/assets/apps/', APP_ID);
		fsExtra.emptyDirSync(path.join(targetDirectory, '/app/src/main/assets/apps/'));
		const dest = path.join(appAndroidPath, '/', APP_ID);
		await updateTargetResources(target, dest);
		await updateAppIcon()
		await batchCopyNativeResourcesIcon()
		await copyNativeResources('pushsound', '', true)
	} catch (error) {
		throw error;
	}
}

/**
 * 替换本地打包资源中的 `uniappx` 发行包
 */
async function updateUnixSrc(oraSpinner) {
	try {
		let libs = [
			'uts-runtime-release.aar',
			'android-gif-drawable-*.aar',
			'app-common-release.aar',
			'app-runtime-release.aar',
			'breakpad-build-release.aar',
			'dcloud-layout-release.aar',
			'framework-release.aar',
			'uni-exit-release.aar',
			'uni-getAccessibilityInfo-release.aar',
			'uni-getAppAuthorizeSetting-release.aar',
			'uni-getAppBaseInfo-release.aar',
			'uni-getSystemSetting-release.aar',
			'uni-openAppAuthorizeSetting-release.aar',
			'uni-prompt-release.aar',
			'uni-storage-release.aar',
			'uni-getDeviceInfo-release.aar',
			'uni-getSystemInfo-release.aar',
			'uni-getProvider-release.aar',
			'uni-rpx2px-release.aar',
			'uni-theme-release.aar'
		]
		// 判断是自定义基座还是发行包
		if (packType == 1) {
			libs.push('debug-server-release.aar')
		}
		// 拷贝libs
		await copyUnixLibs(libs);
		const unixMainDirectory = path.join(targetDirectory, '/uniappx/src/main/java');
		fsExtra.emptyDirSync(unixMainDirectory);
		fsExtra.copySync(path.join(unixAndroidPath, '/src/'), path.join(targetDirectory,
		'/uniappx/src/main/java/'));

		// 设置包名
		unixBuildGradleConfig.packageName = 'cn.uvuejs.uniappx'

		let msg = '替换uniappx页面资源完成';
		output.success(msg, customConsoleLog);
		oraSpinner.succeed(msg);
		logger.info(msg);
	} catch (e) {
		output.error(e.message, customConsoleLog);
		console.error(e);
		throw e;
	}
}

function toCamelCase(str) {
	return str.replace(/-(\w)/g, function(match, char) {
		return char.toUpperCase();
	});
}

function escapeJsonString(json) {
	// 将JSON对象转换为字符串
	let jsonString = JSON.stringify(json);

	// 替换双引号和反斜杠
	jsonString = jsonString.replace(/"/g, '\\\"').replace(/\\/g, '\\\\');

	return jsonString;
}

/**
 * 更新模块依赖
 * @param dependency
 */
function updateDependencies(dependency, type = 'app') {
	if (type === 'app') {
		if (!appBuildGradleConfig.dependencies.default.includes(dependency)) {
			appBuildGradleConfig.dependencies.default.push(dependency);
		}
	}
	if (type === 'unix') {
		if (!unixBuildGradleConfig.dependencies.default.includes(dependency)) {
			unixBuildGradleConfig.dependencies.default.push(dependency);
		}
	}
}

function updateAppDependencies(dependencies = []) {
	dependencies.map((item) => {
		updateDependencies(item);
	});
}

function getDependencyCoordinateKey(dependency) {
	if (typeof dependency !== 'string') {
		return '';
	}
	const normalized = dependency.trim();
	if (!normalized) {
		return '';
	}
	const parts = normalized.split(':');
	if (parts.length < 2) {
		return normalized;
	}
	return `${parts[0]}:${parts[1]}`;
}

const API_DEPENDENCY_KEYS = new Set([
	'com.github.mhiew:android-pdf-viewer'
]);

function buildScopedDependencies(dependencies = []) {
	return dependencies.map((dependency) => ({
		value: dependency,
		scope: API_DEPENDENCY_KEYS.has(getDependencyCoordinateKey(dependency)) ? 'api' : 'implementation'
	}));
}

function compareLooseVersions(left, right) {
	const tokenize = (value) => String(value)
		.split(/[^0-9A-Za-z]+/)
		.filter(Boolean)
		.map(item => (/^\d+$/.test(item) ? Number(item) : item.toLowerCase()));
	const leftParts = tokenize(left);
	const rightParts = tokenize(right);
	const maxLength = Math.max(leftParts.length, rightParts.length);
	for (let index = 0; index < maxLength; index += 1) {
		const leftPart = leftParts[index];
		const rightPart = rightParts[index];
		if (leftPart === undefined) return -1;
		if (rightPart === undefined) return 1;
		if (leftPart === rightPart) continue;
		if (typeof leftPart === 'number' && typeof rightPart === 'number') {
			return leftPart > rightPart ? 1 : -1;
		}
		return String(leftPart).localeCompare(String(rightPart), undefined, { numeric: true, sensitivity: 'base' });
	}
	return 0;
}

function normalizeAppDependencies() {
	const preferredDependencies = new Map();
	for (const dependency of appBuildGradleConfig.dependencies.default) {
		const key = getDependencyCoordinateKey(dependency);
		if (!key) {
			continue;
		}
		const current = preferredDependencies.get(key);
		if (!current) {
			preferredDependencies.set(key, dependency);
			continue;
		}
		if (compareLooseVersions(dependency, current) > 0) {
			preferredDependencies.set(key, dependency);
		}
	}
	appBuildGradleConfig.dependencies.default = Array.from(preferredDependencies.values());

	// 基座模式的 docs 结果里需要保留 leakcanary core，
	// 当 SDK 模板或模块推导遗漏时，这里作为最终收口保证一致性。
	if (packType == 1) {
		updateDependencies('com.squareup.leakcanary:leakcanary-android-core:2.14', 'app');
	}
	appBuildGradleConfig.dependencies.scopedDefault = buildScopedDependencies(appBuildGradleConfig.dependencies.default);
}

function normalizeModuleDependencies() {
	const preferredDependencies = new Map();
	for (const dependency of moduleBuildGradleConfig.dependencies.default) {
		const key = getDependencyCoordinateKey(dependency);
		if (!key) {
			continue;
		}
		const current = preferredDependencies.get(key);
		if (!current) {
			preferredDependencies.set(key, dependency);
			continue;
		}
		if (compareLooseVersions(dependency, current) < 0) {
			preferredDependencies.set(key, dependency);
		}
	}
	moduleBuildGradleConfig.dependencies.default = Array.from(preferredDependencies.values());
	moduleBuildGradleConfig.dependencies.scopedDefault = buildScopedDependencies(moduleBuildGradleConfig.dependencies.default);

	const implementationKeys = new Set(
		moduleBuildGradleConfig.dependencies.default
			.map(getDependencyCoordinateKey)
			.filter(Boolean)
	);
	moduleBuildGradleConfig.dependencies.compileOnly = moduleBuildGradleConfig.dependencies.compileOnly.filter(
		(dependency) => !implementationKeys.has(getDependencyCoordinateKey(dependency))
	);
}

function normalizeFinalMinSdk() {
	const minSdkCandidates = [
		Number(appBuildGradleConfig.minSdkVersion) || 0,
		...collectedModuleMinSdkVersions.map(item => Number(item) || 0)
	].filter(item => item > 0);
	if (minSdkCandidates.length > 0) {
		appBuildGradleConfig.minSdkVersion = Math.max(...minSdkCandidates);
	}
}

function ensureApplicationDisplayAttributes(appManifestContent, appName = '') {
	const appManifestDoc = new xmldom.DOMParser().parseFromString(appManifestContent);
	const applicationNode = appManifestDoc.getElementsByTagName('application')?.[0];
	if (!applicationNode) {
		return appManifestContent;
	}
	applicationNode.setAttribute('android:label', appName || '@string/app_name');
	if (!applicationNode.getAttribute('android:icon')) {
		applicationNode.setAttribute('android:icon', '@mipmap/ic_launcher');
	}
	applicationNode.setAttribute('android:roundIcon', '@mipmap/ic_launcher_round');
	const activities = applicationNode.getElementsByTagName('activity');
	let launchProxyActivity = null;
	for (let index = 0; index < activities.length; index += 1) {
		const activityNode = activities[index];
		if (activityNode.getAttribute('android:name') === 'io.dcloud.uniapp.UniLaunchProxyActivity') {
			launchProxyActivity = activityNode;
			break;
		}
	}
	if (!launchProxyActivity) {
		const activityNode = appManifestDoc.createElement('activity');
		activityNode.setAttribute('android:name', 'io.dcloud.uniapp.UniLaunchProxyActivity');
		activityNode.setAttribute('android:exported', 'true');
		launchProxyActivity = activityNode;
		applicationNode.appendChild(activityNode);
	}
	const intentFilters = launchProxyActivity.getElementsByTagName('intent-filter');
	let hasMainLauncherIntent = false;
	for (let filterIndex = 0; filterIndex < intentFilters.length; filterIndex += 1) {
		const intentFilter = intentFilters[filterIndex];
		const actions = intentFilter.getElementsByTagName('action');
		const categories = intentFilter.getElementsByTagName('category');
		const hasMainAction = Array.from(actions).some(node => node.getAttribute('android:name') === 'android.intent.action.MAIN');
		const hasLauncherCategory = Array.from(categories).some(node => node.getAttribute('android:name') === 'android.intent.category.LAUNCHER');
		if (hasMainAction && hasLauncherCategory) {
			hasMainLauncherIntent = true;
			break;
		}
	}
	if (!hasMainLauncherIntent) {
		const intentFilterNode = appManifestDoc.createElement('intent-filter');
		const actionNode = appManifestDoc.createElement('action');
		actionNode.setAttribute('android:name', 'android.intent.action.MAIN');
		const categoryNode = appManifestDoc.createElement('category');
		categoryNode.setAttribute('android:name', 'android.intent.category.LAUNCHER');
		intentFilterNode.appendChild(actionNode);
		intentFilterNode.appendChild(categoryNode);
		launchProxyActivity.insertBefore(intentFilterNode, launchProxyActivity.firstChild);
	}
	if (packType == 1) {
		const aliases = applicationNode.getElementsByTagName('activity-alias');
		let hasLeakAliasRemove = false;
		for (let index = 0; index < aliases.length; index += 1) {
			const aliasNode = aliases[index];
			if (aliasNode.getAttribute('android:name') === 'leakcanary.internal.activity.LeakLauncherActivity') {
				aliasNode.setAttribute('tools:node', 'remove');
				hasLeakAliasRemove = true;
				break;
			}
		}
		if (!hasLeakAliasRemove) {
			const aliasNode = appManifestDoc.createElement('activity-alias');
			aliasNode.setAttribute('android:name', 'leakcanary.internal.activity.LeakLauncherActivity');
			aliasNode.setAttribute('tools:node', 'remove');
			applicationNode.appendChild(aliasNode);
		}
	}
	return xmlFormatter(new xmldom.XMLSerializer().serializeToString(appManifestDoc));
}

function enableNativeLibPickFirst(pattern) {
	if (!pattern) {
		return;
	}
	if (!Array.isArray(appBuildGradleConfig.nativeLibs?.pickFirsts)) {
		appBuildGradleConfig.nativeLibs = { pickFirsts: [], excludes: [], merges: [], doNotStrips: [] };
	}
	if (!appBuildGradleConfig.nativeLibs.pickFirsts.includes(pattern)) {
		appBuildGradleConfig.nativeLibs.pickFirsts.push(pattern);
	}
}

	function pushUniqueString(list, value) {
		if (!value || typeof value !== 'string') {
			return;
		}
		if (!list.includes(value)) {
			list.push(value);
		}
	}

	function normalizeStringList(value) {
		if (Array.isArray(value)) {
			return value.filter(item => typeof item === 'string' && item.trim()).map(item => item.trim());
		}
		if (typeof value === 'string' && value.trim()) {
			return [value.trim()];
		}
		return [];
	}

	function ensureNativeLibsConfig() {
		if (!appBuildGradleConfig.nativeLibs || typeof appBuildGradleConfig.nativeLibs !== 'object') {
			appBuildGradleConfig.nativeLibs = {
				pickFirsts: [],
				excludes: [],
				merges: [],
				doNotStrips: []
			};
		}
		if (!Array.isArray(appBuildGradleConfig.nativeLibs.pickFirsts)) {
			appBuildGradleConfig.nativeLibs.pickFirsts = [];
		}
		if (!Array.isArray(appBuildGradleConfig.nativeLibs.excludes)) {
			appBuildGradleConfig.nativeLibs.excludes = [];
		}
		if (!Array.isArray(appBuildGradleConfig.nativeLibs.merges)) {
			appBuildGradleConfig.nativeLibs.merges = [];
		}
		if (!Array.isArray(appBuildGradleConfig.nativeLibs.doNotStrips)) {
			appBuildGradleConfig.nativeLibs.doNotStrips = [];
		}
		return appBuildGradleConfig.nativeLibs;
	}

	function enableNativeLibExclude(pattern) {
		pushUniqueString(ensureNativeLibsConfig().excludes, pattern);
	}

	function enableNativeLibMerge(pattern) {
		pushUniqueString(ensureNativeLibsConfig().merges, pattern);
	}

	function enableNativeLibDoNotStrip(pattern) {
		pushUniqueString(ensureNativeLibsConfig().doNotStrips, pattern);
	}

	function refreshPackagingTemplateFlags() {
		const nativeLibs = ensureNativeLibsConfig();
		if (!appBuildGradleConfig.packaging || typeof appBuildGradleConfig.packaging !== 'object') {
			appBuildGradleConfig.packaging = { jniLibsUseLegacyPackaging: undefined };
		}
		appBuildGradleConfig.packagingHasJniLibs = typeof appBuildGradleConfig.packaging.jniLibsUseLegacyPackaging === 'boolean';
		appBuildGradleConfig.hasPackagingOptions = (
			nativeLibs.pickFirsts.length > 0 ||
			nativeLibs.excludes.length > 0 ||
			nativeLibs.merges.length > 0 ||
			nativeLibs.doNotStrips.length > 0
		);
		const buildFeatures = appBuildGradleConfig.buildFeatures || { buildConfig: false };
		appBuildGradleConfig.buildFeatures = buildFeatures;
		appBuildGradleConfig.buildFeatureEntries = Object.keys(buildFeatures)
			.filter(key => key !== 'buildConfig' && Object.prototype.hasOwnProperty.call(buildFeatures, key))
			.map(key => ({
				key,
				value: buildFeatures[key] === true || buildFeatures[key] === 'true'
			}));
	}

	/**
	 * 将产物 manifest distribute.android 中的 packaging 相关字段映射到 Gradle 配置。
	 * 未配置时保持现有默认输出不变。
	 */
	function applyAndroidPackagingFromManifest(androidDistribute = {}) {
		if (!androidDistribute || typeof androidDistribute !== 'object') {
			refreshPackagingTemplateFlags();
			return;
		}
		if (!appBuildGradleConfig.aaptOptions || typeof appBuildGradleConfig.aaptOptions !== 'object') {
			appBuildGradleConfig.aaptOptions = {
				additionalParameters: ['--auto-add-overlay'],
				ignoreAssetsPattern: '!.svn:!.git:.*:!CVS:!thumbs.db:!picasa.ini:!*.scc:*~',
				noCompress: []
			};
		}
		if (!appBuildGradleConfig.packaging || typeof appBuildGradleConfig.packaging !== 'object') {
			appBuildGradleConfig.packaging = { jniLibsUseLegacyPackaging: undefined };
		}
		ensureNativeLibsConfig();

		if (typeof androidDistribute.disableLegacyPackaging === 'boolean') {
			appBuildGradleConfig.packaging.jniLibsUseLegacyPackaging = !androidDistribute.disableLegacyPackaging;
			output.info(
				`已应用 disableLegacyPackaging=${androidDistribute.disableLegacyPackaging} → useLegacyPackaging=${appBuildGradleConfig.packaging.jniLibsUseLegacyPackaging}`,
				customConsoleLog
			);
		}

		const aaptOptions = androidDistribute.aaptOptions;
		if (aaptOptions && typeof aaptOptions === 'object') {
			if (aaptOptions.additionalParameters !== undefined) {
				appBuildGradleConfig.aaptOptions.additionalParameters = normalizeStringList(aaptOptions.additionalParameters);
			}
			if (typeof aaptOptions.ignoreAssetsPattern === 'string' && aaptOptions.ignoreAssetsPattern.trim()) {
				appBuildGradleConfig.aaptOptions.ignoreAssetsPattern = aaptOptions.ignoreAssetsPattern.trim();
			}
			if (aaptOptions.noCompress !== undefined) {
				appBuildGradleConfig.aaptOptions.noCompress = [];
				normalizeStringList(aaptOptions.noCompress).forEach(item => {
					pushUniqueString(appBuildGradleConfig.aaptOptions.noCompress, item);
				});
			}
			output.info('已应用 manifest aaptOptions 配置', customConsoleLog);
		}

		const buildFeatures = androidDistribute.buildFeatures;
		if (buildFeatures && typeof buildFeatures === 'object') {
			if (!appBuildGradleConfig.buildFeatures || typeof appBuildGradleConfig.buildFeatures !== 'object') {
				appBuildGradleConfig.buildFeatures = { buildConfig: false };
			}
			Object.keys(buildFeatures).forEach((key) => {
				const incoming = buildFeatures[key];
				if (typeof incoming !== 'boolean') {
					return;
				}
				if (key === 'buildConfig') {
					appBuildGradleConfig.buildFeatures.buildConfig = Boolean(
						appBuildGradleConfig.buildFeatures.buildConfig || incoming
					);
					return;
				}
				appBuildGradleConfig.buildFeatures[key] = incoming;
			});
			output.info('已应用 manifest buildFeatures 配置', customConsoleLog);
		}

		const packagingOptions = androidDistribute.packagingOptions;
		if (packagingOptions && typeof packagingOptions === 'object') {
			normalizeStringList(packagingOptions.pickFirst).forEach(enableNativeLibPickFirst);
			normalizeStringList(packagingOptions.exclude).forEach(enableNativeLibExclude);
			normalizeStringList(packagingOptions.merge).forEach(enableNativeLibMerge);
			normalizeStringList(packagingOptions.doNotStrip).forEach(enableNativeLibDoNotStrip);
			const nativeLibs = ensureNativeLibsConfig();
			output.info(
				`已应用 manifest packagingOptions：pickFirst=${nativeLibs.pickFirsts.length}, exclude=${nativeLibs.excludes.length}, merge=${nativeLibs.merges.length}, doNotStrip=${nativeLibs.doNotStrips.length}`,
				customConsoleLog
			);
		}

		refreshPackagingTemplateFlags();
	}
const dirname = (filePath) => path.join(__dirname, filePath);

// 编译模版
const templateApp = Handlebars.compile(fs.readFileSync(dirname('./app.build.gradle.hbs'), 'utf-8'));
const templateUnix = Handlebars.compile(fs.readFileSync(dirname('./uniappx.build.gradle.hbs'), 'utf-8'));
const templateModule = Handlebars.compile(fs.readFileSync(dirname('./module.build.gradle.hbs'), 'utf-8'));
const templateRoot = Handlebars.compile(fs.readFileSync(dirname('./build.gradle.hbs'), 'utf-8'));
const templateLocalSdk = Handlebars.compile(fs.readFileSync(dirname('./local.properties.hbs'), 'utf-8'));
const templateSettings = Handlebars.compile(fs.readFileSync(dirname('./settings.gradle.hbs'), 'utf-8'));

/**
 * 编译build.gradle模板
 * @param gradlePath build.gradle 文件路径
 * @param moduleType 模块类型
 */
async function compileBuildGradle(gradlePath, moduleType = 'app') {
	try {
		if (fsExtra.existsSync(gradlePath)) {
			removeSyncWithRetry(gradlePath);
		}
		let buildGradleContent = '';
		if (moduleType === 'unix') {
			buildGradleContent = templateUnix(unixBuildGradleConfig);
		} else if (moduleType === 'module') {
			buildGradleContent = templateModule(moduleBuildGradleConfig);
		} else if (moduleType === 'root') {
			buildGradleContent = templateRoot(rootBuildGradleConfig);
		} else if (moduleType === 'settings') {
			buildGradleContent = templateSettings(baseSettingsGradle);
		} else {
			buildGradleContent = templateApp(appBuildGradleConfig);
		}

		// 将内容写入文件
		// fs.writeFileSync(gradlePath, buildGradleContent);
		fsExtra.writeFileSync(gradlePath, buildGradleContent)
	} catch (e) {
		output.info(e.message, customConsoleLog);
		console.error(e);
		throw e;
	}
}

/**
 * 编译全局模块build.gradle模板
 */
async function compileAllBuildGradle() {
	try {
		await compileBuildGradle(unixBuildGradlePath, 'unix');
		await compileBuildGradle(rootBuildGradlePath, 'root');
		await compileBuildGradle(settingsBuildGradlePath, 'settings');
		await compileBuildGradle(appBuildGradlePath);
	} catch (e) {
		throw e;
	}
}

function matchDependiesSource(source) {
	const regex = /implementation\s*['"]([^'"]+)['"]/;

	return source.match(regex)[1];
}

function collectImplementationDependenciesFromGradleObject(gradleConfig) {
	const dependencies = gradleConfig?.dependencies?.implementation;
	if (!dependencies) {
		return [];
	}

	const dependencyList = Array.isArray(dependencies) ? dependencies : [dependencies];
	return dependencyList
		.map(item => {
			if (typeof item === 'string') {
				return item;
			}
			if (item?.source) {
				const match = item.source.match(/implementation\s*(?:\(|)\s*['"]([^'"]+)['"]/);
				return match ? match[1] : null;
			}
			return null;
		})
		.map(item => item?.trim())
		.filter(item => {
			if (!item) {
				return false;
			}
			// 只回灌 docs SDK 模板里真正的 Maven 坐标。
			// 这些内容如果原样进入模板，会产生用户看到的
			// project(...)/fileTree(...)/libs.xxx/HTML 转义文本污染。
			if (item.startsWith('libs.')) {
				return false;
			}
			if (item.startsWith('project(') || item.startsWith('fileTree(') || item.startsWith('platform(')) {
				return false;
			}
			if (item.includes('&quot;') || item.includes('&#x27;') || item.includes('&#39;')) {
				return false;
			}
			return /^[A-Za-z0-9._-]+:[A-Za-z0-9._-]+:.+/.test(item);
		})
		.filter(Boolean);
}

async function importSdkTemplateGradleDependencies() {
	// docs 参考实现里的很多默认 implementation 并不是手写在 pack.js 中，
	// 而是来自离线 SDK 自带 uniappxnativepackage 的 app/uniappx build.gradle。
	// 当前项目改为“直接使用配置目录”后，若不把这些默认依赖重新导入内存配置，
	// 基座模式会缺少如 leakcanary 这类只存在于 SDK 基准 Gradle 的依赖。
	if (!useProjectLocalSdk || !baseLocalSdk.localSdk) {
		return;
	}

	const sdkRoot = path.resolve(baseLocalSdk.localSdk);
	const sdkTemplateRoot = path.join(sdkRoot, 'uniappxnativepackage');
	const appGradlePath = path.join(sdkTemplateRoot, 'app', 'build.gradle');
	const unixGradlePath = path.join(sdkTemplateRoot, 'uniappx', 'build.gradle');

	const loadDependencies = async (gradlePath) => {
		if (!fsExtra.existsSync(gradlePath)) {
			return [];
		}
		const gradleConfig = await gjs.parseFile(gradlePath);
		return collectImplementationDependenciesFromGradleObject(gradleConfig);
	};

	const [appDependencies, unixDependencies] = await Promise.all([
		loadDependencies(appGradlePath),
		loadDependencies(unixGradlePath)
	]);

	appDependencies.forEach(dependency => updateDependencies(dependency, 'app'));
	unixDependencies.forEach(dependency => updateDependencies(dependency, 'unix'));

	if (appDependencies.length > 0 || unixDependencies.length > 0) {
		output.info(
			`已从离线SDK模板导入默认依赖：app ${appDependencies.length} 项，uniappx ${unixDependencies.length} 项`,
			customConsoleLog
		);
		logger.info(
			`已从离线SDK模板导入默认依赖：app ${appDependencies.length} 项，uniappx ${unixDependencies.length} 项`
		);
	}
}

function buildAbis(abisArr) {
	// 判断是否有abis配置
	let abis = '';
	if (abisArr?.length) {
		abisArr.map(item => {
			abis += `"${item}",`
		})
		abis = removeTrailingComma(abis);
	}

	return abis
}

/**
 * 替换本地打包资源中的 `uni_modules` 发行包
 */
async function updateUniModulesSrc() {
	try {
		// 遍历uni_modules插件
		const uniModulesPath = path.join(appAndroidPath, '/', 'uni_modules');
		if (fsExtra.existsSync(uniModulesPath)) {
			const directories = await fs.promises.readdir(uniModulesPath);
			if (directories.length > 0) {
				for (item of directories) {
					initModuleBuildGradleConfig();
					// let moduleGradleConfig = moduleBuildGradleConfig
					if (item !== '.DS_Store' && await isDirectory(`${uniModulesAndroidPath(item)}`)) {
						// 从基础模块中创建该uts插件模块
						fsExtra.copySync(path.join(targetDirectory, '/', 'uni-modules-base'), path.join(
							targetDirectory, '/', item));
						// 拷贝模块的libs所有文件
						const libsPath = path.join(uniModulesAndroidPath(item), '/libs/');
						if (fs.existsSync(libsPath)) {
							fsExtra.copySync(libsPath, path.join(targetDirectory, '/', item, '/libs/'));
							// 同步主模块
							fsExtra.copySync(libsPath, path.join(targetDirectory, '/app/libs/'));
							copyUniModuleJniLibs(libsPath);
						}
						// 拷贝模块的assets所有文件
						const assetsPath = path.join(uniModulesAndroidPath(item), '/assets/');
						if (fs.existsSync(assetsPath)) {
							fsExtra.copySync(assetsPath, path.join(targetDirectory, '/', item,
								'/src/main/assets/'));
						}
						// 拷贝模块的res所有文件
						const resPath = path.join(uniModulesAndroidPath(item), '/res/');
						if (fs.existsSync(resPath)) {
							fsExtra.copySync(resPath, path.join(targetDirectory, '/', item,
								'/src/main/res/'));
						}
						// 拷贝模块的AndroidManifest.xml
						const amxPath = path.join(uniModulesAndroidPath(item), '/', 'AndroidManifest.xml');
						const targetAmxPath = path.join(targetDirectory, '/', item,
							'/src/main/AndroidManifest.xml');
						if (fs.existsSync(amxPath)) {
							fsExtra.copySync(amxPath, targetAmxPath);
						}
						// 这里需要特殊处理xml，删除package字段，并将package字段值设置到模块的build.gradle的namespace中
						const xml = await fs.promises.readFile(targetAmxPath, 'utf-8');
						// 解析 XML 字符串
						const doc = new xmldom.DOMParser().parseFromString(xml);
						// 获取所有具有指定 name 的 meta-data 元素
						const metaDataElements = doc.getElementsByTagName('manifest');
						let packageName = metaDataElements[0].getAttribute('package');
						packageName = packageName.length > 0 ? packageName :
							`uts.sdk.modules.${toCamelCase(item)}`;
						const packageNode = metaDataElements[0];
						// 删除package节点
						if (packageNode) {
							packageNode.removeAttribute('package')
						}
						// 将修改后的XML转换回字符串
						const serializer = new xmldom.XMLSerializer();
						const updatedXmlString = serializer.serializeToString(doc);
						// 写回 AndroidManifest.xml 文件
						await fs.promises.writeFile(targetAmxPath, xmlFormatter(updatedXmlString), {
							encoding: 'utf8',
						});
						// 这里是获取build.gradle文件内容并替换android节点下面的namesapce值为package
						moduleBuildGradleConfig.packageName = packageName;
						// 拷贝模块的src所有文件
						fsExtra.copySync(path.join(uniModulesAndroidPath(item), '/src/'), path.join(
							targetDirectory, '/', item, '/src/main/java/'));
						// 将该依赖追加到uniappx模块，主模块和全局settings.gradle中
						const projectContent = `:${item}`;
						if (!unixBuildGradleConfig.dependencies.project.includes(projectContent)) {
							unixBuildGradleConfig.dependencies.project.push(projectContent);
						}
						if (!appBuildGradleConfig.dependencies.project.includes(projectContent)) {
							appBuildGradleConfig.dependencies.project.push(projectContent);
						}
						if (!baseSettingsGradle.plugins.includes(projectContent)) {
							baseSettingsGradle.plugins.push(projectContent);
						}

						/**
						 * 处理uts插件依赖
						 */
						const packageJsonPath = path.join(uniappProjectPath, '/uni_modules/', item, 'package.json')

						if (fsExtra.existsSync(packageJsonPath)) {
							// const packageJson = await fs.promises.readFile(packageJsonPath, 'utf-8');
							const packageJson = fsExtra.readFileSync(packageJsonPath, 'utf-8');
							const packageObj = JSON.parse(packageJson);
							// 获取uni_modules节点的dependencies依赖
							if (packageObj['uni_modules']['dependencies']) {
								const dependencies = packageObj.uni_modules.dependencies
								// console.log(dependencies);
								dependencies.map(dependency => {
									if (!moduleBuildGradleConfig.dependencies.project.includes(
											`:${dependency}`) && hasUniModuleAndroidSource(dependency)) {
										moduleBuildGradleConfig.dependencies.project.push(`:${dependency}`);
									}
								})
							}
						}


						/**
						 * 根据uts插件中的config.json配置应用
						 */
						// 获取config.json文件
						const configJsonPath = path.join(uniModulesAndroidPath(item), '/', 'config.json')
						if (fsExtra.existsSync(configJsonPath)) {
							const json = await fs.promises.readFile(configJsonPath, 'utf-8');
							const jsonData = JSON.parse(json);
							// 判断是否有abis配置
							const abis = buildAbis(jsonData['abis']);
							moduleBuildGradleConfig.abis = abis;
							// 设置minSdk
							if (jsonData['minSdkVersion'] > 0) {
								moduleBuildGradleConfig.minSdkVersion = parseInt(jsonData['minSdkVersion']);
								collectedModuleMinSdkVersions.push(moduleBuildGradleConfig.minSdkVersion);
							}
							// 设置依赖
							if (jsonData['dependencies']?.length) {
								jsonData['dependencies'].map((item) => {
									if (item instanceof Object && item?.source) {
										if (!moduleBuildGradleConfig.dependencies.default.includes(
												matchDependiesSource(item.source))) {
											moduleBuildGradleConfig.dependencies.default.push(
												matchDependiesSource(item.source));
										}
									} else {
										if (!moduleBuildGradleConfig.dependencies.default.includes(
												item)) {
											moduleBuildGradleConfig.dependencies.default.push(item);
										}
									}
								})
							}
							// 设置默认project
							if (jsonData['project']) {
								moduleBuildGradleConfig.project.plugins = jsonData['project']?.plugins ?? [];
								rootBuildGradleConfig.project.dependencies.default = jsonData['project']
									?.dependencies ?? [];
							}
							normalizeModuleDependencies();
							// 设置hooksClass信息
							if (jsonData?.hooksClass) {
								addUtsHookClass(jsonData['hooksClass']);
							}
							// 设置uts组件信息
							if (jsonData?.components) {
								let components = escapeJsonString(jsonData['components']).replace(/\\\\/g,
									"\\\\\\");
								const configContent =
									`"String", "UTSRegisterComponents", "\\"${components}\\""`;
								appBuildGradleConfig.buildFeatures.buildConfig = true;
								if (!appBuildGradleConfig.defaultConfig.buildConfigField.includes(
										configContent)) {
									appBuildGradleConfig.defaultConfig.buildConfigField.push(configContent);
								}
							}
						}

						// console.log(moduleBuildGradleConfig);
						/**
						 * 编译所有的build.gradle文件
						 */
						const moduleBuildGradlePath = path.join(targetDirectory, '/', item, '/',
							'build.gradle');


						await compileBuildGradle(moduleBuildGradlePath, 'module');
						// initBuildConfig()
					}
				}
			}
		}
	} catch (e) {
		output.info(e.message, customConsoleLog);
		console.log(e)
		throw e;
	}
}

async function copyAppLibs(libs) {
	try {
		// app/libs 下放的是最终 app 模块直接依赖的 aar/jar。
		// 这里的输入完全来自当前配置的离线 SDK 目录，而不是 docs 缓存目录。
		for (const lib of libs) {
			const sourceDir = getSdkLibSourceDir();
			const targetDir = path.join(targetDirectory, '/app/libs/');
			await copyFilesWithGlob(sourceDir, targetDir, lib)
		}
	} catch (e) {
		output.info(e.message, customConsoleLog);
		console.log(e);
		throw e;
	}
}

async function copyUnixLibs(libs) {
	try {
		// uniappx/libs 存放基础运行时和内置模块 aar。
		for (const lib of libs) {
			const sourceDir = getSdkLibSourceDir();
			const targetDir = path.join(targetDirectory, '/uniappx/libs/');
			await copyFilesWithGlob(sourceDir, targetDir, lib)
		}
	} catch (e) {
		output.info(e.message, customConsoleLog);
		console.log(e);
		throw e;
	}
}

async function copyBuildInModuleLibs(libs) {
	await copyAppLibs(libs);
	await copyUnixLibs(libs);
}

function copyUniModuleJniLibs(libsPath) {
	const abiNames = ['arm64-v8a', 'armeabi-v7a', 'x86', 'x86_64'];

	for (const abiName of abiNames) {
		const abiPath = path.join(libsPath, abiName);
		if (!fs.existsSync(abiPath)) {
			continue;
		}

		// uni_modules 的 libs/<abi> 目录里通常是 .so，必须放进 app/src/main/jniLibs 才会被打进 APK。
		const targetAbiPath = path.join(targetDirectory, '/app/src/main/jniLibs/', abiName);
		fsExtra.ensureDirSync(targetAbiPath);
		fsExtra.copySync(abiPath, targetAbiPath);
	}
}

async function copyPlugins(plugins) {
	try {
		// Gradle 插件 jar 需要复制到生成工程的 plugins 目录下，
		// 供 root build.gradle/classpath 使用。
		for (const plugin of plugins) {
			const sourceDir = getSdkPluginSourcePath(plugin);
			const targetDir = path.join(targetDirectory, '/plugins/', plugin);
			await fsExtra.copySync(sourceDir, targetDir);
		}
	} catch (e) {
		output.info(e.message, customConsoleLog);
		console.log(e);
		logger.warn(e.stack);
		throw e;
	}
}

/**
 * 更新内置模块
 * @returns {Promise<void>}
 */
async function updateBuildInModules() {
	try {
		// 读取uniapp x项目根目录的manifest.json
		const json = await fs.promises.readFile(path.join(appAndroidPath, APP_ID, '/www/', 'manifest.json'),
			'utf-8');
		const manifest = JSON.parse(json);
		let compilerVersion = manifest['uni-app-x']?.compilerVersion ?? '0.0.1';
		/**
		 * 更新应用版本信息
		 */
		// 更新应用名
		const targetAmxPath = path.join(targetDirectory, '/app/src/main/res/values/', 'strings.xml');
		const xml = await fs.promises.readFile(targetAmxPath, 'utf-8');
		// 解析 XML 字符串
		const doc = new xmldom.DOMParser().parseFromString(xml);
		// 获取所有具有指定 name 的 string 元素
		const selectedElements = doc.documentElement.getElementsByTagNameNS('*', 'string');
		let appName = 'uniapp x';

		// 遍历并输出找到的节点
		for (let i = 0; i < selectedElements.length; i++) {
			const element = selectedElements[i];
			if (element.getAttribute('name') === 'app_name') {
				appName = manifest?.name ?? 'uniapp x';
				resolvedAppName = appName;
				element.textContent = appName;
				baseSettingsGradle.appName = appName;
				appBuildGradleConfig.defaultConfig.manifestPlaceholders.APP_NAME = appName;
				appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
			}
		}
		// 将修改后的XML转换回字符串
		const serializer = new xmldom.XMLSerializer();
		const updatedXmlString = serializer.serializeToString(doc);
		// 写回 xml 文件
		await fs.promises.writeFile(targetAmxPath, xmlFormatter(updatedXmlString), {
			encoding: 'utf8',
		});
		await syncAppNameResources(appName);
		const distribute = getManifestDistribute(manifest);
		const androidDistribute = distribute?.android ?? distribute;
		// 更新版本名称
		const resolvedVersionName = resolvedManifestMeta.versionName || manifest?.versionName || manifest?.version?.name;
		if (resolvedVersionName) {
			appBuildGradleConfig.versionName = resolvedVersionName;
		}
		// 更新版本号
		const resolvedVersionCode = resolvedManifestMeta.versionCode || manifest?.versionCode || manifest?.version?.code;
		if (resolvedVersionCode) {
			appBuildGradleConfig.versionCode = resolvedVersionCode;
		}
		// 更新minSdkVersion
		if (androidDistribute?.minSdkVersion) {
			appBuildGradleConfig.minSdkVersion = Number(androidDistribute.minSdkVersion)
		}
		// 更新targetSdkVersion
		if (androidDistribute?.targetSdkVersion) {
			appBuildGradleConfig.targetSdkVersion = androidDistribute.targetSdkVersion
		}

		// 更新CPU列表
		// if (manifest?.app?.distribute?.android?.abiFilters) {
		// 	appBuildGradleConfig.abis = buildAbis(manifest.app.distribute.android.abiFilters)
		// }
		appBuildGradleConfig.abis = buildAbis(androidDistribute?.abiFilters ?? ['arm64-v8a'])
		applyAndroidPackagingFromManifest(androidDistribute);
		const projectFiles = [
			'plugins/uts-kotlin-compiler-plugin-0.0.1.jar',
			'plugins/uts-kotlin-gradle-plugin-0.0.1.jar'
		];
		projectFiles.map(item => {
			if (!rootBuildGradleConfig.project.dependencies.files.includes(item)) {
				rootBuildGradleConfig.project.dependencies.files.push(item);
			}
		});
		// 更新uniapp模块gradle配置
		if (!unixBuildGradleConfig.project.plugins.includes('io.dcloud.uts.kotlin')) {
			unixBuildGradleConfig.project.plugins.push('io.dcloud.uts.kotlin');
		}
		const generatedSourceRoot = path.join(targetDirectory, '/uniappx/src/main/java');
		let mainConfig = normalizeModuleConfig({
			...buildModuleConfig(manifest, packConfig),
			...inferModulesFromGeneratedExtApi(generatedSourceRoot)
		});
		/**
		 * 更新内置模块信息
		 */
		if (mainConfig) {
			const modules = mainConfig;
			const registerComponents = [];
			const utsEasyCom = [];
			const utsRegisterProviders = [];
			const utsHooksClassArray = [];
			const moduleLibs = Object.keys(modules)
				.filter(moduleName => moduleName.startsWith('uni-'))
				.filter(moduleName => shouldCopyModuleLib(moduleName))
				.map(moduleName => `${moduleName}-release.aar`);
			Object.keys(modules).forEach(pushModuleMissingLibError);
			await copyBuildInModuleLibs(moduleLibs);
			// uni-ad 模块
			if (modules['uni-ad']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-ad-release.aar',
					'uni-ad-splash-release.aar',
					'uniad-native-release.aar'
				]);
				const module = modules['uni-ad'];
				// 腾讯优量汇广告联盟
				if (module?.gdt) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-gdt-release.aar',
						'GDTSDK.unionNormal.aar'
					]);
				}
				// 穿山甲
				if (module?.gm) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-gromore-release.aar',
						'open_ad_sdk.aar'
					]);
				}
				// 快手
				if (module?.ks) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-ks-release.aar',
						'ks_adsdk-ad.aar'
					]);
				}
				// 百度
				if (module?.bd) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-bd-release.aar',
						'Baidu_MobAds_SDK.aar'
					]);
				}
				// sigmob
				if (module?.sgm) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-sgm-release.aar',
						'windAd.aar',
						'wind-common.aar'
					]);
				}
				// 华为
				if (module?.hw) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-hw-release.aar'
					]);
					// 同步线上依赖
					updateAppDependencies([
						'com.huawei.hms:ads-lite:13.4.66.300'
					])
				}
				// 章鱼
				if (module?.octopus) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'octopus_ad_sdk_1.6.1.6.aar',
						'uniad-zy-release.aar'
					]);
				}
				// 倍孜
				if (module?.beizi) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'beizi_ad_sdk_3.5.0.11.aar',
						'beizi_fusion_sdk_4.90.4.11.aar',
						'uniad_bz_adapter_4.90.4.0.aar'
					]);
				}
				// 泛连
				if (module?.funlink) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'Funlink_2.7.9_release.aar',
						'Funlink_adapter_uniad_2.7.9.aar'
					]);
				}
				// 聚力阅盟
				if (module?.ym) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'YmDCloudymSdk20240617.aar'
					]);
				}
				// google
				if (module?.google) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uniad-google-release.aar'
					]);
					// 同步线上依赖
					updateAppDependencies([
						'androidx.constraintlayout:constraintlayout:2.1.3',
						'com.google.android.gms:play-services-ads:23.3.0'
					])
				}
				// Pangle
				if (module?.pangle) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'admob-pangle-adapter.aar',
						'uniad-pangle-release.aar',
						'open_ad_sdk_pg.aar'
					]);
					// 同步线上依赖
					updateAppDependencies([
						'com.google.android.gms:play-services-ads-identifier:18.0.0'
					])
				}
				// InMobi
				if (module?.inmobi) {
					// 同步线上依赖
					updateAppDependencies([
						'com.google.ads.mediation:inmobi:10.7.5.0'
					])
				}
				// ironSource
				if (module?.ironsource) {
					// 同步线上依赖
					updateAppDependencies([
						'com.google.ads.mediation:ironsource:8.2.1.0'
					])
				}
				// Liftoff
				if (module?.liftoff) {
					// 同步线上依赖
					updateAppDependencies([
						'com.google.ads.mediation:vungle:7.4.0.1'
					])
				}
				// Mintegral
				if (module?.mintegral) {
					// 同步线上依赖
					updateAppDependencies([
						'com.google.ads.mediation:mintegral:16.8.41.0'
					])
				}
				// unity
				if (module?.unity) {
					// 同步线上依赖
					updateAppDependencies([
						'com.unity3d.ads:unity-ads:4.12.1',
						'com.google.ads.mediation:unity:4.12.2.0'
					])
				}
				// 添加联盟ID
				if (!module?.DCLOUDUnionId) {
					const error =
						'【uni-ad】请在项目manifest.json文件中的app -> distribute -> modules -> uni-ad -> 节点下添加 DCLOUDUnionId 的值，示例：DCLOUDUnionId: "xxx"。 说明：联盟ID位于：[uni-AD后台](https://uniad.dcloud.net.cn/)->首页->联盟ID';
					pushConfigError(error);
				} else {
					appBuildGradleConfig.buildFeatures.buildConfig = true;
					appBuildGradleConfig.defaultConfig.buildConfigField.push(
						`"String", "DCLOUDUnionId", "\\"${module?.DCLOUDUnionId ?? ''}\\""`
					)
				}
				// 组件注册
				appBuildGradleConfig.buildFeatures.buildConfig = true;
				registerComponents.push(
					`{\\\\\\"name\\\\\\":\\\\\\"ad\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniAd.AdComponent\\\\\\"}`
				)
			}
			// uni-facialRecognitionVerify 模块
			if (modules['uni-facialRecognitionVerify']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'APSecuritySDK-DeepSec-*.jiagu.aar',
					'Android-AliyunFaceGuard-*.aar',
					'aliyun-base-*.aar',
					'aliyun-facade-*.aar',
					'aliyun-face-*.aar',
					'aliyun-faceaudio-*.aar',
					'aliyun-facelanguage-*.aar',
					'aliyun-photinus-*.aar',
					'aliyun-wishverify-*.aar',
					'facialRecognitionVerify-support-release.aar',
					// 'uni-facialRecognitionVerify-release.aar'
					'uni-facialVerify-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.squareup.okhttp3:okhttp:3.11.0',
					'com.squareup.okio:okio:1.14.0',
					'com.alibaba:fastjson:1.2.83_noneautotype',
					'com.aliyun.dpa:oss-android-sdk:2.9.11'
				]);
			}
			// uni-payment
			if (modules['uni-payment']) {
				const module = modules['uni-payment'];
				if (!module?.alipay && !module?.wxpay) {
					pushConfigError('【uni-payment】已自动识别到支付模块，但无法自动判断支付平台，请在可视化配置或 JSON 配置中至少选择 wxpay 或 alipay。');
				}
				// 支付宝支付
				if (module?.alipay) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uni-payment-release.aar',
						'uni-payment-alipay-release.aar'
					]);
					// 同步线上依赖
					updateAppDependencies([
						'com.alipay.sdk:alipaysdk-android:15.8.17'
					]);
					// 插件注册
					utsRegisterProviders.push(
						`{\\\\\\"name\\\\\\":\\\\\\"alipay\\\\\\",\\\\\\"service\\\\\\":\\\\\\"payment\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniPaymentAlipay.UniPaymentAlipayProviderImpl\\\\\\"}`
					);
				}
				if (module?.wxpay) {
					// 这里是同步本地依赖库的步骤
					await copyAppLibs([
						'uni-payment-release.aar',
						'uni-payment-wxpay-release.aar'
					]);
					// 同步线上依赖
					updateAppDependencies([
						'com.tencent.mm.opensdk:wechat-sdk-android:6.8.0'
					])
					// 插件注册
					utsRegisterProviders.push(
						`{\\\\\\"name\\\\\\":\\\\\\"wxpay\\\\\\",\\\\\\"service\\\\\\":\\\\\\"payment\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniPaymentWxpay.UniPaymentWxpayProviderImpl\\\\\\"}`
					);
				}
			}
			// uni-push
			if (modules['uni-push']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-push-release.aar',
					'gt-lib.aar'
				]);
				// Gradle配置
				// rootBuildGradleConfig.repositories.jcenter = true;
				// rootBuildGradleConfig.repositories.google = true;
				const maven = 'https://mvn.getui.com/nexus/content/repositories/releases';
				if (!baseSettingsGradle.repositories.maven.includes(maven)) {
					baseSettingsGradle.repositories.maven.push(maven);
				}
				const module = modules['uni-push'];
				const manifestPlaceholders = appBuildGradleConfig.defaultConfig.manifestPlaceholders;
				if (!module?.GETUI_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 GETUI_APPID 的值，示例：GETUI_APPID: "xxx"。GETUI_APPID与PUSH_APPID在[开发者中心](https://dev.dcloud.net.cn/)->uni-push->2.0->消息推送->配置管理->应用配置->AppID，请务必填写一致。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.GETUI_APPID = module?.GETUI_APPID ?? '';
				}

				if (!module?.PUSH_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 PUSH_APPID 的值，示例：PUSH_APPID: "xxx"。GETUI_APPID与PUSH_APPID在[开发者中心](https://dev.dcloud.net.cn/)->uni-push->2.0->消息推送->配置管理->应用配置->AppID，请务必填写一致。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.PUSH_APPID = module?.PUSH_APPID ?? '';
				}

				if (!module?.dcloud_unipush_auto_notification) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 dcloud_unipush_auto_notification 的值，示例：dcloud_unipush_auto_notification: true。透传时是否自动创建通知，布尔类型。'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.dcloud_unipush_auto_notification = module
						?.dcloud_unipush_auto_notification ?? false;
				}

				if (!module?.MIPUSH_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 MIPUSH_APPID 的值，示例：MIPUSH_APPID: "xxx"。小米推送APPID。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.MIPUSH_APPID = module?.MIPUSH_APPID ?? '';
				}

				if (!module?.MIPUSH_APPKEY) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 MIPUSH_APPKEY 的值，示例：MIPUSH_APPKEY: "xxx"。小米推送APPKEY。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.MIPUSH_APPKEY = module?.MIPUSH_APPKEY ?? '';
				}

				if (!module?.MEIZUPUSH_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 MEIZUPUSH_APPID 的值，示例：MEIZUPUSH_APPID: "xxx"。魅族推送APPID。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.MEIZUPUSH_APPID = module?.MEIZUPUSH_APPID ?? '';
				}

				if (!module?.MEIZUPUSH_APPKEY) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 MEIZUPUSH_APPKEY 的值，示例：MEIZUPUSH_APPKEY: "xxx"。魅族推送APPKEY。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.MEIZUPUSH_APPKEY = module?.MEIZUPUSH_APPKEY ?? '';
				}

				if (!module?.OPPOPUSH_APPKEY) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 OPPOPUSH_APPKEY 的值，示例：OPPOPUSH_APPKEY: "xxx"。OPPO推送APPKEY。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.OPPOPUSH_APPKEY = module?.OPPOPUSH_APPKEY ?? '';
				}

				if (!module?.OPPOPUSH_APPSECRET) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 OPPOPUSH_APPSECRET 的值，示例：OPPOPUSH_APPSECRET: "xxx"。OPPO推送APPSECRET。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.OPPOPUSH_APPSECRET = module?.OPPOPUSH_APPSECRET ?? '';
				}

				if (!module?.HUAWEI_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 HUAWEI_APPID 的值，示例：HUAWEI_APPID: "xxx"。华为推送APPID。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.HUAWEI_APPID = module?.HUAWEI_APPID ?? '';
				}

				if (!module?.VIVO_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 VIVO_APPID 的值，示例：VIVO_APPID: "xxx"。VIVO推送APPID。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.VIVO_APPID = module?.VIVO_APPID ?? '';
				}

				if (!module?.VIVO_APIKEY) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 VIVO_APIKEY 的值，示例：VIVO_APIKEY: "xxx"。VIVO推送APIKEY。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.VIVO_APIKEY = module?.VIVO_APIKEY ?? '';
				}

				if (!module?.HIHONOR_APPID) {
					const error =
						'【uni-push】请在项目manifest.json文件中的app -> distribute -> modules -> uni-push 节点下添加 HIHONOR_APPID 的值，示例：HIHONOR_APPID: "xxx"。荣耀推送APPID。参考：[uni-push2.0配置](https://uniapp.dcloud.net.cn/unipush-v2.html#%E7%AC%AC%E4%BA%8C%E6%AD%A5-%E9%85%8D%E7%BD%AE)'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					manifestPlaceholders.HIHONOR_APPID = module?.HIHONOR_APPID ?? '';
				}

				// 同步线上依赖
				updateAppDependencies([
					'com.getui:gtc:3.2.13.0',
					'com.getui:gtsdk:3.3.6.0'
				]);

				// 华为额外配置
				// rootBuildGradleConfig.project.repositories.jcenter = true;
				// rootBuildGradleConfig.project.repositories.google = true;
				// const huaweiDependency = 'https://developer.huawei.com/repo/';
				// if (!baseSettingsGradle.repositories.maven.includes(huaweiDependency)) {
				// 	baseSettingsGradle.repositories.maven.push(huaweiDependency);
				// }
				// const dependency = 'com.huawei.agconnect:agcp:1.6.0.300';
				const dependencies = [
					'com.android.tools.build:gradle:8.2.0',
					'com.huawei.agconnect:agcp:1.9.1.301'
				];
				dependencies.map(dependency => {
					if (!rootBuildGradleConfig.project.dependencies.default.includes(dependency)) {
						rootBuildGradleConfig.project.dependencies.default.push(dependency);
					}
				})
				// if (!rootBuildGradleConfig.repositories.maven.includes(huaweiDependency)) {
				// 	rootBuildGradleConfig.repositories.maven.push(huaweiDependency);
				// }
				const plugins = [
					'com.android.application',
					'com.huawei.agconnect'
				];
				// plugins.map(item => {
				// 	if (!appBuildGradleConfig.applyPlugins.includes(item)) {
				// 		appBuildGradleConfig.applyPlugins.push(item);
				// 	}
				// });
				// 拷贝华为推送配置文件
				const agconnectServicesJsonPath = path.join(appAndroidPath, APP_ID, '/www/static/',
					'agconnect-services.json');
				if (!fs.existsSync(agconnectServicesJsonPath)) {
					const error =
						'华为推送配置文件不存在，请登录华为的AppGallery Connect网站，找到需要集成华为推送的应用，在“项目设置 > 常规”页面的“应用”区域，点击 `agconnect-services.json` 下载配置文件。并拷贝到项目下的 `static` 目录下。';
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					await fsExtra.copySync(agconnectServicesJsonPath, path.join(targetDirectory, '/',
						'agconnect-services.json'));
				}
			}
			// uni-video 模块
			if (modules['uni-video']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-video-release.aar',
					'ijkplayer.aar',
					'videoplayer.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.github.bumptech.glide:glide:4.9.0',
					'androidx.annotation:annotation:1.1.0',
					'androidx.core:core:1.1.0'
				]);
				// 组件注册
				appBuildGradleConfig.buildFeatures.buildConfig = true;
				registerComponents.push(
					`{\\\\\\"name\\\\\\":\\\\\\"video\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniVideo.VideoComponent\\\\\\"}`
				)
			}
			// uni-verify模块
			if (modules['uni-verify']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-verify-release.aar',
					'GY-*-release.aar'
				]);
				// 同步线上依赖
				// baseSettingsGradle.repositories.jcenter = true;
				// baseSettingsGradle.repositories.google = true;
				const maven = 'https://mvn.getui.com/nexus/content/repositories/releases';
				if (!baseSettingsGradle.repositories.maven.includes(maven)) {
					baseSettingsGradle.repositories.maven.push(maven);
				}
				updateAppDependencies([
					'com.getui:gtc:3.2.13.0'
				]);
				const module = modules['uni-verify'];
				if (!module?.GETUI_APPID) {
					const error =
						'【uni-verify】请在项目manifest.json文件中的app -> distribute -> modules -> uni-verify 节点下添加 GETUI_APPID 的值，示例：GETUI_APPID: "xxx"。GETUI_APPID与PUSH_APPID在[开发者中心](https://dev.dcloud.net.cn/)->一键登录->基础配置->一键登录应用ID，GETUI_APPID与GY_APP_ID取值相同。'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					appBuildGradleConfig.defaultConfig.manifestPlaceholders.GETUI_APPID = module.GETUI_APPID;
				}

				if (!module?.GY_APP_ID) {
					const error =
						'【uni-verify】请在项目manifest.json文件中的app -> distribute -> modules -> uni-verify 节点下添加 GY_APP_ID 的值，示例：GY_APP_ID: "xxx"。GETUI_APPID与GY_APP_ID在[开发者中心](https://dev.dcloud.net.cn/)->一键登录->基础配置->一键登录应用ID，GETUI_APPID与GY_APP_ID取值相同。'
					if (!errors.includes(error)) {
						errors.push(error);
					}
				} else {
					appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = true;
					appBuildGradleConfig.defaultConfig.manifestPlaceholders.GY_APP_ID = module.GY_APP_ID;
				}
			}
			// uni-createRequestPermissionListener模块
			if (modules['uni-createRequestPermissionListener']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-createRequestPermissionListener-release.aar'
				])
			}
			// uni-createWebviewContext模块
			if (modules['uni-createWebviewContext']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-createWebviewContext-release.aar'
				])
				// 同步线上依赖
				updateAppDependencies([
					'androidx.webkit:webkit:1.6.0'
				]);
			}
			// uni-fileSystemManager模块，uni-previewImage模块，uni-openDocument依赖于该模块
			if (modules['uni-fileSystemManager']
			|| modules['uni-previewImage']
			|| modules['uni-openDocument']
			|| modules['uni-live-pusher']
			) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-fileSystemManager-release.aar'
				])
				// 同步线上依赖
				updateAppDependencies([
					'org.brotli:dec:0.1.2'
				]);
			}
			// uni-getLocation-system模块，uni-chooseLocation模块依赖于该模块
			if (modules['uni-getLocation'] || modules['uni-chooseLocation']) {
				const locationModule = modules['uni-getLocation'] ?? { system: {} };
				if (locationModule['tencent'] && !getTencentLBSAPIKey()) {
					pushConfigError('【uni-getLocation】已选择腾讯定位，请在【模块服务商配置参数】中填写 TencentLBSAPIKey。');
				}
				// 这里是同步本地依赖库的步骤
				if (compilerVersion >= '4.61') {
					if (locationModule['system']) {
						await copyAppLibs([
							'uni-location-release.aar',
							'uni-location-system-release.aar'
						])
						utsRegisterProviders.push(
							`{\\\\\\"name\\\\\\":\\\\\\"system\\\\\\",\\\\\\"service\\\\\\":\\\\\\"location\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniLocationSystem.UniLocationSystemProviderImpl\\\\\\"}`
						);
					}
					if (locationModule['tencent']) {
						await copyAppLibs([
							'uni-location-release.aar',
							'uni-location-tencent-release.aar'
						]);
						utsRegisterProviders.push(
							`{\\\\\\"name\\\\\\":\\\\\\"tencent\\\\\\",\\\\\\"service\\\\\\":\\\\\\"location\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniLocationTencent.UniLocationTencentProviderImpl\\\\\\"}`
						);
					}
				} else {
					if (locationModule['system']) {
						await copyAppLibs([
							'uni-getLocation-system-release.aar'
						]);
						utsRegisterProviders.push(
							`{\\\\\\"name\\\\\\":\\\\\\"system\\\\\\",\\\\\\"service\\\\\\":\\\\\\"location\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniGetLocationSystem.UniLocationSystemProviderImpl\\\\\\"}`
						);
					}
					if (locationModule['tencent']) {
						await copyAppLibs([
							'uni-getLocation-tencent-release.aar'
						]);
						utsRegisterProviders.push(
							`{\\\\\\"name\\\\\\":\\\\\\"tencent\\\\\\",\\\\\\"service\\\\\\":\\\\\\"location\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniGetLocationTencent.UniLocationTencentProviderImpl\\\\\\"}`
						);
					}
				}
			}
			// uni-getNetworkType模块
			if (modules['uni-getNetworkType']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-getNetworkType-release.aar'
				])
			}
			// uni-installApk模块
			if (modules['uni-installApk']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-installApk-release.aar'
				])
			}
			// uni-network模块，uni-cloudClient模块、uni-createInnerAudioContext模块、uni-getBackgroundAudioManager模块、uni-previewImage模块依赖于该模块
			if (
				modules['uni-network'] ||
				modules['uni-cloudClient'] ||
				modules['uni-createInnerAudioContext'] ||
				modules['uni-getBackgroundAudioManager'] ||
				modules['uni-previewImage'] ||
				modules['uni-live-pusher']
			) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-network-release.aar'
				])
				// 同步线上依赖
				updateAppDependencies([
					'com.squareup.okhttp3:okhttp:3.12.12'
				]);
			}
			// uni-websocket模块，uni-cloudClient模块依赖于uni-websocket模块
			if (modules['uni-websocket'] || modules['uni-cloudClient']) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-websocket-release.aar'
				])
				// 同步线上依赖
				updateAppDependencies([
					'com.squareup.okhttp3:okhttp:3.12.12'
				]);
			}
			// uni-media模块，uni-camera模块、uni-cloudClient模块、uni-previewImage模块、uni-scanCode模块依赖于该模块
			if (
				modules['uni-media'] ||
				modules['uni-camera'] ||
				modules['uni-cloudClient'] ||
				modules['uni-previewImage'] ||
				modules['uni-scanCode'] ||
				modules['uni-phoneContact']
			) {
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-media-release.aar',
					'nativeobj-preview-release.aar'
				])
				// 同步线上依赖
				updateAppDependencies([
					'com.github.bumptech.glide:glide:4.9.0',
					'androidx.recyclerview:recyclerview:1.0.0',
					'androidx.appcompat:appcompat:1.6.1',
					'androidx.activity:activity-ktx:1.9.2'
				]);
			}
			// uni-cloud-client模块
			if (modules['uni-cloudClient']) {
				// 检查依赖模块
				// if (!modules['uni-media']) {
				// 	const error =
				// 		`【uni-cloudClient】该模块依赖【uni-media】模块，请在项目manifest.json文件中的app -> distribute -> modules添加【uni-media】模块，示例："uni-media": {}`
				// 	if (!errors.includes(error)) {
				// 		errors.push(error);
				// 	}
				// } else if (!modules['uni-network']) {
				// 	const error =
				// 		`【uni-cloudClient】该模块依赖【uni-network】模块，请在项目manifest.json文件中的app -> distribute -> modules添加【uni-network】模块，示例："uni-network": {}`
				// 	if (!errors.includes(error)) {
				// 		errors.push(error);
				// 	}
				// } else if (!modules['uni-map-tencent']) {
				// 	const error =
				// 		`【uni-cloudClient】该模块依赖【uni-map-tencent】模块，请在项目manifest.json文件中的app -> distribute -> modules添加【uni-map-tencent】模块，示例："uni-map-tencent": {}`
				// 	if (!errors.includes(error)) {
				// 		errors.push(error);
				// 	}
				// } else {
				// 	// 这里是同步本地依赖库的步骤
				// 	await copyAppLibs([
				// 		'uni-cloud-client-release.aar'
				// 	])
				// }
				// 这里是同步本地依赖库的步骤
				await copyAppLibs([
					'uni-cloud-client-release.aar'
				])
			}
			// uni-canvas模块
			if (modules['uni-canvas']) {
				// 同步本地依赖库
				await copyAppLibs([
					'uni-canvas-release.aar',
					'uni-canvas-component-release.aar'
				])
				// 组件注册
				appBuildGradleConfig.buildFeatures.buildConfig = true;
				registerComponents.push(
					`{\\\\\\"name\\\\\\":\\\\\\"canvas\\\\\\",\\\\\\"class\\\\\\":\\\\\\"io.dcloud.canvas.CanvasComponent\\\\\\",\\\\\\"node\\\\\\":\\\\\\"io.dcloud.canvas.UniCanvasElementImpl\\\\\\"}`
					)
			}
			// uni-map-tencent模块，uni-cloudClient模块依赖于uni-map-tencent模块
			if (modules['uni-map-tencent'] || modules['uni-cloudClient']) {
				if (!getTencentLBSAPIKey()) {
					pushConfigError('【uni-map-tencent】已自动识别到腾讯地图模块，请在【模块服务商配置参数】中填写 TencentLBSAPIKey。');
				}
				// 同步本地依赖
				await copyAppLibs([
					'uni-map-tencent-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.tencent.map:tencent-map-vector-sdk:5.6.0',
					'com.tencent.map:sdk-utilities:1.0.9',
					'com.tencent.map.geolocation:TencentLocationSdk-openplatform:7.5.4.3',
					'com.github.bumptech.glide:glide:4.16.0'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniMapTencent.UniMapTencentExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-privacy模块
			if (modules['uni-privacy']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-privacy-release.aar'
				]);
			}
			// uni-getProvider模块
			if (modules['uni-getProvider']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-getProvider-release.aar'
				]);
			}
			// uni-shareWithSystem模块
			if (modules['uni-shareWithSystem']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-shareWithSystem-release.aar'
				]);
				// utsHooksClassArray注册
				utsHooksClassArray.push(
					`{\\"uts.sdk.modules.uniShareWithSystem.ShareWithSystemHook\\"}`
				);
			}
			// uni-chooseLocation模块
			if (modules['uni-chooseLocation']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-chooseLocation-release.aar'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniChooseLocation.UniChooseLocationExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-createInnerAudioContext模块
			if (modules['uni-createInnerAudioContext']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-createInnerAudioContext-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.google.android.exoplayer:exoplayer-core:2.18.0'
				]);
			}
			// uni-getBackgroundAudioManager模块
			if (modules['uni-getBackgroundAudioManager']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-getBackgroundAudioManager-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.google.android.exoplayer:exoplayer-core:2.18.0'
				]);
			}
			// uni-actionSheet模块，uni-previewImage模块、uni-chooseMedia模块依赖于该模块
			if (
				modules['uni-actionSheet'] ||
				modules['uni-previewImage'] ||
				modules['uni-chooseMedia']
			) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-actionSheet-release.aar'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniActionSheet.UniActionSheetExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-previewImage模块
			if (modules['uni-previewImage']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-previewImage-release.aar'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniPreviewImage.UniPreviewImageExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-chooseMedia模块
			if (modules['uni-chooseMedia']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-chooseMedia-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'androidx.appcompat:appcompat:1.6.1',
					'androidx.activity:activity-ktx:1.9.2'
				]);
			}
			// uni-arrayBufferToBase64模块
			if (modules['uni-arrayBufferToBase64']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-arrayBufferToBase64-release.aar'
				]);
			}
			// uni-base64ToArrayBuffer
			if (modules['uni-base64ToArrayBuffer']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-base64ToArrayBuffer-release.aar'
				]);
			}
			// uni-sse模块
			if (modules['uni-sse']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-sse-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.squareup.okhttp3:okhttp-sse:3.12.12'
				]);
			}
			// uni-modal模块
			if (modules['uni-modal']) {
				// 同步本地依赖
				await copyBuildInModuleLibs([
					'uni-modal-release.aar'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniModal.UniModalExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-camera模块，uni-barcode-scanning模块，uni-scanCode模块依赖该模块
			if (modules['uni-camera'] ||
				modules['uni-barcode-scanning'] ||
				modules['uni-scanCode']
			) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-camera-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'androidx.camera:camera-core:1.4.1',
					'androidx.camera:camera-camera2:1.4.1',
					'androidx.camera:camera-lifecycle:1.4.1',
					'androidx.camera:camera-view:1.4.1',
					'androidx.appcompat:appcompat:1.7.0'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniCamera.UniCameraExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-requestMerchantTransfer模块
			if (modules['uni-requestMerchantTransfer']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-requestMerchantTransfer-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.tencent.mm.opensdk:wechat-sdk-android:6.8.0'
				]);
			}
			// uni-recorder模块
			if (modules['uni-recorder']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-recorder-release.aar',
					'audio-mp3aac-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'com.google.android.exoplayer:exoplayer-core:2.18.0'
				]);
			}
			// uni-makePhoneCall模块
			if (modules['uni-makePhoneCall']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-makePhoneCall-release.aar'
				]);
			}
			// uni-clipboard模块
			if (modules['uni-clipboard']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-clipboard-release.aar'
				]);
			}
			// uni-keyboard模块
			if (modules['uni-keyboard']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-keyboard-release.aar'
				]);
			}
			// uni-openDocument模块
			if (modules['uni-openDocument']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-openDocument-release.aar'
				]);
				// utsHooksClassArray注册
				utsHooksClassArray.push(
					`{\\"uts.sdk.modules.DCloudUniOpenDocument.UniOpenDocumentHookProxy\\"}`
				);
			}
			// uni-barcode-scanning模块，uni-scanCode模块依赖该模块
			if (modules['uni-barcode-scanning'] || modules['uni-scanCode']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-barcode-scanning-release.aar'
				]);
				// 同步线上依赖
				updateAppDependencies([
					'androidx.camera:camera-core:1.4.1',
					'com.google.mlkit:barcode-scanning:17.2.0',
					'com.github.albfernandez:juniversalchardet:2.0.4'
				]);
				// utsHooksClassArray注册
				utsHooksClassArray.push(
					`{\\"uts.sdk.modules.DCloudUniBarcodeScanning.AppHookProxy\\"}`
				);
			}
			// uni-match-media模块
			if (modules['uni-match-media']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-match-media-release.aar'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"type\\\\\\":\\\\\\"customElement\\\\\\",\\\\\\"name\\\\\\":\\\\\\"match-media\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniMatchMedia.UniMatchMediaElementRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-scanCode模块
			if (modules['uni-scanCode']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-scanCode-release.aar'
				]);
				// 同步线上依赖
				await updateAppDependencies([
					'androidx.camera:camera-core:1.4.1',
					'androidx.appcompat:appcompat:1.7.0'
				]);
				// easycom注册
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniScanCode.UniScanCodeExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					)
			}
			// uni-rich-text模块
			if (modules['uni-rich-text']) {
				// 同步本地依赖
				await copyAppLibs([
					'uni-rich-text-release.aar'
				]);
				// easycom注册
				if (compilerVersion >= '5.0') {
					utsEasyCom.push(
						`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniRichText.UniRichTextExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					);
				} else {
					utsEasyCom.push(
						`{\\\\\\"type\\\\\\":\\\\\\"customElement\\\\\\",\\\\\\"name\\\\\\":\\\\\\"rich-text\\\\\\",\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniRichText.UniRichTextElementRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
					);
				}
			}
			// uni.showLoading/uni.hideLoading 在 HBuilderX 5.x 中拆成独立 ext API AAR。
			if (modules['uni-showLoading']) {
				await copyBuildInModuleLibs([
					'uni-showLoading-release.aar',
					'uni-loading-release.aar'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniShowLoading.UniShowLoadingExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniLoading.UniLoadingExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-live-player模块
			if (modules['uni-live-player']) {
				await copyAppLibs([
					'uni-live-player-release.aar'
				]);
				updateAppDependencies([
					'com.qiniu:qplayer2-core:1.5.0'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniLivePlayer.UniLivePlayerExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-live-pusher模块
			if (modules['uni-live-pusher']) {
				await copyAppLibs([
					'uni-live-pusher-release.aar',
					'pldroid-media-streaming-*.jar'
				]);
				updateAppDependencies([
					'androidx.core:core:1.10.1',
					'android.arch.lifecycle:extensions:1.1.1',
					'com.qiniu:happy-dns:1.0.0'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniLivePusher.UniLivePusherExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-web-view模块
			if (modules['uni-web-view']) {
				await copyAppLibs([
					'uni-web-view-release.aar'
				]);
				updateAppDependencies([
					'androidx.webkit:webkit:1.6.0',
					'androidx.appcompat:appcompat:1.1.0'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniWebView.UniWebViewExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-page-container模块
			if (modules['uni-page-container']) {
				await copyAppLibs([
					'uni-page-container-release.aar'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniPageContainer.UniPageContainerExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-editor模块
			if (modules['uni-editor']) {
				await copyAppLibs([
					'uni-editor-release.aar'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniEditor.UniEditorExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// uni-picker模块
			if (modules['uni-picker']) {
				await copyAppLibs([
					'uni-picker-release.aar'
				]);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniPicker.UniPickerExtApiComponentsRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
				utsEasyCom.push(
					`{\\\\\\"class\\\\\\":\\\\\\"uts.sdk.modules.DCloudUniPicker.UniPickerExtApiPagesRegister\\\\\\",\\\\\\"method\\\\\\":\\\\\\"register\\\\\\"}`
				);
			}
			// 组件注册
			appBuildGradleConfig.buildFeatures.buildConfig = true;
			if (registerComponents.length > 0) {
				appBuildGradleConfig.defaultConfig.buildConfigField.push(
					`"String", "UTSRegisterComponents", "\\"[${registerComponents.toString()}]\\""`
				);
			}
			// easycom注册
			if (utsEasyCom.length > 0) {
				appBuildGradleConfig.defaultConfig.buildConfigField.push(
					`"String", "UTSEasyCom", "\\"[${utsEasyCom.toString()}]\\""`
				);
			}
			// registerProvider注册
			if (utsRegisterProviders.length > 0) {
				appBuildGradleConfig.defaultConfig.buildConfigField.push(
					`"String", "UTSRegisterProvider", "\\"[${utsRegisterProviders.toString()}]\\""`
				);
			}
				// utsHooksClassArray注册
				if (utsHooksClassArray.length > 0) {
					utsHooksClassArray.forEach(addUtsHookClass);
				}
			}
		// console.log(appBuildGradleConfig)
	} catch (e) {
		output.error(e.message, customConsoleLog);
		console.error(e)
		throw e;
	}
}

let checkPass = false;

function checkLocalResources() {
	const checkResourcesExistsMessage = customSetStatusMessage?.('开始校对本地资源...');
	const checkResourcesExistsSpinner = ora('开始校对本地资源...').start();
	logger.info('开始校对本地资源...');
	if (!checkResourcesExists()) {
		let tips =
			`本地打包资源不存在，请选中项目然后顶部菜单点击【发行】->【原生App-本地打包】->【生成本地打包App资源】先打包本地资源，参考 ${encodeURI('https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源')}`;
		output.error(tips, customConsoleLog);
		logger.error(tips);
		checkResourcesExistsMessage?.dispose();
		checkResourcesExistsSpinner.fail(tips);
		checkPass = false;
		return;
	}
	const prefix = '__UNI__';
	// 遍历目录
	const directories = (fsExtra.readdirSync(appAndroidPath)).filter(file => file.toString().startsWith(
		prefix));

	if (directories.length === 0) {
		output.error('未发现UNI应用资源包', customConsoleLog);
		checkResourcesExistsSpinner.fail('未发现UNI应用资源包');
		logger.error('未发现UNI应用资源包');
		return;
	}

	APP_ID = directories[0];
	loadResolvedManifestMeta();
	checkResourcesExistsSpinner.succeed();
	checkResourcesExistsMessage?.dispose();
	checkPass = true;
}

/**
 * 校验SDK版本
 */
async function compileSDKVersion() {
	/**
	 * 获取编译器版本
	 */
	// 读取uniapp x项目根目录的manifest.json
	const json = fsExtra.readFileSync(path.join(appAndroidPath, APP_ID, '/www/', 'manifest.json'),
		'utf-8');
	const manifest = JSON.parse(json);
	const compilerVersion = manifest['uni-app-x']['compilerVersion'];
	/**
	 * 获取SDK版本
	 */
	const sdkSplitRes = SDK_UNZIP_NAME.split('-');
	// console.log(SDK_UNZIP_NAME);
	// console.log(sdkSplitRes);
	let sdkVersion = sdkSplitRes[sdkSplitRes.length - 1];
	if (sdkVersion < 3) {
		sdkVersion = sdkSplitRes[sdkSplitRes.length - 2];
	}
	if (sdkVersion != compilerVersion) {
		// output.error(`自定义基座SDK版本【${sdkVersion}】与编译器版本【${compilerVersion}】不一致，请重新打包本地资源，参考 ${encodeURI('https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源')}`, customConsoleLog);
		if (hx != null) {
			checkPass = false;
			let result = await hx.window.showWarningMessage(
				`自定义基座SDK版本【${sdkVersion}】与编译器版本【${compilerVersion}】不一致，参考 <a href="https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源">${encodeURI('https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源')}</a>，是否继续打包？`,
				['继续打包', '终止打包']);
			if (result === '继续打包') {
				output.warn(
					`自定义基座SDK版本【${sdkVersion}】与编译器版本【${compilerVersion}】不一致，参考 ${encodeURI('https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源')}`,
					customConsoleLog);
				checkPass = true;
			} else {
				output.error(
					`自定义基座SDK版本【${sdkVersion}】与编译器版本【${compilerVersion}】不一致，请重新打包本地资源，参考 ${encodeURI('https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源')}`,
					customConsoleLog);
				checkPass = false;
				return;
			}
		} else {
			output.error(
				`自定义基座SDK版本【${sdkVersion}】与编译器版本【${compilerVersion}】不一致，请重新打包本地资源，参考 ${encodeURI('https://nativesupport.dcloud.net.cn/AppDocs/importfeproject/export.html#生成本地打包-app-资源')}`,
				customConsoleLog);
		}
	}
}

async function buildUnix() {
	// 这里只负责“生成原生 Gradle 工程所需内容”：
	// 1. 同步 app/uniappx/uni_modules 资源
	// 2. 根据模块与 packType 计算依赖、manifest placeholders、gradle 模板
	// 3. 生成所有模块的 build.gradle/settings.gradle
	// 不负责最终 assemble/package，最终编译在 startBuild -> execLocalPack。
	await copyPlugins([
		'uts-kotlin-compiler-plugin-0.0.1.jar',
		'uts-kotlin-gradle-plugin-0.0.1.jar'
	]);

	const updateAppidMessage = customSetStatusMessage?.('开始查找替换应用ID...');
	const updateAppidSpinner = ora('开始查找替换应用ID...').start();
	logger.info('开始查找替换应用ID...');
	await updateAppid(updateAppidSpinner);
	updateAppidMessage?.dispose();
	const updateAppResourcesMessage = customSetStatusMessage?.('开始替换应用发行资源...');
	const updateAppResourcesSpinner = ora('开始替换应用发行资源...').start();
	logger.info('开始替换应用发行资源...');
	await updateAppResources();
	updateAppResourcesMessage?.dispose();
	updateAppResourcesSpinner.succeed();
	output.success('替换应用发行资源完成', customConsoleLog);
	logger.info('替换应用发行资源完成');
	const updateUnixSrcMessage = customSetStatusMessage?.('开始替换uniappx发行资源...');
	const updateUnixSrcSpinner = ora('开始替换uniappx发行资源...').start();
	logger.info('开始替换uniappx发行资源...');
	await updateUnixSrc(updateUnixSrcSpinner);
	updateUnixSrcMessage?.dispose();
	const updateUniModulesSrcMessage = customSetStatusMessage?.('开始替换uni_modules发行资源...');
	const updateUniModulesSrcSpinner = ora('开始替换uni_modules发行资源...').start();
	logger.info('开始替换uni_modules发行资源...');
	await updateUniModulesSrc();
	updateUniModulesSrcMessage?.dispose();
	updateUniModulesSrcSpinner.succeed();
	output.success('替换uni_modules发行资源完成', customConsoleLog);
	logger.info('替换uni_modules发行资源完成');
	const updateBuildInModulesMessage = customSetStatusMessage?.('开始同步app模块配置发行资源...');
	const updateBuildInModulesSpinner = ora('开始同步app模块配置发行资源...').start();
	logger.info('开始同步app模块配置发行资源...');
	await updateBuildInModules();
	updateBuildInModulesMessage?.dispose();
	updateBuildInModulesSpinner.succeed();
	output.success('同步app模块配置发行资源完成', customConsoleLog);
	logger.info('同步app模块配置发行资源完成');
	const compileAllBuildGradleMessage = customSetStatusMessage?.('开始编译所有模块的build.gradle配置...');
	const compileAllBuildGradleSpinner = ora('开始编译所有模块的build.gradle配置...').start();
	logger.info('开始编译所有模块的build.gradle配置...');
		normalizeFinalMinSdk();
		normalizeAppDependencies();
		appBuildGradleConfig.defaultConfig.manifestPlaceholderEntries = buildManifestPlaceholderEntries();
		appBuildGradleConfig.defaultConfig.allowManifestPlaceholders = appBuildGradleConfig.defaultConfig.manifestPlaceholderEntries.length > 0;
		refreshPackagingTemplateFlags();
		output.info(`最终app最小minSdk：${appBuildGradleConfig.minSdkVersion}`, customConsoleLog);
		output.info(`最终app abiFilters：${appBuildGradleConfig.abis || '未配置'}`, customConsoleLog);
		output.info(`最终签名别名：${appBuildGradleConfig.keyStore.keyAlias || '未配置'}`, customConsoleLog);
	applyUtsHookClasses();
	await compileAllBuildGradle();
	compileAllBuildGradleSpinner.succeed();
	compileAllBuildGradleMessage?.dispose();
	logger.info('编译所有模块的build.gradle配置完成');
	output.success('编译所有模块的build.gradle配置完成', customConsoleLog);
}

async function startBuild() {
	const previousCwd = shelljs.pwd().toString();
	try {
		await initLocalSdk();
		await buildUnix()
		shelljs.cd(targetDirectory);
		if (errors.length > 0) {
			let errMsg = '项目发现以下错误，请根据指导解决后重新运行！';
			output.error(errMsg, customConsoleLog);
			ora('项目发现以下错误，请根据指导解决后重新运行！').info();
			errors.map(item => {
				ora(item).fail();
				output.error(item, customConsoleLog);
			});
			return;
		}
		const tips = `原生工程项目配置完成，工程路径：${targetDirectory}`;
		output.success(tips, customConsoleLog);
		logger.info(tips);
		ora(tips).succeed();
		return targetDirectory;
	} catch (e) {
		output.error(e.message, customConsoleLog);
		console.error(e);
		logger.error(e.stack);
	} finally {
		if (previousCwd && shelljs.pwd().toString() !== previousCwd) {
			shelljs.cd(previousCwd);
		}
	}
}

async function initLocalSdk() {
	try {
		let content = templateLocalSdk({
			localSdk: baseLocalSdk.androidSdk || ''
		});
		if (process.platform === 'win32') {
			content = content.replace(/\\/g, '\\\\');
		}
		// 将内容写入文件
		await fs.writeFileSync(path.join(targetDirectory, '/', 'local.properties'), content);
	} catch (error) {
		logger.error(error.stack);
	}
}

async function handleSDKUpdate() {
	if (useProjectLocalSdk && baseLocalSdk.localSdk) {
		// 当前项目只支持“直接使用配置中的离线 SDK 目录”。
		// 这里不再下载、不再缓存、不再复制，只校验关键目录完整性。
		const sdkRoot = path.resolve(baseLocalSdk.localSdk);
		const requiredFiles = ANDROID_SDK_REQUIRED_FILES.filter(item => !fsExtra.existsSync(path.join(sdkRoot, item)));
		if (requiredFiles.length > 0) {
			throw new Error(`当前项目配置的离线SDK不完整：${sdkRoot}，缺少：${requiredFiles.join('、')}`);
		}
		SDK_UNZIP_NAME = path.basename(sdkRoot);
		await importSdkTemplateGradleDependencies();
		checkPass = true;
		const tips = `使用项目配置的离线SDK：${sdkRoot}`;
		output.success(tips, customConsoleLog);
		logger.info(tips);
		return;
	}
	throw new Error('当前项目仅支持使用配置中的本地离线SDK目录，不再执行SDK下载、复制或解压流程。');
}

async function start(options = {}) {
	try {
		// 这是当前项目内 Android 生成链的唯一主入口。
		// Electron 主进程会把“配置窗口中的环境设置”和“当前项目的打包参数”
		// 整理成 options 传进来。这里最重要的几个字段是：
		// 1. baseProjectRoot: 基座模板目录，当前固定来自 docs/src/easypackx
		// 2. uniappxNativeAndroid: 输出根目录，当前为 packPath/appid
		// 3. uniappProjectPath: 选中的 uni-app x 项目目录
		// 4. androidLocalSdk: 配置窗口中的 uniAndroidSDK
		// 5. javaHome: 配置窗口中的 JDKPath
		// 6. packType: 1=基座, 2=正式包
		// 7. customConsoleLog: 发回渲染层日志窗口的桥接函数
		packConfig = options;
		initBuildConfig();
		local_pack = true;
		if (options?.uniappProjectPath) {
			uniappProjectPath = path.resolve(options.uniappProjectPath);

		}
		if (options?.sdkDownloadUrl) {
			SDK_DOWNLOAD_URL = options.sdkDownloadUrl;
		}
		if (options?.root) {
			_ROOT_ = path.resolve(options.root);
			baseProjectRoot = path.resolve(options.root);
			sdkWorkspaceRoot = path.resolve(options.root);
			if (options?.uniappxNativeAndroid) {
				targetDirectory = path.join(path.resolve(options.uniappxNativeAndroid), NATIVE_ANDROID_PROJECT_NAME)
			} else {
				targetDirectory = path.join(_ROOT_, NATIVE_ANDROID_PROJECT_NAME);
			}
		}
		if (options?.baseProjectRoot) {
			baseProjectRoot = path.resolve(options.baseProjectRoot);
		}
		if (options?.sdkWorkspaceRoot) {
			sdkWorkspaceRoot = path.resolve(options.sdkWorkspaceRoot);
		}
		if (options?.androidLocalSdk) {
			baseLocalSdk.localSdk = path.resolve(options.androidLocalSdk);
		}
		if (options?.androidSdk) {
			baseLocalSdk.androidSdk = path.resolve(options.androidSdk);
		}
		if (options?.javaHome) {
			baseLocalSdk.javaHome = path.resolve(options.javaHome);
		}
		if (options?.customConsoleLog) {
			customConsoleLog = options.customConsoleLog;
		}
		if (options?.customSetStatusMessage) {
			customSetStatusMessage = options.customSetStatusMessage;
		}
		if (options?.hx) {
			hx = options.hx;
		}
		// if (options?.javaHome) {
		// 	if (process.platform === 'win32') {
		// 		// process.env.JAVA_HOME = options.javaHome.replace(/\\/g, '\\\\');
		// 		localPackCommand += `-Dorg.gradle.java.home=${options.javaHome.replace(/\\/g, '\\\\')}`
		// 	} else {
		// 		options.javaHome = path.join(options.javaHome, '/Contents/Home/');
		// 		// process.env.JAVA_HOME = options.javaHome;
		// 		localPackCommand += `-Dorg.gradle.java.home=${options.javaHome}`
		// 	}
		// }
		if (options?.androidPackageName) {
			appBuildGradleConfig.packageName = options.androidPackageName
		}
		if (Array.isArray(options?.nativeLibPickFirsts)) {
			options.nativeLibPickFirsts.forEach(enableNativeLibPickFirst);
		}
		if (options?.storePath) {
			storePath = options.storePath
		}
		if (options?.storePassword) {
			appBuildGradleConfig.keyStore.storePassword = options.storePassword
		}
		if (options?.keyAlias) {
			appBuildGradleConfig.keyStore.keyAlias = options.keyAlias
		}
		if (options?.keyPassword) {
			appBuildGradleConfig.keyStore.keyPassword = options.keyPassword
		}
		if (options?.packType) {
			packType = options.packType
		}
		// 当前项目只生成 Gradle 工程，不继续自动编译；
		// packType 只影响资源/依赖/gradle 分支，不影响是否执行 gradle。
		packType = packType == 2 ? 2 : 1
		output.info(`当前项目目录：${uniappProjectPath}`, customConsoleLog);
		output.info(`当前输出目录：${targetDirectory}`, customConsoleLog);
		output.info(`当前基座模板目录：${baseProjectRoot}`, customConsoleLog);
		output.info(`当前SDK工作目录：${sdkWorkspaceRoot}`, customConsoleLog);
		output.info(`当前SDK模式：${useProjectLocalSdk ? '直接使用配置目录' : '使用本地缓存/下载模式'}`, customConsoleLog);
		output.info(`当前离线SDK：${baseLocalSdk.localSdk || '未配置'}`, customConsoleLog);
		output.info(`当前JDK：${baseLocalSdk.javaHome || options.javaHome || '未配置'}`, customConsoleLog);
		output.info('当前打包模式：仅生成Gradle工程，不执行Gradle编译', customConsoleLog);
		// initConfig 会按 packType 重建路径、Gradle 命令和部分运行时状态；
		// 调试基座/正式包差异时，这里是最先需要确认的切换点。
		initConfig(options);
		checkLocalResources();
		if (!checkPass) return;
		
		logger.info('开始校验SDK版本...');
		await handleSDKUpdate();
		if (!checkPass) return;
		if (hx != null) {
			if (hx.workspace.getConfiguration().get('easypackx.validateSDKVersion') === true) {
				await compileSDKVersion();
			}
		}
		if (!checkPass) return;
		const safeWorkspaceDir = _ROOT_ || baseProjectRoot || process.cwd();
		if (shelljs.pwd().toString() !== safeWorkspaceDir) {
			shelljs.cd(safeWorkspaceDir);
		}
		// shelljs.exec(`rm -rf ${targetDirectory}`);
		await deleteFile(targetDirectory)
		const target = path.join(baseProjectRoot, 'uniappx-native-android-base');
		const dest = targetDirectory;
		fsExtra.copySync(target, dest);
		// macos设置gradlew 执行权限
		if (process.platform === 'darwin') {
			shelljs.chmod('-R', '777', `${dest}/gradlew`)
		}
		// 复制keystore文件
		const appStorePath = path.join(dest, '/app/debug.keystore')
		if (storePath && fsExtra.pathExistsSync(appStorePath)) {
			removeSyncWithRetry(appStorePath)
			fsExtra.copySync(storePath, path.join(dest, '/app/debug.keystore'))
		}
		if (packType === 2) {
			removeSyncWithRetry(path.join(dest, '/app/src/main/res/drawable/icon.png'))
		}
		return await startBuild();
	} catch (e) {
		customConsoleLog?.(e.message);
		console.error(e);
		logger.error(e.stack);
	}
}

module.exports = {
	start
}
