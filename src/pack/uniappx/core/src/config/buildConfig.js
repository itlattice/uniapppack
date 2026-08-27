require('dotenv').config();

const STORE_PASSWORD = process.env.STORE_PASSWORD ?? 'adminadmindebug';
const KEY_ALIAS = process.env.KEY_ALIAS ?? 'androiddebugkey';
const KEY_PASSWORD = process.env.KEY_PASSWORD ?? STORE_PASSWORD;

function getBaseBuildConfig () {
	return {
		minSdkVersion: 21,
		targetSdkVersion: 30,
		packageName: 'cn.testapp.app',
		versionCode: 100,
		versionName: '1.0.0',
		dependencies: {
			compileOnly: [],
			default: [],
			project: []
		},
		abis: '',
		project: {
			uniapp: false,
			plugins: [],
			dependencies: {
				default: [],
				files: []
			},
			repositories: {
				mavenCentral: true,
				jcenter: false,
				google: false,
				maven: []
			},
		},
		buildFeatures: {
			buildConfig: false
		},
		// 仅在 manifest 显式提供时写入额外 feature；模板按 entries 输出，避免无配置时改变现有 gradle
		buildFeatureEntries: [],
		aaptOptions: {
			additionalParameters: ['--auto-add-overlay'],
			ignoreAssetsPattern: '!.svn:!.git:.*:!CVS:!thumbs.db:!picasa.ini:!*.scc:*~',
			noCompress: []
		},
		nativeLibs: {
			pickFirsts: [],
			excludes: [],
			merges: [],
			doNotStrips: []
		},
		packaging: {
			// undefined = 不输出 packaging.jniLibs；true/false = 显式输出 useLegacyPackaging
			jniLibsUseLegacyPackaging: undefined
		},
		packagingHasJniLibs: false,
		hasPackagingOptions: false,
		bundle: false,
		defaultConfig: {
			buildConfigField: [],
			allowManifestPlaceholders: false,
			manifestPlaceholders: {
				APP_NAME: '',
				GETUI_APPID: '',
				PUSH_APPID: '',
				dcloud_unipush_auto_notification: '',
				MIPUSH_APPID: '',
				MIPUSH_APPKEY: '',
				MEIZUPUSH_APPID: '',
				MEIZUPUSH_APPKEY: '',
				OPPOPUSH_APPKEY: '',
				OPPOPUSH_APPSECRET: '',
				HUAWEI_APPID: '',
				VIVO_APPID: '',
				VIVO_APIKEY: '',
				HIHONOR_APPID: '',
				GY_APP_ID: '',
				apkApplicationId: '',
				plusUnipushAppid: '',
				plusUnipushAppkey: '',
				plusUnipushAppsecret: ''
			}
		},
		repositories: {
			mavenCentral: true,
			jcenter: false,
			google: false,
			maven: []
		},
		applyPlugins: [],
		localPack: true,
		keyStore: {
			storePassword: STORE_PASSWORD,
			keyAlias: KEY_ALIAS,
			keyPassword: KEY_PASSWORD,
		}
	}
}

module.exports = {
	getBaseBuildConfig
}
