export async function AndroidUniappXStart() {
  // 保留这个占位入口是为了避免旧代码再次把 Node 打包逻辑写回渲染层。
  // 当前 Android Gradle 工程生成只能通过 Electron 主进程 IPC 发起：
  // channel = uniappx:generate-android-gradle
  throw new Error('AndroidUniappXStart 已迁移到 Electron 主进程 IPC：uniappx:generate-android-gradle')
}

export default {
  AndroidUniappXStart,
}