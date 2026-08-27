const { execFileSync, spawnSync } = require('child_process');
const crypto = require('crypto');
const fs = require('fs');
const path = require('path');
const axios = require('axios');
const fsExtra = require('fs-extra');
const ora = require('ora');
const unZipService = require('./utils/unzipService');
const { deleteFile, getLastDirName } = require('./utils/io');
const { output } = require('./utils/output');
const { logger } = require('../log/logger');

const DEFAULT_IOS_SDK_URL = 'https://web-ext-storage.dcloud.net.cn/uni-app-x/sdk/iOS/UniAppX-iOS%405.07.zip';
const OLD_DEFAULT_IOS_SDK_URL = 'https://web-ext-storage.dcloud.net.cn/uni-app-x/sdk/iOS/UniAppX-iOS@5.07.zip';
const NATIVE_IOS_PROJECT_NAME = 'uniappx-native-ios';
const DEFAULT_IOS_BUNDLE_ID = 'cn.testapp.app';
const IOS_UTS_TEMPLATE_NAME = 'unimoduleUniGetbatteryinfo';
const CUSTOM_UTS_FRAMEWORKS_DIR = 'CustomUTSFrameworks';
const IOS_SIMULATOR_EXCLUDED_ARCHS = 'arm64';

let root = process.cwd();
let targetDirectory = path.join(process.cwd(), NATIVE_IOS_PROJECT_NAME);
let sdkDownloadUrl = DEFAULT_IOS_SDK_URL;
let sdkUnzipName = '';
let customConsoleLog = null;
let customSetStatusMessage = null;
let hx = null;

function logInfo(message) {
	output.info(message, customConsoleLog);
	logger.info(message);
}

function logSuccess(message) {
	output.info(message, customConsoleLog);
	logger.info(message);
}

function logWarn(message) {
	output.info(`警告：${message}`, customConsoleLog);
	logger.warn(message);
}

function logCommandOutput(message, log = logInfo) {
	const text = String(message || '').trim();
	if (!text) {
		return;
	}
	text.split(/\r?\n/).forEach(line => log(line));
}

function ensureMacOS() {
	if (process.platform !== 'darwin') {
		throw new Error('iOS 原生工程只能在 macOS 上生成和构建。');
	}
}

function normalizeIosSdkUrl(url) {
	if (url === OLD_DEFAULT_IOS_SDK_URL) {
		return DEFAULT_IOS_SDK_URL;
	}
	return url || '';
}

function readJsonFile(filePath, fallback = {}) {
	try {
		if (!fs.existsSync(filePath)) {
			return fallback;
		}
		return JSON.parse(fs.readFileSync(filePath, 'utf-8'));
	} catch (error) {
		throw new Error(`读取 JSON 失败：${filePath}，${error.message}`);
	}
}

function writeJsonFile(filePath, data) {
	fsExtra.ensureDirSync(path.dirname(filePath));
	fs.writeFileSync(filePath, `${JSON.stringify(data, null, 2)}\n`, 'utf-8');
}

function toPosixPath(filePath) {
	return filePath.split(path.sep).join('/');
}

function makePbxId(seed) {
	return crypto.createHash('sha1').update(seed).digest('hex').slice(0, 24).toUpperCase();
}

function replaceAll(content, search, replacement) {
	return content.split(search).join(replacement);
}

function shouldCopySdkItem(item) {
	const basename = path.basename(item);
	return basename !== '.DS_Store' && !item.includes(`${path.sep}.git${path.sep}`);
}

function setBuildSettingInAllConfigurations(content, key, value) {
	const quotedKey = key.includes('[') ? `"${key}"` : key;
	const escapedKey = key.replace(/[.*+?^${}()|[\]\\]/g, '\\$&');
	const settingRegex = new RegExp(`\\n\\t\\t\\t\\t"?${escapedKey}"? = [^;]+;`);

	return content.replace(/(\n\t\t\tbuildSettings = \{\n)([\s\S]*?)(\n\t\t\t\};)/g, (match, start, body, end) => {
		if (settingRegex.test(body)) {
			return `${start}${body.replace(settingRegex, `\n\t\t\t\t${quotedKey} = ${value};`)}${end}`;
		}
		return `${start}\t\t\t\t${quotedKey} = ${value};\n${body}${end}`;
	});
}

function sanitizeIosModuleName(name) {
	// DCloud iOS UTS 示例工程使用 unimodule + 插件名驼峰命名，避免原始 uni_modules 名里的横线破坏 Swift/Obj-C 模块校验。
	const words = String(name || '')
		.split(/[^A-Za-z0-9]+/)
		.filter(Boolean);
	const camelName = words.map(word => `${word.charAt(0).toUpperCase()}${word.slice(1)}`).join('');
	const moduleName = `unimodule${camelName || 'UtsModule'}`;
	return /^[A-Za-z_]/.test(moduleName) ? moduleName : `_${moduleName}`;
}

function getBundleIdSuffix(name) {
	return String(name || '')
		.toLowerCase()
		.replace(/[^a-z0-9]+/g, '-')
		.replace(/^-+|-+$/g, '') || 'uts-module';
}

function normalizeDeploymentTarget(value) {
	const raw = String(value || '').trim();
	if (!raw) {
		return '12.0';
	}
	const number = Number(raw);
	if (!Number.isFinite(number) || number <= 0) {
		return '12.0';
	}
	const iosMinimum = Math.max(number, 12);
	return iosMinimum % 1 === 0 ? `${iosMinimum}.0` : String(iosMinimum);
}

function findAppIdDirectory(resourcePath) {
	if (!fs.existsSync(resourcePath)) {
		return '';
	}

	const entries = fs.readdirSync(resourcePath, { withFileTypes: true });
	const appEntry = entries.find(entry => entry.isDirectory() && entry.name.startsWith('__UNI__'));
	return appEntry ? path.join(resourcePath, appEntry.name) : '';
}

