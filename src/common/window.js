const ipcRenderer = window.require('electron').ipcRenderer

export function $closeApp() {
  return ipcRenderer.invoke('quit-app')
}

export default {
  $closeApp,
}
