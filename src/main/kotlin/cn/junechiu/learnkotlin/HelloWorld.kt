package cn.junechiu.learnkotlin

import java.text.SimpleDateFormat
import java.util.*

/**
 * 云端IDE
 * https://try.kotlinlang.org
 *
 * 命令行
 * kotlinc 进入REPL环境
 *   print("hello world")
 *   Date()
 * */
fun main(args: Array<String>) {
    print("hello world\n")
    print(SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()))
}