function getAppResourceInfo(uniappProjectPath) {
	const appIosPath = path.join(uniappProjectPath, 'unpackage', 'resources', 'app-ios');
	const legacyResourcesPath = path.join(uniappProjectPath, 'unpackage', 'resources');
	const appIdDirectory = findAppIdDirectory(appIosPath) || findAppIdDirectory(legacyResourcesPath);
	if (!appIdDirectory) {
		throw new Error(`未找到 iOS 本地资源，请先在 HBuilderX 发行 iOS 本地资源。已检查：${appIosPath} 和 ${legacyResourcesPath}`);
	}

	const manifestPath = path.join(appIdDirectory, 'www', 'manifest.json');
	const manifest = readJsonFile(manifestPath);
	const resourceRoot = path.dirname(appIdDirectory);
	return {
		appIosPath: resourceRoot,
		resourceLayout: resourceRoot === appIosPath ? 'app-ios' : 'legacy-resources',
		appIdDirectory,
		manifestPath,
		manifest,
		appId: manifest.id || path.basename(appIdDirectory),
		appName: manifest.name || 'UniAppX'
	};
}

function getSdkCacheRoot() {
	return path.join(root, 'SDK', 'uniappx-ios');
}

function getSdkZipPath() {
	const zipName = sdkDownloadUrl.startsWith('http')
		? unZipService.getFileName(sdkDownloadUrl, true)
		: `${unZipService.getArchiveName(sdkDownloadUrl)}.zip`;
	return path.join(getSdkCacheRoot(), zipName);
}

function getDecodedDirectoryName(name) {
	try {
		return decodeURIComponent(name);
	} catch (_) {
		return name;
	}
}

function findExistingSdkRoot(sdkLibsRoot, preferredName) {
	const names = [...new Set([
		preferredName,
		getDecodedDirectoryName(preferredName)
	].filter(Boolean))];
	for (const name of names) {
		const candidate = path.join(sdkLibsRoot, name);
		if (!fs.existsSync(candidate)) {
			continue;
		}
		try {
			return findPreparedSdkRoot(candidate);
		} catch (_) {
			// 目录名可能命中但结构不完整，继续尝试其它候选目录。
		}
	}
	return '';
}

function findPreparedSdkRoot(candidateDir) {
	const requiredEntries = ['UniAppXDemo', 'SDK', 'TemporarySampleFramework', 'UTSPluginExample'];
	const candidates = [candidateDir];
	if (fs.existsSync(candidateDir)) {
		const entries = fs.readdirSync(candidateDir, { withFileTypes: true });
		for (const entry of entries) {
			if (entry.isDirectory() && !['__MACOSX', '.git'].includes(entry.name)) {
				candidates.push(path.join(candidateDir, entry.name));
			}
		}
	}

	const sdkRoot = candidates.find(item => requiredEntries.every(entry => fs.existsSync(path.join(item, entry))));
	if (!sdkRoot) {
		throw new Error(`iOS SDK 目录结构无效，未找到 UniAppXDemo/SDK/TemporarySampleFramework/UTSPluginExample：${candidateDir}`);
	}
	return sdkRoot;
}

async function downloadFile(url, outputPath) {
	fsExtra.ensureDirSync(path.dirname(outputPath));
	const response = await axios({
		url,
		method: 'GET',
		responseType: 'stream'
	});
	if (response.status < 200 || response.status >= 300) {
		throw new Error(`iOS SDK 下载失败：${response.status} ${response.statusText}`);
	}

	await new Promise((resolve, reject) => {
		const writeStream = fs.createWriteStream(outputPath);
		response.data.pipe(writeStream);
		writeStream.on('finish', resolve);
		writeStream.on('error', reject);
	});
}

async function prepareIosSdk() {
	const sdkCacheRoot = getSdkCacheRoot();
	const sdkLibsRoot = path.join(sdkCacheRoot, 'libs');
	fsExtra.ensureDirSync(sdkLibsRoot);

	if (sdkDownloadUrl.startsWith('http')) {
		const zipPath = getSdkZipPath();
		sdkUnzipName = unZipService.getFileName(sdkDownloadUrl, false);
		if (!fs.existsSync(zipPath)) {
			const spinner = ora('开始下载 uni-app x iOS 离线 SDK...').start();
			customSetStatusMessage?.('开始下载 uni-app x iOS 离线 SDK...');
			await downloadFile(sdkDownloadUrl, zipPath);
			spinner.succeed('uni-app x iOS 离线 SDK 下载完成');
		} else {
			logWarn('uni-app x iOS 离线 SDK 已存在，跳过下载');
		}
		const cachedSdkRoot = findExistingSdkRoot(sdkLibsRoot, sdkUnzipName);
		if (cachedSdkRoot) {
			return cachedSdkRoot;
		}
		const mainFolder = await unZipService.unzip(zipPath, sdkLibsRoot);
		const sdkDir = path.join(sdkLibsRoot, mainFolder || getDecodedDirectoryName(sdkUnzipName));
		return findPreparedSdkRoot(sdkDir);
	}

	if (!fs.existsSync(sdkDownloadUrl)) {
		throw new Error(`iOS SDK 路径不存在：${sdkDownloadUrl}`);
	}

	if (await unZipService.isCompressedFile(sdkDownloadUrl)) {
		const zipPath = getSdkZipPath();
		sdkUnzipName = unZipService.getArchiveName(sdkDownloadUrl);
		if (!fs.existsSync(zipPath)) {
			await fsExtra.copy(sdkDownloadUrl, zipPath);
		}
		const cachedSdkRoot = findExistingSdkRoot(sdkLibsRoot, sdkUnzipName);
		if (cachedSdkRoot) {
			return cachedSdkRoot;
		}
		const mainFolder = await unZipService.unzip(zipPath, sdkLibsRoot);
		const sdkDir = path.join(sdkLibsRoot, mainFolder || getDecodedDirectoryName(sdkUnzipName));
		return findPreparedSdkRoot(sdkDir);
	}

	sdkUnzipName = getLastDirName(sdkDownloadUrl);
	return findPreparedSdkRoot(sdkDownloadUrl);
}

function getIosModules(appIosPath) {
	const modulesRoot = path.join(appIosPath, 'uni_modules');
	if (!fs.existsSync(modulesRoot)) {
		return [];
	}

	return fs.readdirSync(modulesRoot, { withFileTypes: true })
		.filter(entry => entry.isDirectory() && entry.name !== '.DS_Store')
		.map(entry => {
			const moduleRoot = path.join(modulesRoot, entry.name, 'utssdk', 'app-ios');
			const sourcePath = path.join(moduleRoot, 'src', 'index.swift');
			const sanitizedName = sanitizeIosModuleName(entry.name);
			return {
				name: entry.name,
				sanitizedName,
				root: moduleRoot,
				sourcePath,
				exists: fs.existsSync(moduleRoot),
				hasSource: fs.existsSync(sourcePath),
				config: readJsonFile(path.join(moduleRoot, 'config.json'), {})
			};
		})
		.filter(item => item.exists && item.hasSource);
}

