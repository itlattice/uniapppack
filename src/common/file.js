import { app } from 'electron'

const { ipcRenderer } = window.require('electron')

export async function $readFile(filePath) {
  return await ipcRenderer.invoke('read-local-file', filePath)
}

export async function $readBinaryFileBase64(filePath) {
  return await ipcRenderer.invoke('read-local-file', filePath, 'base64')
}

export async function $readAppFile(filePath, encoding = 'utf8') {
  return await ipcRenderer.invoke('read-app-file', filePath, encoding)
}

export async function $fileExists(filePath) {
  console.log(filePath)
  return await ipcRenderer.invoke('check-file-exists', filePath)
}

export async function $getResourcePath() {
  return await ipcRenderer.invoke('get-resource-path')
}

export async function $pushPackLog(log){
  return await ipcRenderer.invoke('push-pack-log', log)
}

export async function $choosePath(){
  return await ipcRenderer.invoke('choosePath')
}

export async function $pathExists(path){
  return await ipcRenderer.invoke('pathExists', path)
}

export async function $chooseFile(extension){
  return await ipcRenderer.invoke('chooseFile', extension)
}

export async function $deletePath(path){
  return await ipcRenderer.invoke('deletePath', path)
}

export async function $createPath(path){
  return await ipcRenderer.invoke('check-and-create-folder', path)
}

export default {
  $readFile,
  $readBinaryFileBase64,
  $readAppFile,
  $fileExists,
  $getResourcePath,
  $choosePath,
  $deletePath,
  $createPath
}
