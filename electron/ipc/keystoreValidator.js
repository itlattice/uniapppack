'use strict'
import { ipcMain } from 'electron'
const { execSync } = require('child_process')
const fs = require('fs')
const path = require('path')

let mainWindow = null

export function initKeystoreValidatorHandlers({ mainWin }) {
  mainWindow = mainWin
  console.log('注册证书验证 IPC handler...')
  initHandlers()
}

function initHandlers() {
  /**
   * 验证证书库密码并获取证书别名列表
   * @param {string} keystorePath - 证书文件路径
   * @param {string} password - 证书库密码
   * @param {string} jdkPath - JDK 路径（可选，如果未提供则使用系统默认）
   * @returns {Object} { valid: boolean, aliases: string[], error: string }
   */
  ipcMain.handle('validate-keystore-password', async (event, { keystorePath, password, jdkPath }) => {
    try {
      // 检查证书文件是否存在
      if (!fs.existsSync(keystorePath)) {
        return {
          valid: false,
          aliases: [],
          error: '证书文件不存在'
        }
      }

      // 检查密码是否为空
      if (!password || password.trim() === '') {
        return {
          valid: false,
          aliases: [],
          error: '证书库密码不能为空'
        }
      }

      // 构建 keytool 命令路径
      let keytoolCmd = 'keytool'
      if (jdkPath && jdkPath.trim() !== '') {
        const keytoolPath = path.join(jdkPath, 'bin', 'keytool.exe')
        if (fs.existsSync(keytoolPath)) {
          keytoolCmd = `"${keytoolPath}"`
        }
      }

      // 使用 keytool 列出证书库中的所有别名
      // -list: 列出证书
      // -v: 详细输出
      // -keystore: 证书库文件路径
      // -storepass: 证书库密码
      const command = `${keytoolCmd} -list -v -keystore "${keystorePath}" -storepass "${password}"`

      console.log('执行 keytool 命令验证证书...')

      const output = execSync(command, {
        encoding: 'utf8',
        timeout: 10000, // 10秒超时
        windowsHide: true
      })

      // 解析输出获取所有别名
      const aliases = []
      const aliasRegex = /Alias name:\s*(.+)/gi
      let match

      while ((match = aliasRegex.exec(output)) !== null) {
        const alias = match[1].trim()
        if (alias && !aliases.includes(alias)) {
          aliases.push(alias)
        }
      }

      console.log(`证书验证成功，找到 ${aliases.length} 个别名`)

      return {
        valid: true,
        aliases: aliases,
        error: ''
      }

    } catch (error) {
      console.error('证书验证失败:', error.message)

      // 判断错误类型
      let errorMessage = '证书库密码错误'

      if (error.message.includes('Keystore was tampered with, or password was incorrect')) {
        errorMessage = '证书库密码错误'
      } else if (error.message.includes('keystore password was incorrect')) {
        errorMessage = '证书库密码错误'
      } else if (error.message.includes('keytool')) {
        errorMessage = 'keytool 未找到，请检查 JDK 配置'
      } else if (error.message.includes('ENOENT')) {
        errorMessage = 'JDK 或 keytool 未找到'
      } else {
        errorMessage = `验证失败: ${error.message}`
      }

      return {
        valid: false,
        aliases: [],
        error: errorMessage
      }
    }
  })
}