function writeFile(filePath, content) {
	fsExtra.ensureDirSync(path.dirname(filePath));
	fs.writeFileSync(filePath, content, 'utf-8');
}

function getManifestModules(manifest) {
	return Object.keys(manifest?.['app-ios']?.distribute?.modules || {}).sort();
}

function getBundleId(options, manifest) {
	return options.iosBundleId
		|| manifest?.['app-ios']?.distribute?.ios?.bundleIdentifier
		|| manifest?.['app-ios']?.distribute?.ios?.id
		|| DEFAULT_IOS_BUNDLE_ID;
}

function getCompilerVersion(manifest) {
	return manifest?.['uni-app-x']?.compilerVersion || '5.07';
}

function runPlutil(args) {
	execFileSync('plutil', args, { stdio: 'pipe' });
}

function patchPlistString(plistPath, key, value) {
	runPlutil(['-replace', key, '-string', String(value), plistPath]);
}

function patchInfoPlist(projectDir, resourceInfo, bundleId) {
	const plistPath = path.join(projectDir, 'UniAppXDemo', 'Info.plist');
	if (!fs.existsSync(plistPath)) {
		throw new Error(`未找到 iOS 模板 Info.plist：${plistPath}`);
	}

	// 只覆盖与当前 App 强相关的字段，其他隐私权限和模块配置保留官方模板默认值。
	patchPlistString(plistPath, 'CFBundleDisplayName', resourceInfo.appName);
	patchPlistString(plistPath, 'CFBundleName', resourceInfo.appName);
	patchPlistString(plistPath, 'CFBundleIdentifier', bundleId);
	patchPlistString(plistPath, 'CFBundleShortVersionString', resourceInfo.manifest?.version?.name || '1.0.0');
	patchPlistString(plistPath, 'CFBundleVersion', resourceInfo.manifest?.version?.code || 1);
	patchPlistString(plistPath, 'uniapp-x.appid', resourceInfo.appId);
	patchPlistString(plistPath, 'uniapp-x.uniRuntimeVersion', getCompilerVersion(resourceInfo.manifest));
}

function updateProjectFile(projectDir, bundleId, resourceInfo) {
	const pbxprojPath = path.join(projectDir, 'UniAppXDemo.xcodeproj', 'project.pbxproj');
	if (!fs.existsSync(pbxprojPath)) {
		throw new Error(`未找到 iOS 模板工程文件：${pbxprojPath}`);
	}

	let content = fs.readFileSync(pbxprojPath, 'utf-8');
	content = content.replace(/PRODUCT_BUNDLE_IDENTIFIER = [^;]+;/g, `PRODUCT_BUNDLE_IDENTIFIER = ${bundleId};`);
	content = content.replace(/MARKETING_VERSION = [^;]+;/g, `MARKETING_VERSION = ${resourceInfo.manifest?.version?.name || '1.0.0'};`);
	content = content.replace(/CURRENT_PROJECT_VERSION = [^;]+;/g, `CURRENT_PROJECT_VERSION = ${resourceInfo.manifest?.version?.code || 1};`);
	// DCloud 5.07 iOS SDK 的部分模拟器依赖仅包含 x86_64 slice，Apple Silicon 上需排除 arm64 模拟器架构。
	content = setBuildSettingInAllConfigurations(content, 'EXCLUDED_ARCHS[sdk=iphonesimulator*]', IOS_SIMULATOR_EXCLUDED_ARCHS);
	fs.writeFileSync(pbxprojPath, content, 'utf-8');
}

function patchUniAppBridge(projectDir) {
	const bridgePath = path.join(projectDir, 'UniAppXDemo', 'UniAppBridge.swift');
	if (!fs.existsSync(bridgePath)) {
		throw new Error(`未找到 iOS 模板桥接文件：${bridgePath}`);
	}

	let content = fs.readFileSync(bridgePath, 'utf-8');
	if (content.includes('createUniAppRootViewController()')) {
		return;
	}

	const marker = '    /// 退出 UniApp\n';
	const method = `    /// 创建 uni-app x 根控制器，作为独立 App 直接启动，避免进入 DCloud SDK 示例按钮页。
    public static func createUniAppRootViewController() -> UIViewController {
        if UniSDKEngine.shared.getAppManager()?.getCurrentApp() == nil {
            // 直接作为 App 启动时没有按钮触发 start，需要先确保 app 实例已创建。
            UniSDKEngine.shared.getAppManager()?.create()
        }
        return UniAppRootViewController()
    }

`;
	if (!content.includes(marker)) {
		throw new Error(`iOS 模板桥接文件结构异常，缺少退出 UniApp 标记：${bridgePath}`);
	}

	content = content.replace(marker, `${method}${marker}`);
	fs.writeFileSync(bridgePath, content, 'utf-8');
}

function patchAutoLaunchAppDelegate(projectDir) {
	const appDelegatePath = path.join(projectDir, 'UniAppXDemo', 'AppDelegate.m');
	if (!fs.existsSync(appDelegatePath)) {
		throw new Error(`未找到 iOS 模板 AppDelegate：${appDelegatePath}`);
	}

	const content = `//
//  AppDelegate.m
//  UniAppXDemo
//
//  EasyPackX 自动生成：直接启动当前 uni-app x 应用，不显示 DCloud SDK 示例入口。
//

#import "AppDelegate.h"
#import "UniAppX-Swift.h"

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];

    // 先初始化 uni-app x SDK，再创建运行时根控制器。
    [UniAppBridge applicationDidFinishLaunchingWithOptions:application :launchOptions];
    self.window.rootViewController = [UniAppBridge createUniAppRootViewController];
    [self.window makeKeyAndVisible];
    return YES;
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
    [UniAppBridge applicationDidBecomeActive:application];
}

- (void)applicationDidEnterBackground:(UIApplication *)application {
    [UniAppBridge applicationDidEnterBackground:application];
}

- (void)applicationWillEnterForeground:(UIApplication *)application {
    [UniAppBridge applicationWillEnterForeground:application];
}

- (void)applicationWillResignActive:(UIApplication *)application {
    [UniAppBridge applicationWillResignActive:application];
}

- (BOOL)application:(UIApplication *)app openURL:(NSURL *)url options:(NSDictionary<UIApplicationOpenURLOptionsKey,id> *)options {
    [UniAppBridge applicationOpenURLOptions:app :url :options];
    return YES;
}

- (BOOL)application:(UIApplication *)application continueUserActivity:(NSUserActivity *)userActivity restorationHandler:(void (^)(NSArray<id<UIUserActivityRestoring>> * _Nullable))restorationHandler {
    [UniAppBridge applicationContinueUserActivityRestorationHandler:application :userActivity :restorationHandler];
    return YES;
}

- (void)application:(UIApplication *)application didRegisterForRemoteNotificationsWithDeviceToken:(NSData *)deviceToken {
    [UniAppBridge didRegisterForRemoteNotifications:deviceToken];
}

- (void)application:(UIApplication *)application didFailToRegisterForRemoteNotificationsWithError:(NSError *)error {
    [UniAppBridge didFailToRegisterForRemoteNotifications:error];
}

- (void)application:(UIApplication *)application didReceiveRemoteNotification:(NSDictionary *)userInfo fetchCompletionHandler:(void (^)(UIBackgroundFetchResult))completionHandler {
    [UniAppBridge applicationDidReceiveRemoteNotificationCompletionHandler:application :userInfo :completionHandler];
}

@end
`;
	fs.writeFileSync(appDelegatePath, content, 'utf-8');
}

