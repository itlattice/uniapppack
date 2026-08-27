/**
 * 传统 uni-app Android 离线打包核心模块
 * 参考：https://nativesupport.dcloud.net.cn/AppDocs/usesdk/android.html
 *
 * 与 uni-app x 完全独立，不共享任何配置和依赖。
 */

const path = require('path');
const fs = require('fs');
const fsExtra = require('fs-extra');
const Handlebars = require('handlebars');
const ora = require('ora');

// 全局配置
let packConfig = {};
let customConsoleLog = null;
let targetDirectory = '';
let uniappProjectPath = '';
let appResourcePath = '';
let localSdk = '';
let appid = '';
let packageName = '';
let versionCode = 1;
let versionName = '1.0.0';
let appName = '';
let packType = 1; // 1=debug, 2=release

const output = {
    info: (msg, logger) => {
        console.log(`[INFO] ${msg}`);
        if (logger) logger(msg, 'white');
    },
    success: (msg, logger) => {
        console.log(`[SUCCESS] ${msg}`);
        if (logger) logger(msg, '#67c23a');
    },
    warn: (msg, logger) => {
        console.warn(`[WARN] ${msg}`);
        if (logger) logger(msg, '#e6a23c');
    },
    error: (msg, logger) => {
        console.error(`[ERROR] ${msg}`);
        if (logger) logger(msg, '#f56c6c');
    }
};

function dirname(relativePath) {
    return path.join(__dirname, relativePath);
}

/**
 * 检查本地资源是否存在
 */
function checkResourcesExists() {
    if (!fs.existsSync(appResourcePath)) {
        return false;
    }
    // 检查关键资源文件
    const manifestPath = path.join(appResourcePath, 'manifest.json');
    if (!fs.existsSync(manifestPath)) {
        return false;
    }
    return true;
}

/**
 * 读取 manifest.json
 */
function loadManifest() {
    const manifestPath = path.join(appResourcePath, 'manifest.json');
    if (!fs.existsSync(manifestPath)) {
        throw new Error(`manifest.json 不存在：${manifestPath}`);
    }
    const content = fs.readFileSync(manifestPath, 'utf-8');
    const manifest = JSON.parse(content);

    // 提取关键信息
    appid = manifest.id || '';
    appName = manifest.name || 'App';
    versionCode = parseInt(manifest.versionCode) || 1;
    versionName = manifest.versionName || '1.0.0';

    if (manifest['app-plus'] && manifest['app-plus'].distribute && manifest['app-plus'].distribute.android) {
        const androidConfig = manifest['app-plus'].distribute.android;
        if (androidConfig.packagename) {
            packageName = androidConfig.packagename;
        }
    }

    output.info(`应用ID: ${appid}`, customConsoleLog);
    output.info(`应用名称: ${appName}`, customConsoleLog);
    output.info(`版本号: ${versionName} (${versionCode})`, customConsoleLog);
    output.info(`包名: ${packageName || '未配置'}`, customConsoleLog);
}

/**
 * 复制基座模板
 */
async function copyBaseProject() {
    const spinner = ora('正在复制基座模板...').start();
    output.info('正在复制基座模板...', customConsoleLog);

    try {
        // 检查 SDK 中的基座模板
        const baseProjectPath = path.join(localSdk, 'HBuilder-Hello', 'HBuilder-Hello');
        if (!fs.existsSync(baseProjectPath)) {
            throw new Error(`基座模板不存在：${baseProjectPath}`);
        }

        // 删除旧的目标目录
        if (fs.existsSync(targetDirectory)) {
            fsExtra.removeSync(targetDirectory);
        }

        // 复制基座
        fsExtra.copySync(baseProjectPath, targetDirectory);

        spinner.succeed('基座模板复制完成');
        output.success('基座模板复制完成', customConsoleLog);
    } catch (error) {
        spinner.fail('基座模板复制失败');
        throw error;
    }
}

/**
 * 替换应用资源
 */
