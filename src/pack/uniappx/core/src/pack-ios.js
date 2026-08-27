const fs = require('fs');
const path = require('path');
const fsExtra = require('fs-extra');

let customConsoleLog = null;

function logInfo(message, color = 'white') {
  if (customConsoleLog) {
    customConsoleLog(message, color);
  } else {
    console.log(message);
  }
}

function logSuccess(message) {
  logInfo(message, '#67c23a');
}

function logError(message) {
  logInfo(message, '#f56c6c');
}

function logWarn(message) {
  logInfo(`警告：${message}`, '#e6a23c');
}

function ensureMacOS() {
  if (process.platform !== 'darwin') {
    throw new Error('iOS 原生工程只能在 macOS 上生成和构建。');
  }
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
  const appIdDirectory = findAppIdDirectory(appIosPath);
  if (!appIdDirectory) {
    throw new Error(`未找到 iOS 本地资源，请先在 HBuilderX 发行 iOS 本地资源。已检查：${appIosPath}`);
  }

  const manifestPath = path.join(appIdDirectory, 'www', 'manifest.json');
  const manifest = readJsonFile(manifestPath);
  return {
    appIosPath,
    appIdDirectory,
    manifestPath,
    manifest,
    appId: manifest.id || path.basename(appIdDirectory),
    appName: manifest.name || 'UniAppX'
  };
}

function findPreparedSdkRoot(candidateDir) {
  const requiredEntries = ['UniAppXDemo', 'SDK', 'TemporarySampleFramework'];
  if (!requiredEntries.every(entry => fs.existsSync(path.join(candidateDir, entry)))) {
    throw new Error(`iOS SDK 目录结构无效，未找到 UniAppXDemo/SDK/TemporarySampleFramework：${candidateDir}`);
  }
  return candidateDir;
}

function shouldCopySdkItem(src) {
  const basename = path.basename(src);
  return basename !== '.DS_Store' && !src.includes(`${path.sep}.git${path.sep}`);
}

function replaceAppResources(targetProjectDir, resourceInfo) {
  const targetAppDir = path.join(targetProjectDir, 'UniAppXDemo', 'uni-app-x', 'apps', resourceInfo.appId);
  logInfo(`正在替换 iOS 应用资源到：${targetAppDir}`);
  fsExtra.removeSync(targetAppDir);
  fsExtra.copySync(resourceInfo.appIdDirectory, targetAppDir, {
    filter: shouldCopySdkItem
  });
  logSuccess(`iOS 应用资源替换完成`);
}

function runPlutil(args) {
  const { execFileSync } = require('child_process');
  try {
    execFileSync('plutil', args, { stdio: 'pipe' });
  } catch (error) {
    throw new Error(`plutil 执行失败：${error.message}`);
  }
}

function patchPlistString(plistPath, key, value) {
  runPlutil(['-replace', key, '-string', String(value), plistPath]);
}

function getCompilerVersion(manifest) {
  return manifest?.['uni-app-x']?.compilerVersion || '5.07';
}

function patchInfoPlist(projectDir, resourceInfo, options) {
  const plistPath = path.join(projectDir, 'UniAppXDemo', 'Info.plist');
  if (!fs.existsSync(plistPath)) {
    throw new Error(`未找到 iOS 模板 Info.plist：${plistPath}`);
  }

  logInfo('正在更新 Info.plist...');
  patchPlistString(plistPath, 'CFBundleDisplayName', resourceInfo.appName);
  patchPlistString(plistPath, 'CFBundleName', resourceInfo.appName);
  patchPlistString(plistPath, 'CFBundleIdentifier', options.iosBundleId);
  patchPlistString(plistPath, 'CFBundleShortVersionString', resourceInfo.manifest?.version?.name || '1.0.0');
  patchPlistString(plistPath, 'CFBundleVersion', String(resourceInfo.manifest?.version?.code || 1));
  patchPlistString(plistPath, 'uniapp-x.appid', resourceInfo.appId);
  patchPlistString(plistPath, 'uniapp-x.uniRuntimeVersion', getCompilerVersion(resourceInfo.manifest));
  patchPlistString(plistPath, 'uniapp-x.ipatype', options.packType === '2' ? 'release' : 'debug');

  if (options.channel) {
    patchPlistString(plistPath, 'uniapp-x.channel', options.channel);
  }
  if (options.unionid) {
    patchPlistString(plistPath, 'uniapp-x.unionid', options.unionid);
  }
  if (typeof options.initPrivacyAuthorization === 'boolean') {
    patchPlistString(plistPath, 'uniapp-x.initPrivacyAuthorization', options.initPrivacyAuthorization ? 'true' : 'false');
  }

  logSuccess('Info.plist 更新完成');
}

function updateProjectFile(projectDir, bundleId, resourceInfo) {
  const pbxprojPath = path.join(projectDir, 'UniAppXDemo.xcodeproj', 'project.pbxproj');
  if (!fs.existsSync(pbxprojPath)) {
    throw new Error(`未找到 iOS 模板工程文件：${pbxprojPath}`);
  }

  logInfo('正在更新 project.pbxproj...');
  let content = fs.readFileSync(pbxprojPath, 'utf-8');
  content = content.replace(/PRODUCT_BUNDLE_IDENTIFIER = [^;]+;/g, `PRODUCT_BUNDLE_IDENTIFIER = ${bundleId};`);
  content = content.replace(/MARKETING_VERSION = [^;]+;/g, `MARKETING_VERSION = ${resourceInfo.manifest?.version?.name || '1.0.0'};`);
  content = content.replace(/CURRENT_PROJECT_VERSION = [^;]+;/g, `CURRENT_PROJECT_VERSION = ${resourceInfo.manifest?.version?.code || 1};`);
  fs.writeFileSync(pbxprojPath, content, 'utf-8');
  logSuccess('project.pbxproj 更新完成');
}