function patchAutoLaunchEntry(projectDir) {
	patchUniAppBridge(projectDir);
	patchAutoLaunchAppDelegate(projectDir);
}

function findFilesByName(dirPath, fileName) {
	if (!fs.existsSync(dirPath)) {
		return [];
	}

	return fs.readdirSync(dirPath, { withFileTypes: true }).flatMap(entry => {
		const entryPath = path.join(dirPath, entry.name);
		if (entry.isDirectory()) {
			return findFilesByName(entryPath, fileName);
		}
		return entry.isFile() && entry.name === fileName ? [entryPath] : [];
	});
}

function patchBundledUtsExampleProjects() {
	const utsRoot = path.join(targetDirectory, 'UTSPluginExample');
	const projectFiles = findFilesByName(utsRoot, 'project.pbxproj');
	for (const pbxprojPath of projectFiles) {
		let content = fs.readFileSync(pbxprojPath, 'utf-8');
		content = setBuildSettingInAllConfigurations(content, 'EXCLUDED_ARCHS[sdk=iphonesimulator*]', IOS_SIMULATOR_EXCLUDED_ARCHS);
		fs.writeFileSync(pbxprojPath, content, 'utf-8');
	}
}

function runCommand(command, args, options = {}) {
	const result = spawnSync(command, args, {
		cwd: options.cwd,
		encoding: 'utf-8',
		stdio: 'pipe'
	});
	return {
		command,
		args,
		cwd: options.cwd || process.cwd(),
		status: result.status,
		stdout: result.stdout || '',
		stderr: result.stderr || '',
		error: result.error?.message || ''
	};
}

function formatCommand(command, args) {
	return [command, ...args.map(arg => String(arg).includes(' ') ? `"${arg}"` : arg)].join(' ');
}

function findIosUtsTemplateProject(sdkDir) {
	const templateDir = path.join(sdkDir, 'UTSPluginExample', IOS_UTS_TEMPLATE_NAME);
	const projectPath = path.join(templateDir, `${IOS_UTS_TEMPLATE_NAME}.xcodeproj`);
	const sourceDir = path.join(templateDir, IOS_UTS_TEMPLATE_NAME);
	if (!fs.existsSync(projectPath) || !fs.existsSync(sourceDir)) {
		throw new Error(`未找到 iOS UTS 插件模板：${templateDir}`);
	}
	return templateDir;
}

function patchGeneratedUtsProject(moduleInfo, bundleId) {
	// 复用官方 UTSPluginExample 模板时，只替换模块身份、Bundle ID 和最低系统版本，保留官方依赖路径。
	const pbxprojPath = path.join(moduleInfo.projectPath, 'project.pbxproj');
	let content = fs.readFileSync(pbxprojPath, 'utf-8');
	content = replaceAll(content, IOS_UTS_TEMPLATE_NAME, moduleInfo.sanitizedName);
	content = content.replace(/PRODUCT_BUNDLE_IDENTIFIER = [^;]+;/g, `PRODUCT_BUNDLE_IDENTIFIER = ${bundleId}.plugin.${getBundleIdSuffix(moduleInfo.name)};`);
	content = content.replace(/IPHONEOS_DEPLOYMENT_TARGET = [^;]+;/g, `IPHONEOS_DEPLOYMENT_TARGET = ${moduleInfo.deploymentTarget};`);
	content = setBuildSettingInAllConfigurations(content, 'EXCLUDED_ARCHS[sdk=iphonesimulator*]', IOS_SIMULATOR_EXCLUDED_ARCHS);
	fs.writeFileSync(pbxprojPath, content, 'utf-8');

	const headerPath = path.join(moduleInfo.sourceDir, `${moduleInfo.sanitizedName}.h`);
	if (fs.existsSync(headerPath)) {
		const headerContent = replaceAll(fs.readFileSync(headerPath, 'utf-8'), IOS_UTS_TEMPLATE_NAME, moduleInfo.sanitizedName);
		fs.writeFileSync(headerPath, headerContent, 'utf-8');
	}
}

function createIosUtsProject(module, sdkDir, bundleId) {
	const templateDir = findIosUtsTemplateProject(sdkDir);
	const moduleRoot = path.join(targetDirectory, 'UTSPluginExample', module.sanitizedName);
	const oldSourceDir = path.join(moduleRoot, IOS_UTS_TEMPLATE_NAME);
	const oldProjectPath = path.join(moduleRoot, `${IOS_UTS_TEMPLATE_NAME}.xcodeproj`);
	const sourceDir = path.join(moduleRoot, module.sanitizedName);
	const projectPath = path.join(moduleRoot, `${module.sanitizedName}.xcodeproj`);
	const deploymentTarget = normalizeDeploymentTarget(module.config.deploymentTarget);

	fsExtra.removeSync(moduleRoot);
	fsExtra.copySync(templateDir, moduleRoot, {
		filter: shouldCopySdkItem
	});
	if (fs.existsSync(oldSourceDir)) {
		fs.renameSync(oldSourceDir, sourceDir);
	}
	if (fs.existsSync(oldProjectPath)) {
		fs.renameSync(oldProjectPath, projectPath);
	}
	const oldHeaderPath = path.join(sourceDir, `${IOS_UTS_TEMPLATE_NAME}.h`);
	if (fs.existsSync(oldHeaderPath)) {
		fs.renameSync(oldHeaderPath, path.join(sourceDir, `${module.sanitizedName}.h`));
	}

	fsExtra.copySync(module.sourcePath, path.join(sourceDir, 'index.swift'));
	writeJsonFile(path.join(sourceDir, 'uts-config.json'), module.config);

	const moduleInfo = {
		...module,
		moduleRoot,
		sourceDir,
		projectPath,
		deploymentTarget
	};
	patchGeneratedUtsProject(moduleInfo, bundleId);
	return moduleInfo;
}

