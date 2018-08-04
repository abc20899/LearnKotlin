package cn.junechiu.learnkotlin

fun main(args: Array<String>) {
    val x = null
    val y = x ?: 0 //等价于 val y = if(x != null) x else 0
    //二元运算符 如果第一个操作数为真则返回，否则返回第二个操作数

    val name = "junehiu"
    val displayName = name ?: "unknow"

    print(displayName)
}