import { ipcMain } from 'electron'
const sqlite3 = require('sqlite3').verbose()
const path = require('path')
const { app } = require('electron')

export const connectDB = () => {
  const dbPath = path.join(app.getPath('userData'), 'data.db')
  console.log('数据库文件', dbPath)
  const db = new sqlite3.Database(dbPath, err => {
    if (err) {
      console.error('数据库连接失败：', err.message)
    } else {
      console.log('数据库连接成功！')
      // 创建表（示例：用户表）
      db.run(`CREATE TABLE IF NOT EXISTS subject (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          path TEXT NOT NULL,
          config TEXT NOT NULL
        )`)
    }
  })
  return db
}
const db = connectDB()

const runSql = async sql => {
  return new Promise((resolve, reject) => {
    db.run(sql, function(err) {
      if (err) {
        reject(err)
      } else {
        resolve(true)
      }
    })
  })
}

const querySql = async sql => {
  return new Promise((resolve, reject) => {
    db.all(sql, (err, rows) => {
      if (err) {
        reject(err)
      } else {
        resolve(rows)
      }
    })
  })
}

ipcMain.handle('sqlite-query', async (event, sql) => {
  return querySql(sql)
})

ipcMain.handle('sqlite-run', (event, sql, params) => {
  return runSql(sql)
})

export default {
  runSql,
  querySql,
  connectDB,
}
