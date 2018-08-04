package cn.junechiu.learnkotlin

/**
 * 包的声明源于文件顶部
 * 目录与包的结构无需匹配
 * */

//包级函数
fun what() {
    print("what is this?")
}

//类
class Person() {

    fun run() {
        print("run...")
    }
}

//mian函数
fun main(args: Array<String>) {
    print("main func")
}