function prepareIosUtsPlugins(modules, sdkDir, bundleId) {
	return modules.map(module => {
		const generated = createIosUtsProject(module, sdkDir, bundleId);
		logInfo(`开始构建 iOS UTS 插件：${module.name} -> ${module.sanitizedName}`);
		const build = buildIosUtsFramework(generated);
		if (build.status === 'built') {
			logSuccess(`iOS UTS 插件构建完成：${module.name}`);
		} else if (build.status === 'built-device-only') {
			logWarn(`iOS UTS 插件仅生成真机 xcframework：${module.name}。如需模拟器调试，请查看 easypackx-ios.json 中的构建命令。`);
			build.warnings.forEach(warning => logWarn(`${module.name}: ${warning}`));
		} else {
			logWarn(`iOS UTS 插件构建失败，已保留工程供手动处理：${module.name}`);
			logCommandOutput(build.error, logWarn);
		}
		return {
			...generated,
			build
		};
	});
}

function getFrameworkPath(buildRoot, sdkName, moduleName) {
	const outputDir = sdkName === 'iphonesimulator' ? 'Release-iphonesimulator' : 'Release-iphoneos';
	return path.join(buildRoot, outputDir, `${moduleName}.framework`);
}

function buildIosUtsFramework(moduleInfo) {
	// 先分别构建真机和模拟器 framework，再组合为主工程可直接 Embed 的 xcframework。
	const buildRoot = path.join(targetDirectory, '.easypackx-build', moduleInfo.sanitizedName);
	const deviceBuildRoot = path.join(buildRoot, 'device');
	const simulatorBuildRoot = path.join(buildRoot, 'simulator');
	const xcframeworkPath = path.join(targetDirectory, 'UniAppXDemo', CUSTOM_UTS_FRAMEWORKS_DIR, `${moduleInfo.sanitizedName}.xcframework`);
	const commands = [];
	const warnings = [];

	fsExtra.removeSync(xcframeworkPath);
	fsExtra.ensureDirSync(path.dirname(xcframeworkPath));

	const baseArgs = [
		'-project', moduleInfo.projectPath,
		'-target', moduleInfo.sanitizedName,
		'-configuration', 'Release',
		'build',
		'BUILD_LIBRARY_FOR_DISTRIBUTION=YES',
		'SKIP_INSTALL=NO',
		'CODE_SIGNING_ALLOWED=NO'
	];

	const deviceArgs = [
		...baseArgs.slice(0, 6),
		'-sdk', 'iphoneos',
		...baseArgs.slice(6),
		`SYMROOT=${deviceBuildRoot}`,
		`OBJROOT=${path.join(buildRoot, 'obj-device')}`
	];
	const deviceResult = runCommand('xcodebuild', deviceArgs);
	commands.push({ sdk: 'iphoneos', command: formatCommand('xcodebuild', deviceArgs), status: deviceResult.status });
	if (deviceResult.status !== 0) {
		return {
			status: 'failed',
			xcframeworkPath: '',
			commands,
			warnings,
			error: (deviceResult.stderr || deviceResult.stdout || deviceResult.error || 'xcodebuild iphoneos 构建失败').trim()
		};
	}

	const simulatorArgs = [
		...baseArgs.slice(0, 6),
			'-sdk', 'iphonesimulator',
			...baseArgs.slice(6),
			`EXCLUDED_ARCHS[sdk=iphonesimulator*]=${IOS_SIMULATOR_EXCLUDED_ARCHS}`,
			`SYMROOT=${simulatorBuildRoot}`,
			`OBJROOT=${path.join(buildRoot, 'obj-simulator')}`
	];
	const simulatorResult = runCommand('xcodebuild', simulatorArgs);
	commands.push({ sdk: 'iphonesimulator', command: formatCommand('xcodebuild', simulatorArgs), status: simulatorResult.status });
	if (simulatorResult.status !== 0) {
		warnings.push('iphonesimulator 构建失败，已尝试仅使用真机 framework 创建 xcframework。');
	}

	const createArgs = ['-create-xcframework', '-framework', getFrameworkPath(deviceBuildRoot, 'iphoneos', moduleInfo.sanitizedName)];
	if (simulatorResult.status === 0) {
		createArgs.push('-framework', getFrameworkPath(simulatorBuildRoot, 'iphonesimulator', moduleInfo.sanitizedName));
	}
	createArgs.push('-output', xcframeworkPath);
	const createResult = runCommand('xcodebuild', createArgs);
	commands.push({ sdk: 'xcframework', command: formatCommand('xcodebuild', createArgs), status: createResult.status });
	if (createResult.status !== 0) {
		return {
			status: 'failed',
			xcframeworkPath: '',
			commands,
			warnings,
			error: (createResult.stderr || createResult.stdout || createResult.error || '创建 xcframework 失败').trim()
		};
	}

	return {
		status: simulatorResult.status === 0 ? 'built' : 'built-device-only',
		xcframeworkPath,
		commands,
		warnings,
		error: ''
	};
}

function injectTextAfter(content, marker, text) {
	if (!text.trim()) {
		return content;
	}
	if (!content.includes(marker)) {
		throw new Error(`Xcode 工程结构异常，缺少标记：${marker.trim()}`);
	}
	return content.replace(marker, `${marker}${text}`);
}

