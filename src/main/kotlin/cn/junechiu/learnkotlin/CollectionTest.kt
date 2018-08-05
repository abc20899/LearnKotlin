package cn.junechiu.learnkotlin

/***
 * 可变集合，不可变集合
 * list、set、map
 *
 * private open inner class IteratorImpl : Iterator<E> {
 *    protected var index = 0
 *    override fun hasNext(): Boolean = index < size
 *    override fun next(): E {
 *
 *   if (!hasNext()) throw NoSuchElementException()
 *      return get(index++)
 *   }
 * }
 * */

fun main(args: Array<String>) {
    //不可变list
    val list1 = listOf<Int>() //空list
    val list2 = listOf(1) //一个元素 java.util.Collections.singletonList(element)
    val list3 = listOf(1, 2, 3, 4, 5, 6, 7) //多个元素

    val arrList = arrayListOf<Int>(1, 2, 3)
    println(arrList::class) // class java.util.ArrayList


    //创建可变list
    val mList1 = mutableListOf<Int>(1, 2, 3)
    mList1.add(4)
    println(mList1::class) //class java.util.ArrayList


    //遍历
    val iterator = list3.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }
    list3.forEach { println(it) }
    list3.forEach(::println)  //::函数引用符


    //操作函数
    //add、remove、retainAll两个集合的交集、contains、first、last。。。。


    //运算函数
    //1.any至少有一个元素
    println(list3.any())
    println(list3.any { it % 2 == 0 }) //是否有偶数
    //2.all集合中的元素是否都满足条件
    println(list3.all { it > 0 })
    //3.none()，none{}判断集合无元素
    //4.count(),count{}满足条件的个数
    println(list3.count { it % 2 == 0 }) //3
    //5.reduce 第一项到最后一项累计运算 reduceRight:最后一项到第一项开始累计
    val sum = list3.reduce({ sum, next -> sum + next })
    println("sum:$sum")
}