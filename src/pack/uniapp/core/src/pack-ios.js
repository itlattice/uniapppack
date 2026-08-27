/**
 * 传统 uni-app iOS 离线打包核心模块
 * 参考：https://nativesupport.dcloud.net.cn/AppDocs/usesdk/ios.html
 *
 * 与 uni-app x 完全独立，不共享任何配置和依赖。
 */

const path = require('path');
const fs = require('fs');
const fsExtra = require('fs-extra');

// 全局配置
let packConfig = {};
let customConsoleLog = null;
let targetDirectory = '';
let uniappProjectPath = '';
let appResourcePath = '';
let localSdk = '';
let appid = '';
let bundleId = '';
let versionCode = 1;
let versionName = '1.0.0';
let appName = '';

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

function ensureMacOS() {
    if (process.platform !== 'darwin') {
        throw new Error('iOS 原生工程只能在 macOS 上生成');
    }
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

    if (manifest['app-plus'] && manifest['app-plus'].distribute && manifest['app-plus'].distribute.ios) {
        const iosConfig = manifest['app-plus'].distribute.ios;
        if (iosConfig.appid) {
            bundleId = iosConfig.appid;
        }
    }

    output.info(`应用ID: ${appid}`, customConsoleLog);
    output.info(`应用名称: ${appName}`, customConsoleLog);
    output.info(`版本号: ${versionName} (${versionCode})`, customConsoleLog);
    output.info(`Bundle ID: ${bundleId || '未配置'}`, customConsoleLog);
}

/**
 * 复制基座模板
 */
async function copyBaseProject() {
    output.info('正在复制 iOS 基座模板...', customConsoleLog);

    try {
        // 检查 SDK 中的基座模板
        const baseProjectPath = path.join(localSdk, 'HBuilder-Hello');
        if (!fs.existsSync(baseProjectPath)) {
            throw new Error(`iOS 基座模板不存在：${baseProjectPath}`);
        }

        // 删除旧的目标目录
        if (fs.existsSync(targetDirectory)) {
            fsExtra.removeSync(targetDirectory);
        }

        // 复制基座
        fsExtra.copySync(baseProjectPath, targetDirectory, {
            filter: (src) => {
                const basename = path.basename(src);
                return basename !== '.DS_Store' && !src.includes(`${path.sep}.git${path.sep}`);
            }
        });

        output.success('iOS 基座模板复制完成', customConsoleLog);
    } catch (error) {
        throw error;
    }
}

/**
 * 替换应用资源
 */
async function replaceAppResources() {
    output.info('正在替换 iOS 应用资源...', customConsoleLog);

    try {
        const targetAppPath = path.join(targetDirectory, 'HBuilder-Hello', 'Pandora', 'apps', appid);

        // 删除旧的应用资源
        if (fs.existsSync(targetAppPath)) {
            fsExtra.removeSync(targetAppPath);
        }

        // 复制新的应用资源
        fsExtra.copySync(appResourcePath, targetAppPath, {
            filter: (src) => {
                const basename = path.basename(src);
                return basename !== '.DS_Store';
            }
        });

        output.success('iOS 应用资源替换完成', customConsoleLog);
    } catch (error) {
        throw error;
    }
}

/**
 * 更新 control.xml
 */
async function updateControlXml() {
    output.info('正在更新 control.xml...', customConsoleLog);

    try {
        const controlXmlPath = path.join(targetDirectory, 'HBuilder-Hello', 'Pandora', 'apps', appid, 'www', 'control.xml');

        let controlContent = `<?xml version="1.0" encoding="UTF-8"?>
<hbuilder>
<apps>
    <app appid="${appid}" appver="${versionCode}"/>
</apps>
</hbuilder>`;

        // 确保目录存在
        fsExtra.ensureDirSync(path.dirname(controlXmlPath));
        fs.writeFileSync(controlXmlPath, controlContent, 'utf-8');

        output.success('control.xml 更新完成', customConsoleLog);
    } catch (error) {
        throw error;
    }
}

/**
 * 更新 Info.plist
 */
async function updateInfoPlist() {
    output.info('正在更新 Info.plist...', customConsoleLog);

    try {
        const infoPlistPath = path.join(targetDirectory, 'HBuilder-Hello', 'Info.plist');

        if (!fs.existsSync(infoPlistPath)) {
            throw new Error(`Info.plist 不存在：${infoPlistPath}`);
        }

        let plistContent = fs.readFileSync(infoPlistPath, 'utf-8');

        // 替换 Bundle ID
        if (bundleId) {
            plistContent = plistContent.replace(
                /<key>CFBundleIdentifier<\/key>\s*<string>[^<]*<\/string>/,
                `<key>CFBundleIdentifier</key>\n\t<string>${bundleId}</string>`
            );
        }

        // 替换应用名称
        plistContent = plistContent.replace(
            /<key>CFBundleDisplayName<\/key>\s*<string>[^<]*<\/string>/,
            `<key>CFBundleDisplayName</key>\n\t<string>${appName}</string>`
        );
        plistContent = plistContent.replace(
            /<key>CFBundleName<\/key>\s*<string>[^<]*<\/string>/,
            `<key>CFBundleName</key>\n\t<string>${appName}</string>`
        );

        // 替换版本号
        plistContent = plistContent.replace(
            /<key>CFBundleShortVersionString<\/key>\s*<string>[^<]*<\/string>/,
            `<key>CFBundleShortVersionString</key>\n\t<string>${versionName}</string>`
        );
        plistContent = plistContent.replace(
            /<key>CFBundleVersion<\/key>\s*<string>[^<]*<\/string>/,
            `<key>CFBundleVersion</key>\n\t<string>${versionCode}</string>`
        );

        fs.writeFileSync(infoPlistPath, plistContent, 'utf-8');

        output.success('Info.plist 更新完成', customConsoleLog);
    } catch (error) {
        throw error;
    }
}

/**
 * 主入口函数
 */
async function start(options = {}) {
    try {
        output.info('=== 开始传统 uni-app iOS 离线打包 ===', customConsoleLog);

        // 检查 macOS 平台
        ensureMacOS();

        // 初始化配置
        packConfig = options;
        customConsoleLog = options.customConsoleLog || null;
        uniappProjectPath = options.uniappProjectPath || '';
        localSdk = options.iosLocalSdk || '';
        targetDirectory = path.join(options.uniappxNativeIos || '', 'uniapp-native-ios');
        appResourcePath = path.join(uniappProjectPath, 'unpackage/resources/__UNI__' + (options.appid || ''));
        bundleId = options.iosBundleId || '';

        output.info(`项目路径: ${uniappProjectPath}`, customConsoleLog);
        output.info(`SDK路径: ${localSdk}`, customConsoleLog);
        output.info(`输出目录: ${targetDirectory}`, customConsoleLog);

        // 检查资源
        if (!checkResourcesExists()) {
            throw new Error('应用资源不存在，请先在 HBuilderX 中执行【发行】->【原生App-本地打包】->【生成本地打包App资源】');
        }

        // 读取 manifest
        loadManifest();

        // 如果用户指定了 Bundle ID，使用用户指定的
        if (options.iosBundleId) {
            bundleId = options.iosBundleId;
        }

        // 执行打包流程
        await copyBaseProject();
        await replaceAppResources();
        await updateControlXml();
        await updateInfoPlist();

        output.success(`iOS 原生工程生成成功：${targetDirectory}`, customConsoleLog);
        output.info('=== 传统 uni-app iOS 离线打包完成 ===', customConsoleLog);

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