async function replaceAppResources() {
    const spinner = ora('正在替换应用资源...').start();
    output.info('正在替换应用资源...', customConsoleLog);

    try {
        const assetsWwwPath = path.join(targetDirectory, 'app/src/main/assets/apps', appid);

        // 删除旧的应用资源
        if (fs.existsSync(assetsWwwPath)) {
            fsExtra.removeSync(assetsWwwPath);
        }

        // 复制新的应用资源
        fsExtra.copySync(appResourcePath, assetsWwwPath);

        spinner.succeed('应用资源替换完成');
        output.success('应用资源替换完成', customConsoleLog);
    } catch (error) {
        spinner.fail('应用资源替换失败');
        throw error;
    }
}

/**
 * 更新 dcloud_control.xml
 */
async function updateDcloudControl() {
    const spinner = ora('正在更新 dcloud_control.xml...').start();
    output.info('正在更新 dcloud_control.xml...', customConsoleLog);

    try {
        const controlXmlPath = path.join(targetDirectory, 'app/src/main/assets/data/dcloud_control.xml');

        let controlContent = `<?xml version="1.0" encoding="utf-8"?>
<hbuilder>
    <apps>
        <app appid="${appid}" appver="${versionCode}"/>
    </apps>
</hbuilder>`;

        fs.writeFileSync(controlXmlPath, controlContent, 'utf-8');

        spinner.succeed('dcloud_control.xml 更新完成');
        output.success('dcloud_control.xml 更新完成', customConsoleLog);
    } catch (error) {
        spinner.fail('dcloud_control.xml 更新失败');
        throw error;
    }
}

/**
 * 更新 AndroidManifest.xml
 */
async function updateAndroidManifest() {
    const spinner = ora('正在更新 AndroidManifest.xml...').start();
    output.info('正在更新 AndroidManifest.xml...', customConsoleLog);

    try {
        const manifestPath = path.join(targetDirectory, 'app/src/main/AndroidManifest.xml');
        let manifestContent = fs.readFileSync(manifestPath, 'utf-8');

        // 替换包名
        if (packageName) {
            manifestContent = manifestContent.replace(/package="[^"]*"/, `package="${packageName}"`);
        }

        // 替换应用名称
        manifestContent = manifestContent.replace(/android:label="[^"]*"/, `android:label="${appName}"`);

        fs.writeFileSync(manifestPath, manifestContent, 'utf-8');

        spinner.succeed('AndroidManifest.xml 更新完成');
        output.success('AndroidManifest.xml 更新完成', customConsoleLog);
    } catch (error) {
        spinner.fail('AndroidManifest.xml 更新失败');
        throw error;
    }
}

/**
 * 更新 build.gradle
 */