function patchUniAppBridge(projectDir) {
  const bridgePath = path.join(projectDir, 'UniAppXDemo', 'UniAppBridge.swift');
  if (!fs.existsSync(bridgePath)) {
    logWarn(`未找到 UniAppBridge.swift，跳过自动启动入口修改`);
    return;
  }

  let content = fs.readFileSync(bridgePath, 'utf-8');
  if (content.includes('createUniAppRootViewController()')) {
    return;
  }

  const marker = '    /// 退出 UniApp\n';
  const method = `    /// 创建 uni-app x 根控制器，作为独立 App 直接启动
    public static func createUniAppRootViewController() -> UIViewController {
        if UniSDKEngine.shared.getAppManager()?.getCurrentApp() == nil {
            UniSDKEngine.shared.getAppManager()?.create()
        }
        return UniAppRootViewController()
    }

`;
  if (!content.includes(marker)) {
    logWarn(`UniAppBridge.swift 结构异常，跳过自动启动入口修改`);
    return;
  }

  content = content.replace(marker, `${method}${marker}`);
  fs.writeFileSync(bridgePath, content, 'utf-8');
}

function patchAutoLaunchAppDelegate(projectDir) {
  const appDelegatePath = path.join(projectDir, 'UniAppXDemo', 'AppDelegate.m');
  if (!fs.existsSync(appDelegatePath)) {
    logWarn(`未找到 AppDelegate.m，跳过自动启动入口修改`);
    return;
  }

  const content = `//
//  AppDelegate.m
//  UniAppXDemo
//
//  自动生成：直接启动当前 uni-app x 应用
//

#import "AppDelegate.h"
#import "UniAppX-Swift.h"

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
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
  logInfo('正在修改自动启动入口...');
  patchUniAppBridge(projectDir);
  patchAutoLaunchAppDelegate(projectDir);
  logSuccess('自动启动入口修改完成');
}

async function start(options) {
  try {
    customConsoleLog = options.customConsoleLog || null;

    logInfo('开始生成 iOS 原生工程...');
    ensureMacOS();

    const { uniappProjectPath, iosLocalSdk, uniappxNativeIos, iosBundleId } = options;

    logInfo(`读取 iOS 应用资源...`);
    const resourceInfo = getAppResourceInfo(uniappProjectPath);
    logSuccess(`应用名称：${resourceInfo.appName}，AppID：${resourceInfo.appId}`);

    logInfo(`验证 iOS SDK 结构...`);
    const sdkRoot = findPreparedSdkRoot(iosLocalSdk);
    logSuccess(`iOS SDK 验证通过：${sdkRoot}`);

    const targetProjectDir = path.join(uniappxNativeIos, 'uniappx-native-ios');
    logInfo(`目标工程目录：${targetProjectDir}`);

    logInfo('正在复制 iOS 模板工程...');
    fsExtra.removeSync(targetProjectDir);
    fsExtra.ensureDirSync(uniappxNativeIos);

    fsExtra.copySync(path.join(sdkRoot, 'UniAppXDemo'), path.join(targetProjectDir, 'UniAppXDemo'), {
      filter: shouldCopySdkItem
    });
    fsExtra.copySync(path.join(sdkRoot, 'SDK'), path.join(targetProjectDir, 'SDK'), {
      filter: shouldCopySdkItem
    });
    fsExtra.copySync(path.join(sdkRoot, 'TemporarySampleFramework'), path.join(targetProjectDir, 'TemporarySampleFramework'), {
      filter: shouldCopySdkItem
    });
    if (fs.existsSync(path.join(sdkRoot, 'UTSPluginExample'))) {
      fsExtra.copySync(path.join(sdkRoot, 'UTSPluginExample'), path.join(targetProjectDir, 'UTSPluginExample'), {
        filter: shouldCopySdkItem
      });
    }
    logSuccess('模板工程复制完成');

    replaceAppResources(targetProjectDir, resourceInfo);
    patchInfoPlist(targetProjectDir, resourceInfo, options);
    updateProjectFile(targetProjectDir, iosBundleId, resourceInfo);
    patchAutoLaunchEntry(targetProjectDir);

    const workspacePath = path.join(targetProjectDir, 'UniAppXDemo.xcworkspace');
    const xcodeprojPath = path.join(targetProjectDir, 'UniAppXDemo.xcodeproj');

    logSuccess(`iOS 原生工程生成完成！`);
    logInfo(`工程目录：${targetProjectDir}`, '#409eff');
    if (fs.existsSync(workspacePath)) {
      logInfo(`Workspace：${workspacePath}`, '#409eff');
    }
    if (fs.existsSync(xcodeprojPath)) {
      logInfo(`Xcode 工程：${xcodeprojPath}`, '#409eff');
    }

    logWarn('当前版本仅生成工程骨架，UTS 插件和部分 xcframework 需手动集成');

    return {
      projectDir: targetProjectDir,
      workspacePath: fs.existsSync(workspacePath) ? workspacePath : '',
      xcodeprojPath: fs.existsSync(xcodeprojPath) ? xcodeprojPath : ''
    };
  } catch (error) {
    logError(error.message || 'iOS 工程生成失败');
    throw error;
  }
}

module.exports = { start };
