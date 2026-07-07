import { v4 as uuidv4 } from 'uuid'

import { ElLoading, ElMessage, ElMessageBox } from 'element-plus'

const { ipcRenderer } = window.require('electron')

export function $getUUID() {
  return uuidv4()
}

export function $getCurrentTime() {
  const now = new Date();

  const hours = String(now.getHours()).padStart(2, '0');
  const minutes = String(now.getMinutes()).padStart(2, '0');
  const seconds = String(now.getSeconds()).padStart(2, '0');

  return `${hours}:${minutes}:${seconds}`;
}

export function $sendCustomerMsg(type, data) {
  var msg = {
    type: type,
    data: data,
  }
  ipcRenderer.send('customerMsg', msg)
}

export async function $getAppPath(){
  return await ipcRenderer.invoke('appPath')
}

const _audioCtx = new AudioContext({ latencyHint: 'interactive' })
const _audioBufferCache = new Map()

async function _loadAudioBuffer(filePath) {
  if (_audioBufferCache.has(filePath)) return _audioBufferCache.get(filePath)
  const url = filePath.startsWith('http') ? filePath : `file:///${filePath.replace(/\\/g, '/')}`
  const res = await fetch(url)
  const arrayBuffer = await res.arrayBuffer()
  const audioBuffer = await _audioCtx.decodeAudioData(arrayBuffer)
  _audioBufferCache.set(filePath, audioBuffer)
  return audioBuffer
}

export async function $playAndio(filePath) {
  try {
    const audioBuffer = await _loadAudioBuffer(filePath)
    const source = _audioCtx.createBufferSource()
    source.buffer = audioBuffer
    source.connect(_audioCtx.destination)
    source.start(0)
  } catch (e) {
    console.error('播放失败', e)
  }
}

export function $getNowTime() {
  const d = new Date()
  const pad = (n) => n.toString().padStart(2, '0')
  return `${d.getFullYear()}-${pad(d.getMonth() + 1)}-${pad(d.getDate())} ${pad(d.getHours())}:${pad(d.getMinutes())}:${pad(d.getSeconds())}`
}

export function $messageBox(message, title = '提示', options = {}) {
  var options = {
    confirmButtonText: options.confirmButtonText || '好的',
    type: options.type || 'warning',
  }
  ElMessageBox.alert(message, title, options)
}

export function $toast(content, type = 'none') {
  console.log(content)
  switch (type) {
    case 'none':
      ElMessage.primary(content)
      break
    case 'error':
      ElMessage.error(content)
      break
  }
}
export function isStringNumber(str) {
  return /^-?\d+(\.\d+)?$/.test(str)
}
export function $copyObject(obj) {
  return Object.assign({}, obj)
}

export function $toastError(content) {
  ElMessage.error(content)
}

export function $toastSuccess(content) {
  ElMessage.success(content)
}

export function putConsole(content) {
  return ipcRenderer.invoke('putConsole', content)
}

export function $showLoading(text='Loading...') {
  const loading = ElLoading.service({
    lock: true,
    text: text,
    background: 'rgba(0, 0, 0, 0.7)',
  })
  setTimeout(() => {
    if (loading.visible.value == false) return
    loading.close()
  }, 60000)
  return loading
}

export function $hideLoading(loading) {
  loading.close()
}

export function $generateRandomString(length = 16) {
  const chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
  let result = ''
  const charLength = chars.length

  // 循环生成指定长度的字符串
  for (let i = 0; i < length; i++) {
    // 随机取一个字符
    result += chars.charAt(Math.floor(Math.random() * charLength))
  }

  return result
}

export async function $showConfirm(content,title='提示'){
  let res=await new Promise(resolve=>{
    ElMessageBox.confirm(content,title,{
      confirmButtonText: '确认',
      cancelButtonText: '取消',
      type: 'warning',
    })
        .then(() => {
          resolve(true)
        })
        .catch(() => {
          resolve(false)
        })
  })
  return res

}

export async function $writeConfig(config) {
  ipcRenderer.invoke('writeConfig', config)
}

export async function $readConfig() {
  return await ipcRenderer.invoke('readConfig')
}

export default {
  $getUUID,
  putConsole,
  $writeConfig,
  $readConfig,
  $showConfirm,
  $copyObject,
  $toast,
  $toastError,
  $toastSuccess,
  $showLoading,
  $messageBox,
  $generateRandomString,
  $hideLoading,
  $sendCustomerMsg,
  $getNowTime,
  isStringNumber,
  $getCurrentTime,
  $playAndio,
}
