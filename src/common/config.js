const { ipcRenderer } = window.require('electron')

/**
 * 获取全局配置
 * @returns {Promise<Object>} 配置对象
 */
export const $getConfig = async () => {
  try {
    const config = await ipcRenderer.invoke('readConfig')
    return config
  } catch (error) {
    console.error('获取配置失败:', error)
    return null
  }
}

/**
 * 保存全局配置
 * @param {Object} config - 配置对象
 * @returns {Promise<boolean>} 是否成功
 */
export const $setConfig = async (config) => {
  try {
    const result = await ipcRenderer.invoke('writeConfig', config)
    return result
  } catch (error) {
    console.error('保存配置失败:', error)
    return false
  }
}
