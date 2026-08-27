package uts.sdk.modules.iboxsSqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Environment
import android.util.Log
import net.sqlcipher.database.SQLiteDatabaseHook
import net.sqlcipher.database.SQLiteException
import net.sqlcipher.database.SQLiteStatement
import net.sqlcipher.database.SupportFactory
import net.sqlcipher.Cursor
import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

object IboxsSqliteManager {
    private var databaseHelper: DatabaseHelper? = null

    fun init(context: Context, dbName: String, version: Int, password: String) {
        databaseHelper = DatabaseHelper(context, dbName, version, password)
    }

    fun executeSql(sql: String) {
        databaseHelper?.let {
            try {
                it.executeSql(sql)
            } catch (e: SQLiteException) {
                Log.e("Database", "Error executing SQL: ${e.message}", e)
            }
        }
    }

    fun queryData(querySql: String): String {
        return databaseHelper?.queryData(querySql) ?: "[]"
    }

    fun exportDatabase(context: Context, databaseName: String): Boolean {
        return databaseHelper?.exportDatabase(context, databaseName) ?: false
    }

    private class DatabaseHelper(context: Context, name: String, private val dbVersion: Int, private val password: String) :
        SQLiteOpenHelper(context, name, null, dbVersion) {

        private val mContext = context
        private val mName = name

        init {
            net.sqlcipher.database.SQLiteDatabase.loadLibs(mContext)
        }

        override fun onCreate(db: android.database.sqlite.SQLiteDatabase) {
            // 这里不定义特定表，可根据需要在外部创建表
        }

        override fun onUpgrade(db: android.database.sqlite.SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            // 可根据需要实现表升级逻辑
        }

        fun getEncryptedWritableDatabase(): net.sqlcipher.database.SQLiteDatabase {
            val passphrase = net.sqlcipher.database.SQLiteDatabase.getBytes(password.toCharArray())
            val factory = SupportFactory(passphrase)
            val configCallback = object : SupportSQLiteOpenHelper.Callback(dbVersion) {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    // 这里不定义特定表，可根据需要在外部创建表
                }

                override fun onUpgrade(
                    db: SupportSQLiteDatabase,
                    oldVersion: Int,
                    newVersion: Int
                ) {
                    // 可根据需要实现表升级逻辑
                }
            }
            val config = SupportSQLiteOpenHelper.Configuration.builder(mContext)
               .name(mName)
               .callback(configCallback)
               .build()
            return try {
                val helper = factory.create(config)
                val db = helper.writableDatabase as net.sqlcipher.database.SQLiteDatabase
                val setCipherCompatibilityQuery = "PRAGMA cipher_compatibility = 4;"
                db.rawExecSQL(setCipherCompatibilityQuery)
                db
            } catch (e: SQLiteException) {
                throw e
            }
        }

        @Throws(SQLiteException::class)
        fun executeSql(sql: String) {
            var db: net.sqlcipher.database.SQLiteDatabase? = null
            var statement: SQLiteStatement? = null
            try {
                db = getEncryptedWritableDatabase()
                db.beginTransaction()
                statement = db.compileStatement(sql)
                statement.execute()
                db.setTransactionSuccessful()
            } catch (e: SQLiteException) {
                Log.e("Database", "Error executing statement: ${e.message}", e)
                throw e
            } finally {
                statement?.close()
                db?.endTransaction()
                db?.close()
            }
        }

        fun queryData(querySql: String): String {
            var db: net.sqlcipher.database.SQLiteDatabase? = null
            var cursor: Cursor? = null
            val jsonArray = JSONArray()
            try {
                db = getEncryptedWritableDatabase()
                cursor = db.rawQuery(querySql, null)
                if (cursor.moveToFirst()) {
                    do {
                        val jsonObject = JSONObject()
                        for (i in 0 until cursor.columnCount) {
                            val columnName = cursor.getColumnName(i)
                            when (cursor.getType(i)) {
                                Cursor.FIELD_TYPE_INTEGER -> jsonObject.put(columnName, cursor.getInt(i))
                                Cursor.FIELD_TYPE_FLOAT -> jsonObject.put(columnName, cursor.getFloat(i))
                                Cursor.FIELD_TYPE_STRING -> jsonObject.put(columnName, cursor.getString(i))
                                Cursor.FIELD_TYPE_BLOB -> jsonObject.put(columnName, cursor.getBlob(i))
                                else -> jsonObject.put(columnName, null)
                            }
                        }
                        jsonArray.put(jsonObject)
                    } while (cursor.moveToNext())
                }
            } catch (e: Exception) {
                Log.e("Database", "Error querying data: ${e.message}", e)
            } finally {
                cursor?.close()
                db?.close()
            }
            return jsonArray.toString()
        }

        fun exportDatabase(context: Context, databaseName: String): Boolean {
            try {
                // 获取数据库文件的路径
                val dbFile = context.getDatabasePath(databaseName)
                if (!dbFile.exists()) {
                    return false
                }

                // 检查外部存储是否可写
                if (!isExternalStorageWritable()) {
                    return false
                }

                // 创建导出目录
                val exportDir = File(Environment.getExternalStorageDirectory(), "ExportedDatabases")
                if (!exportDir.exists()) {
                    exportDir.mkdirs()
                }

                // 创建导出文件
                val exportFile = File(exportDir, databaseName)
                if (exportFile.exists()) {
                    exportFile.delete()
                }

                // 复制文件
                val inputStream = FileInputStream(dbFile)
                val outputStream = FileOutputStream(exportFile)
                val buffer = ByteArray(1024)
                var length: Int
                while (inputStream.read(buffer).also { length = it } > 0) {
                    outputStream.write(buffer, 0, length)
                }
                outputStream.flush()
                outputStream.close()
                inputStream.close()
                return true
            } catch (e: IOException) {
                e.printStackTrace()
                return false
            }
        }

        private fun isExternalStorageWritable(): Boolean {
            val state = Environment.getExternalStorageState()
            return state == Environment.MEDIA_MOUNTED
        }
    }
}