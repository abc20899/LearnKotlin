package cn.junechiu.learnkotlin

/**
 * 安全调用?.
 * 非空断言调用!!.
 *
 * */

fun main(args: Array<String>) {
    var a = "abc" //不可null类型
//    a = null //error null can't be a value of a non-null type string

    var one = 1
//    one = null error

    var na: String? = "abc"  //可空类型
    na = null

    println(na?.length)   // null
    println(na!!.length)  // Exception in thread "main" kotlin.KotlinNullPointerException
}