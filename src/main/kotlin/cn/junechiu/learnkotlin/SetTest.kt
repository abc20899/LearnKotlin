package cn.junechiu.learnkotlin

/**
 * Set 不可变
 *
 * MutableSet 可变
 * 元素不可重复
 * */
fun main(args: Array<String>) {

    val set1 = emptySet<Int>()
    println(set1.size)

    val list = listOf<Int>(1, 2, 2, 3, 4, 4)
    val set2 = setOf<Int>(1, 2, 2, 3, 3)
    println(list) //[1, 2, 2, 3, 4, 4]
    println(set2)//[1, 2, 3]
    val set3 = list.toSet() //toSet 是Array类的扩展
    println(set3) //[1, 2, 3, 4]

    //set元素加减操作
    val ms = mutableSetOf<Int>(1, 3, 2, 7)
    val ms2 = ms + 10
    println(ms2) //[1, 3, 2, 7, 10]
    val ms3 = ms - 1
    println(ms3) //[3, 2, 7]
}