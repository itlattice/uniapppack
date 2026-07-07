import { getItem, removeItem, setItem } from '@/utils/storage'

export function $setStorage(key, value) {
  return setItem(key, value)
}
export function $getStorage(key) {
  return getItem(key)
}
export function $rmStorage(key) {
  return removeItem(key)
}

export default {
  $setStorage,
  $getStorage,
  $rmStorage,
}
