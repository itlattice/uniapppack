# 修改配置信息（UniappX - Android）
* CPU打包的架构信息使用打包时配置的勾选的架构，不再使用配置文件内的。
* 根据打包模式使用不同的SDK和方式进行打包。

# UniappX 安卓蒸汽模式开发
* 配置使用的安卓SDK包使用配置文件src\components\configWindow.vue内配置的对应的SDK。
* 蒸汽模式的打包方式与VDOM打包方式有所不同，不要动VDOM模式的文件，新增一个新的打包js文件，写入新的打包程序。
* 蒸汽模式Android打包文档：https://doc.dcloud.net.cn/uni-app-x/native/use/android.html 及附近网页。