function addLinesToFirstFilesBlock(content, sectionStart, itemText) {
	if (!itemText.trim()) {
		return content;
	}
	const startIndex = content.indexOf(sectionStart);
	if (startIndex === -1) {
		throw new Error(`Xcode 工程结构异常，缺少区块：${sectionStart.trim()}`);
	}
	const filesIndex = content.indexOf('\n\t\t\tfiles = (\n', startIndex);
	if (filesIndex === -1) {
		throw new Error(`Xcode 工程结构异常，区块缺少 files 列表：${sectionStart.trim()}`);
	}
	const insertIndex = filesIndex + '\n\t\t\tfiles = (\n'.length;
	return `${content.slice(0, insertIndex)}${itemText}${content.slice(insertIndex)}`;
}

function addLinesToFrameworksGroup(content, itemText) {
	if (!itemText.trim()) {
		return content;
	}
	const groupMarker = '		937659892C2D623400D52792 /* Frameworks */ = {\n';
	const groupIndex = content.indexOf(groupMarker);
	if (groupIndex === -1) {
		throw new Error('Xcode 工程结构异常，缺少 Frameworks 分组。');
	}
	const childrenIndex = content.indexOf('\n\t\t\tchildren = (\n', groupIndex);
	if (childrenIndex === -1) {
		throw new Error('Xcode 工程结构异常，Frameworks 分组缺少 children 列表。');
	}
	const insertIndex = childrenIndex + '\n\t\t\tchildren = (\n'.length;
	return `${content.slice(0, insertIndex)}${itemText}${content.slice(insertIndex)}`;
}

function linkCustomUtsFrameworks(projectDir, pluginResults) {
	// 直接修改 pbxproj，把成功构建的自定义 UTS xcframework 加入 Frameworks 和 Embed Frameworks。
	const builtPlugins = pluginResults.filter(item => item.build.status === 'built' || item.build.status === 'built-device-only');
	if (builtPlugins.length === 0) {
		return;
	}

	const pbxprojPath = path.join(projectDir, 'UniAppXDemo.xcodeproj', 'project.pbxproj');
	let content = fs.readFileSync(pbxprojPath, 'utf-8');
	let buildFileEntries = '';
	let fileRefEntries = '';
	let frameworkPhaseItems = '';
	let embedPhaseItems = '';
	let frameworkGroupItems = '';

	for (const item of builtPlugins) {
		const fileName = `${item.sanitizedName}.xcframework`;
		const fileRefId = makePbxId(`custom-uts-file:${item.sanitizedName}`);
		const frameworkBuildId = makePbxId(`custom-uts-framework:${item.sanitizedName}`);
		const embedBuildId = makePbxId(`custom-uts-embed:${item.sanitizedName}`);
		const relativePath = toPosixPath(path.join(CUSTOM_UTS_FRAMEWORKS_DIR, fileName));

		if (content.includes(`${fileName} */`)) {
			continue;
		}

		buildFileEntries += `\t\t${frameworkBuildId} /* ${fileName} in Frameworks */ = {isa = PBXBuildFile; fileRef = ${fileRefId} /* ${fileName} */; };\n`;
		buildFileEntries += `\t\t${embedBuildId} /* ${fileName} in Embed Frameworks */ = {isa = PBXBuildFile; fileRef = ${fileRefId} /* ${fileName} */; settings = {ATTRIBUTES = (CodeSignOnCopy, RemoveHeadersOnCopy, ); }; };\n`;
		fileRefEntries += `\t\t${fileRefId} /* ${fileName} */ = {isa = PBXFileReference; lastKnownFileType = wrapper.xcframework; name = ${fileName}; path = ${relativePath}; sourceTree = "<group>"; };\n`;
		frameworkPhaseItems += `\t\t\t\t${frameworkBuildId} /* ${fileName} in Frameworks */,\n`;
		embedPhaseItems += `\t\t\t\t${embedBuildId} /* ${fileName} in Embed Frameworks */,\n`;
		frameworkGroupItems += `\t\t\t\t${fileRefId} /* ${fileName} */,\n`;
	}

	content = injectTextAfter(content, '/* Begin PBXBuildFile section */\n', buildFileEntries);
	content = injectTextAfter(content, '/* Begin PBXFileReference section */\n', fileRefEntries);
	content = addLinesToFirstFilesBlock(content, '/* Begin PBXFrameworksBuildPhase section */', frameworkPhaseItems);
	content = addLinesToFirstFilesBlock(content, '/* Begin PBXCopyFilesBuildPhase section */', embedPhaseItems);
	content = addLinesToFrameworksGroup(content, frameworkGroupItems);
	fs.writeFileSync(pbxprojPath, content, 'utf-8');
}

function updateWorkspacePluginRefs(projectDir, pluginResults) {
	const workspacePath = path.join(projectDir, 'UniAppXDemo.xcworkspace', 'contents.xcworkspacedata');
	if (!fs.existsSync(workspacePath)) {
		return;
	}
	let content = fs.readFileSync(workspacePath, 'utf-8');
	const customRefs = pluginResults.map(item => {
		const location = `container:../UTSPluginExample/${item.sanitizedName}/${item.sanitizedName}.xcodeproj`;
		if (content.includes(location)) {
			return '';
		}
		return `   <FileRef\n      location = "${location}">\n   </FileRef>\n`;
	}).join('');
	if (!customRefs) {
		return;
	}
	content = content.replace('</Workspace>', `${customRefs}</Workspace>`);
	fs.writeFileSync(workspacePath, content, 'utf-8');
}

function createSimulatorRunScheme(projectDir) {
	const schemeDir = path.join(projectDir, 'UniAppXDemo.xcodeproj', 'xcshareddata', 'xcschemes');
	const sourceSchemePath = path.join(schemeDir, 'UniAppX.xcscheme');
	const simulatorSchemePath = path.join(schemeDir, 'UniAppX-Simulator.xcscheme');
	if (!fs.existsSync(sourceSchemePath)) {
		logWarn(`未找到 UniAppX.xcscheme，跳过生成模拟器专用 Scheme：${sourceSchemePath}`);
		return;
	}

	let content = fs.readFileSync(sourceSchemePath, 'utf-8');
	// DCloud 5.07 的部分模拟器依赖只有 x86_64 slice。Apple Silicon 上用 LLDB 附加会按 arm64 destination 建 target，
	// 因此提供一个不附加调试器的模拟器 Scheme，避免运行时报 LLDB 架构不匹配。
	content = content.replace(
		/<LaunchAction([\s\S]*?)selectedDebuggerIdentifier = "Xcode\.DebuggerFoundation\.Debugger\.LLDB"([\s\S]*?)selectedLauncherIdentifier = "Xcode\.DebuggerFoundation\.Launcher\.LLDB"/,
		'<LaunchAction$1selectedDebuggerIdentifier = ""$2selectedLauncherIdentifier = "Xcode.IDEFoundation.Launcher.PosixSpawn"'
	);
	writeFile(simulatorSchemePath, content);
}

