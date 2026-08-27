@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.iboxsSqlite
import android.content.Context
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
typealias Init = (dbName: String, version: Int, password: String) -> Unit
typealias ExecuteSql = (sql: String) -> Unit
typealias QueryData = (sql: String) -> UTSArray<UTSJSONObject>
typealias ExportDatabase = (databaseName: String) -> Boolean
val init: Init = fun(dbName: String, version: Int, password: String): Unit {
    IboxsSqliteManager.init(UTSAndroid.getAppContext() as Context, dbName, version, password)
}
val executeSql: ExecuteSql = fun(sql: String): Unit {
    IboxsSqliteManager.executeSql(sql)
}
val queryData: QueryData = fun(sql: String): UTSArray<UTSJSONObject> {
    var data = IboxsSqliteManager.queryData(sql)
    var result = JSON.parseArray(data)
    if (result == null) {
        return _uA<UTSJSONObject>()
    }
    return result as UTSArray<UTSJSONObject>
}
val exportDatabase: ExportDatabase = fun(sql: String): Boolean {
    return IboxsSqliteManager.exportDatabase(UTSAndroid.getAppContext() as Context, sql)
}