async function updateBuildGradle() {
    const spinner = ora('正在更新 build.gradle...').start();
    output.info('正在更新 build.gradle...', customConsoleLog);

    try {
        const buildGradlePath = path.join(targetDirectory, 'app/build.gradle');
        let buildContent = fs.readFileSync(buildGradlePath, 'utf-8');

        // 替换包名
        if (packageName) {
            buildContent = buildContent.replace(/applicationId\s+"[^"]*"/, `applicationId "${packageName}"`);
        }

        // 替换版本号
        buildContent = buildContent.replace(/versionCode\s+\d+/, `versionCode ${versionCode}`);
        buildContent = buildContent.replace(/versionName\s+"[^"]*"/, `versionName "${versionName}"`);

        // 根据打包类型调整签名配置
        if (packType === 2 && packConfig.storePath) {
            // 正式包：使用自定义证书
            const signingConfig = `
    signingConfigs {
        release {
            storeFile file('${packConfig.storePath.replace(/\\/g, '\\\\')}')
            storePassword '${packConfig.storePassword || ''}'
            keyAlias '${packConfig.keyAlias || ''}'
            keyPassword '${packConfig.keyPassword || ''}'
        }
    }`;

            if (!buildContent.includes('signingConfigs')) {
                buildContent = buildContent.replace(/android\s*{/, `android {\n${signingConfig}`);
            }

            // 配置 release buildType 使用签名
            buildContent = buildContent.replace(
                /buildTypes\s*{\s*release\s*{/,
                `buildTypes {\n        release {\n            signingConfig signingConfigs.release`
            );
        }

        fs.writeFileSync(buildGradlePath, buildContent, 'utf-8');

        spinner.succeed('build.gradle 更新完成');
        output.success('build.gradle 更新完成', customConsoleLog);
    } catch (error) {
        spinner.fail('build.gradle 更新失败');
        throw error;
    }
}

/**
 * 复制证书文件
 */
async function copyKeystoreFile() {
    if (!packConfig.storePath || !fs.existsSync(packConfig.storePath)) {
        return;
    }

    const spinner = ora('正在复制证书文件...').start();
    output.info('正在复制证书文件...', customConsoleLog);

    try {
        const targetKeystorePath = path.join(targetDirectory, 'app', path.basename(packConfig.storePath));
        fsExtra.copySync(packConfig.storePath, targetKeystorePath);

        spinner.succeed('证书文件复制完成');
        output.success('证书文件复制完成', customConsoleLog);
    } catch (error) {
        spinner.fail('证书文件复制失败');
        throw error;
    }
}

/**
 * 配置 local.properties
 */
async function configLocalProperties() {
    const spinner = ora('正在配置 local.properties...').start();
    output.info('正在配置 local.properties...', customConsoleLog);

    try {
        let content = '';

        if (packConfig.androidSdk) {
            const sdkPath = packConfig.androidSdk.replace(/\\/g, '\\\\');
            content += `sdk.dir=${sdkPath}\n`;
        }

        const localPropertiesPath = path.join(targetDirectory, 'local.properties');
        fs.writeFileSync(localPropertiesPath, content, 'utf-8');

        spinner.succeed('local.properties 配置完成');
        output.success('local.properties 配置完成', customConsoleLog);
    } catch (error) {
        spinner.fail('local.properties 配置失败');
        throw error;
    }
}

/**
 * 主入口函数
 */
async function start(options = {}) {
    try {
        output.info('=== 开始传统 uni-app Android 离线打包 ===', customConsoleLog);

        // 初始化配置
        packConfig = options;
        customConsoleLog = options.customConsoleLog || null;
        uniappProjectPath = options.uniappProjectPath || '';
        localSdk = options.androidLocalSdk || '';
        targetDirectory = path.join(options.uniappxNativeAndroid || '', 'uniapp-native-android');
        appResourcePath = path.join(uniappProjectPath, 'unpackage/resources/__UNI__' + (options.appid || ''));
        packType = options.packType === '2' || options.packType === 2 ? 2 : 1;
        packageName = options.androidPackageName || '';

        output.info(`项目路径: ${uniappProjectPath}`, customConsoleLog);
        output.info(`SDK路径: ${localSdk}`, customConsoleLog);
        output.info(`输出目录: ${targetDirectory}`, customConsoleLog);
        output.info(`打包类型: ${packType === 2 ? '正式包' : '自定义基座'}`, customConsoleLog);

        // 检查资源
        if (!checkResourcesExists()) {
            throw new Error('应用资源不存在，请先在 HBuilderX 中执行【发行】->【原生App-本地打包】->【生成本地打包App资源】');
        }

        // 读取 manifest
        loadManifest();

        // 执行打包流程
        await copyBaseProject();
        await replaceAppResources();
        await updateDcloudControl();
        await updateAndroidManifest();
        await updateBuildGradle();
        await copyKeystoreFile();
        await configLocalProperties();

        output.success(`原生工程生成成功：${targetDirectory}`, customConsoleLog);
        output.info('=== 传统 uni-app Android 离线打包完成 ===', customConsoleLog);

        return targetDirectory;
    } catch (error) {
        output.error(`打包失败: ${error.message}`, customConsoleLog);
        console.error(error);
        throw error;
    }
}

module.exports = {
    start
};