function createBuildCustomUtsScript(pluginResults) {
	// 自动构建失败时，保留同等命令的脚本，便于开发者在 Xcode 环境修复后手动重跑。
	const scriptPath = path.join(targetDirectory, 'build-custom-uts.sh');
	const moduleLines = pluginResults.map(item => {
		return [
			`build_module "${item.name}" "${item.sanitizedName}"`,
			''
		].join('\n');
	}).join('');
	const content = `#!/bin/bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"
OUTPUT_DIR="$ROOT_DIR/UniAppXDemo/${CUSTOM_UTS_FRAMEWORKS_DIR}"
mkdir -p "$OUTPUT_DIR"

build_module() {
  local display_name="$1"
  local module_name="$2"
  local module_dir="$ROOT_DIR/UTSPluginExample/$module_name"
  local project_path="$module_dir/$module_name.xcodeproj"
  local build_dir="$ROOT_DIR/.easypackx-build/$module_name"
  local xcframework_path="$OUTPUT_DIR/$module_name.xcframework"

  echo "==> 构建 $display_name ($module_name)"
  rm -rf "$xcframework_path"
  xcodebuild -project "$project_path" -target "$module_name" -configuration Release -sdk iphoneos build BUILD_LIBRARY_FOR_DISTRIBUTION=YES SKIP_INSTALL=NO CODE_SIGNING_ALLOWED=NO SYMROOT="$build_dir/device" OBJROOT="$build_dir/obj-device"
  if xcodebuild -project "$project_path" -target "$module_name" -configuration Release -sdk iphonesimulator build BUILD_LIBRARY_FOR_DISTRIBUTION=YES SKIP_INSTALL=NO CODE_SIGNING_ALLOWED=NO 'EXCLUDED_ARCHS[sdk=iphonesimulator*]=${IOS_SIMULATOR_EXCLUDED_ARCHS}' SYMROOT="$build_dir/simulator" OBJROOT="$build_dir/obj-simulator"; then
    xcodebuild -create-xcframework -framework "$build_dir/device/Release-iphoneos/$module_name.framework" -framework "$build_dir/simulator/Release-iphonesimulator/$module_name.framework" -output "$xcframework_path"
  else
    echo "警告：$display_name 模拟器构建失败，将仅使用真机 framework 创建 xcframework。"
    xcodebuild -create-xcframework -framework "$build_dir/device/Release-iphoneos/$module_name.framework" -output "$xcframework_path"
  fi
}

${moduleLines || 'echo "未发现自定义 iOS UTS 插件。"'}
echo "自定义 iOS UTS 插件构建完成。"
`;
	writeFile(scriptPath, content);
	fs.chmodSync(scriptPath, 0o755);
	return scriptPath;
}

function replaceAppResources(projectDir, resourceInfo) {
	const appsDir = path.join(projectDir, 'UniAppXDemo', 'uni-app-x', 'apps');
	if (!fs.existsSync(appsDir)) {
		throw new Error(`iOS 模板工程缺少 uni-app-x/apps 目录：${appsDir}`);
	}

	fsExtra.emptyDirSync(appsDir);
	fsExtra.copySync(resourceInfo.appIdDirectory, path.join(appsDir, resourceInfo.appId));
}

function getUtsModuleMetadata(item) {
	return {
		name: item.name,
		xcodeModuleName: item.sanitizedName,
		root: item.root,
		sourcePath: item.sourcePath,
		deploymentTarget: item.deploymentTarget || normalizeDeploymentTarget(item.config?.deploymentTarget),
		projectPath: item.projectPath || '',
		xcframeworkPath: item.build?.xcframeworkPath || '',
		buildStatus: item.build?.status || 'not-built',
		buildWarnings: item.build?.warnings || [],
		buildError: item.build?.error || '',
		buildCommands: item.build?.commands || []
	};
}

function writeGenerationMetadata(projectRoot, resourceInfo, bundleId, modules, manifestModules, sdkDir, pluginResults) {
	writeJsonFile(path.join(projectRoot, 'easypackx-ios.json'), {
		generatedAt: new Date().toISOString(),
		sdkDir,
		appId: resourceInfo.appId,
		appName: resourceInfo.appName,
		bundleId,
		resourceLayout: resourceInfo.resourceLayout,
		compilerVersion: getCompilerVersion(resourceInfo.manifest),
		manifestModules,
		utsModules: pluginResults.map(item => getUtsModuleMetadata(item)),
		customUtsPlugins: pluginResults.map(item => getUtsModuleMetadata(item))
	});
}

