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

      // Windows 下 keytool 输出是 GBK 编码，需要转换
      const output = execSync(command, {
        encoding: 'buffer', // 先获取 buffer
        timeout: 10000, // 10秒超时
        windowsHide: true
      })

      // 使用 iconv-lite 转换 GBK 到 UTF-8
      const iconv = require('iconv-lite')
      const decodedOutput = iconv.decode(output, 'gbk')

      console.log('keytool 输出内容:', decodedOutput)

      // 解析输出获取所有别名
      const aliases = []

      // 尝试多种别名匹配模式
      // 模式1: Alias name: xxx
      const aliasRegex1 = /Alias\s+name:\s*(.+)/gi
      // 模式2: 别名名称: xxx 或 别名: xxx (中文环境)
      const aliasRegex2 = /别名[名称]*:\s*(.+)/gi
      // 模式3: 匹配 "您的密钥库包含 X 个条目" 后面的行
      const aliasRegex3 = /别名:\s*(.+)/gi
      // 模式4: 直接匹配 "别名: xxx" 这种格式
      const lines = decodedOutput.split('\n')

      let match

      // 尝试模式1（英文）
      while ((match = aliasRegex1.exec(decodedOutput)) !== null) {
        const alias = match[1].trim()
        if (alias && !aliases.includes(alias)) {
          aliases.push(alias)
        }
      }

      // 尝试模式2（中文）
      if (aliases.length === 0) {
        while ((match = aliasRegex2.exec(decodedOutput)) !== null) {
          const alias = match[1].trim()
          if (alias && !aliases.includes(alias)) {
            aliases.push(alias)
          }
        }
      }

      // 尝试逐行解析
      if (aliases.length === 0) {
        for (let i = 0; i < lines.length; i++) {
          const line = lines[i].trim()
          // 匹配 "别名: xxx" 或 "别名名称: xxx"
          if (line.startsWith('别名:') || line.startsWith('别名名称:')) {
            const parts = line.split(':')
            if (parts.length >= 2) {
              const alias = parts[1].trim()
              if (alias && !aliases.includes(alias)) {
                aliases.push(alias)
                break // 通常只有一个主别名
              }
            }
          }
        }
      }

      console.log(`证书验证成功，找到 ${aliases.length} 个别名:`, aliases)

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
