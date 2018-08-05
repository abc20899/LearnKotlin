package cn.junechiu.learnkotlin

/**
 * kotlin中所有类型都是引用类型
 * 对象比较equals 与 == 效果一样
 *
 * ! not()
 * && and()
 * || or()
 *
 * String 是final 不可继承的
 *
 * public class Array<T> {
 *  public inline constructor(size: Int, init: (Int) -> T)
 *  public operator fun get(index: Int): T
 *  public operator fun set(index: Int, value: T): Unit
 *  public val size: Int
 *  public operator fun iterator(): Iterator<T>
 * }
 * */

fun main(args: Array<String>) {
    val any = Any()
    println(any)  //java.lang.Object@6f94fa3e
    println(any::class) //class java.lang.Object (Kotlin reflection is not available)
    println(any::class.java) //class java.lang.Object



    //1.字符串
    val ss = "abc"
    println(ss[0]) //索引 charAt 函数
    for (s in ss) {
        println(s)
    }
    //重载+操作
    ss.plus(22)
    ss.plus(null)

    //字符串模板
    val str = "cvbn"
    val strdes = "$str.length is ${str.length}"
    println(strdes)



    //2.数组类型 Array: set get size iterator
    val intArr = arrayOf(1, 2, 3, 4) //创建数组
    val anyArr = arrayOf(1, "b", true)
    anyArr.forEach {
        println(it)
        println(it::class)
    }

    //创建一个指定大小、元素类型的数组
    val aaa = arrayOfNulls<Int>(10)

    //array的一个构造函数 public inline constructor(size: Int, init: (Int) -> T)
    val square = Array(10, { i -> i * i }) //大小、函数类型
    square.forEach {
        println(it)  //每个元素的二次幂0、1、4、9、16
    }

    //不能把Array<String> 赋值给Array<Any>



    //null Nothing? 可空类型Any?
    println(null is Any?) //true

    //Unit  void

    //is 类型判断，判断的时候自动转换 !is

    //as 兼容类型转换

    //Any? Any
}