function createReadme({ appId, appName, bundleId, sdkDir, modules, manifestModules, resourceLayout, pluginResults }) {
	const moduleLines = pluginResults.map(item => {
		const status = item.build?.status || 'not-built';
		const framework = item.build?.xcframeworkPath ? path.relative(targetDirectory, item.build.xcframeworkPath) : '未生成';
		return `- ${item.name} -> ${item.sanitizedName}: ${status}，deploymentTarget=${item.deploymentTarget || '未声明'}，framework=${framework}`;
	}).join('\n') || '- 未发现自定义 iOS UTS 插件';
	const manifestModuleLines = manifestModules.map(item => `- ${item}`).join('\n') || '- manifest.json 未声明 iOS 内置模块';
	return `# EasyPackX iOS 工程

应用：${appName}
AppID：${appId}
Bundle ID：${bundleId}
SDK：${sdkDir}
资源布局：${resourceLayout}

## 当前状态

本工程基于 DCloud 官方 iOS SDK 的 UniAppXDemo 模板生成，已完成：

- 保留官方 SDK 根目录结构：UniAppXDemo、SDK、TemporarySampleFramework
- 保留官方 UTSPluginExample，满足模板工程内置示例模块引用
- 替换 UniAppXDemo/uni-app-x/apps/${appId} 本地资源
- 写入 App 名称、Bundle ID、版本号、uniapp-x.appid、uniRuntimeVersion
- 为模拟器构建排除 arm64 架构，兼容 DCloud 5.07 仅提供 x86_64 simulator slice 的依赖
- 生成 UniAppX-Simulator Scheme，用于 Apple Silicon 上无 LLDB 附加启动模拟器
- 扫描 manifest.json 声明的 iOS 模块
- 扫描 app-ios 资源目录中的自定义 UTS 插件
- 为自定义 UTS 插件生成 Xcode 工程，并尝试构建 xcframework 后加入主工程

## 打开工程

请用 Xcode 打开：

\`\`\`bash
open "${path.join(targetDirectory, 'UniAppXDemo', 'UniAppXDemo.xcworkspace')}"
\`\`\`

不要移动 UniAppXDemo、SDK、TemporarySampleFramework 的相对位置，模板工程里的依赖路径使用了这些相对目录。

## 运行建议

- 真机运行或需要断点调试：选择 UniAppX Scheme，并配置 Signing & Capabilities。
- Apple Silicon 上跑模拟器：优先选择 UniAppX-Simulator Scheme。DCloud 5.07 的部分 simulator 依赖只有 x86_64 slice，该 Scheme 会避免 Xcode 用 arm64 LLDB 附加 x86_64 产物。

## manifest iOS 模块

${manifestModuleLines}

## 已识别 iOS 插件

${moduleLines}

## 自定义 UTS 插件说明

已识别到的 uni_modules/*/utssdk/app-ios 会记录在 easypackx-ios.json 中。EasyPackX 会按 DCloud 官方 UTSPluginExample 模板生成插件工程，模块名使用 unimodule + 插件名驼峰格式，并把成功构建的 xcframework 加入主工程 Frameworks 与 Embed Frameworks。

如果某个插件构建失败，可查看 easypackx-ios.json 中对应插件的 buildError 和 buildCommands，或执行：

\`\`\`bash
cd "${targetDirectory}"
./build-custom-uts.sh
\`\`\`
`;
}

async function createNativeProject(options, sdkDir, resourceInfo) {
	await deleteFile(targetDirectory);
	fsExtra.ensureDirSync(path.dirname(targetDirectory));
	fsExtra.copySync(path.join(sdkDir, 'UniAppXDemo'), path.join(targetDirectory, 'UniAppXDemo'));
	fsExtra.copySync(path.join(sdkDir, 'SDK'), path.join(targetDirectory, 'SDK'));
	fsExtra.copySync(path.join(sdkDir, 'TemporarySampleFramework'), path.join(targetDirectory, 'TemporarySampleFramework'));
	fsExtra.copySync(path.join(sdkDir, 'UTSPluginExample'), path.join(targetDirectory, 'UTSPluginExample'), {
		filter: shouldCopySdkItem
	});

	const modules = getIosModules(resourceInfo.appIosPath);
	const manifestModules = getManifestModules(resourceInfo.manifest);
	const bundleId = getBundleId(options, resourceInfo.manifest);
	const projectDir = path.join(targetDirectory, 'UniAppXDemo');

	replaceAppResources(projectDir, resourceInfo);
	patchInfoPlist(projectDir, resourceInfo, bundleId);
	updateProjectFile(projectDir, bundleId, resourceInfo);
	patchAutoLaunchEntry(projectDir);
	patchBundledUtsExampleProjects();
	const pluginResults = prepareIosUtsPlugins(modules, sdkDir, bundleId);
	linkCustomUtsFrameworks(projectDir, pluginResults);
	updateWorkspacePluginRefs(projectDir, pluginResults);
	createSimulatorRunScheme(projectDir);
	createBuildCustomUtsScript(pluginResults);
	writeGenerationMetadata(targetDirectory, resourceInfo, bundleId, modules, manifestModules, sdkDir, pluginResults);
	writeFile(path.join(targetDirectory, 'README.md'), createReadme({
		appId: resourceInfo.appId,
		appName: resourceInfo.appName,
		bundleId,
		sdkDir,
		modules,
		manifestModules,
		resourceLayout: resourceInfo.resourceLayout,
		pluginResults
	}));

	const failedPlugins = pluginResults.filter(item => item.build.status === 'failed');
	if (failedPlugins.length > 0) {
		logWarn(`有 ${failedPlugins.length} 个自定义 iOS UTS 插件未自动构建成功：${failedPlugins.map(item => item.name).join(', ')}。请查看生成目录的 easypackx-ios.json 和 build-custom-uts.sh。`);
	}

	return {
		bundleId,
		modules,
		manifestModules,
		pluginResults,
		workspacePath: path.join(targetDirectory, 'UniAppXDemo', 'UniAppXDemo.xcworkspace')
	};
}

async function start(options = {}) {
	try {
		ensureMacOS();
		root = options.root || root;
		hx = options.hx || null;
		customConsoleLog = options.customConsoleLog || null;
		customSetStatusMessage = options.customSetStatusMessage || null;
		sdkDownloadUrl = normalizeIosSdkUrl(options.iosSdkDownloadUrl) || DEFAULT_IOS_SDK_URL;
		targetDirectory = options.uniappxNativeIos
			? path.join(options.uniappxNativeIos, NATIVE_IOS_PROJECT_NAME)
			: path.join(root, NATIVE_IOS_PROJECT_NAME);

		const uniappProjectPath = options.uniappProjectPath;
		if (!uniappProjectPath || !fs.existsSync(uniappProjectPath)) {
			throw new Error('uni-app x 项目路径无效。');
		}

		logInfo('开始校验 iOS 本地资源...');
		logInfo(`当前项目路径：${uniappProjectPath}`);
		const resourceInfo = getAppResourceInfo(uniappProjectPath);
		logInfo(`已识别 iOS 本地资源：${resourceInfo.appIdDirectory}`);
		if (resourceInfo.resourceLayout !== 'app-ios') {
			logWarn('当前项目使用 resources/__UNI__/www 资源布局，不是 uni-app x 的 resources/app-ios 布局；本次将按兼容模式生成 iOS 工程骨架。');
		}
		logInfo('开始准备 uni-app x iOS 离线 SDK...');
		const sdkDir = await prepareIosSdk();
		const result = await createNativeProject(options, sdkDir, resourceInfo);
		const projectTips = `iOS 原生工程生成完成：${result.workspacePath}`;
		logSuccess(projectTips);
		customSetStatusMessage?.(projectTips, 8000);
		if (customConsoleLog) {
			customConsoleLog(projectTips);
		}
	} catch (error) {
		output.info(`错误：${error.message}`, customConsoleLog);
		logger.error(error.stack || error.message);
		throw error;
	}
}

module.exports = {
	start
};
