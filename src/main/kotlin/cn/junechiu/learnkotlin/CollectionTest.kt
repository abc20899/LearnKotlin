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

    //fold(initial: R,operation(acc:R,T)) 带初始值的reduce
    val list4 = arrayListOf<Int>(1, 2, 3, 4)
    val fold = list4.fold(100, { total, next -> next + total })
    println("fold:$fold") //fold:110

    //max、min 最大值最小值 如果没有则返回null
    println("max:${list4.max()}") //max:4
    println("min:${list4.min()}") //min:1

    //maxBy(selector:(T)->R):T?  minBy(selector:(T)->R):T?
    //sumBy(selector:(T)->Int):Int 获取函数映射值的总和


    //过滤操作函数
    //take(n:Int):List<T>  返回前N个元素的子集
    val listTake = listOf("a", "b", "c")
    listTake.take(2).forEach(::println) //a,b
    //takeWhile(predicate:(T):Boolean)->List<T> 返回满足条件的子集，如果遇到任何一个不满足条件，就结束循环
    val listTake2 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    listTake2.takeWhile({ it % 2 == 0 }).forEach(::println) //[]
    listTake2.takeWhile({ it % 2 == 1 }).forEach(::println) //[1]
    //takeLast(n:Int) 返回后N个元素的子集 挑出后N个元素的子集
    //从最后开始挑出满足条件元素的子集合
    //takeLastWhile(predicate:(T)->Boolean):List<T>

    //drop(n:Int):List<T> 去除前n个元素，返回剩下的元素集合
    val listDrop = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    listDrop.drop(5).forEach(::println)//6,7,8,9
    //dropWhile(predicate:(T)->Boolean):List<T> 去除满足条件的元素，返回剩下的元素的子集
    //dropLast(n:Int) 从最后去除N个元素
    val list2Drop = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    list2Drop.dropLast(3).forEach(::println) //1, 2, 3, 4, 5
    //dropLastWhile(predicate:(T)->Boolean) 从最后去除满足条件的元素

    //slice(indices:IntRange) 取开始下标至结束下标元素子集合
    val listSlice = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    listSlice.slice(1..3).forEach(::println)//2,3,4
    //slice(indices:Iterable<Int>) //返回指定下标的元素
    listSlice.slice(listOf(0, 2, 4)).forEach(::println) //1,3,5

    //filterTo(des:C,predicate:(T)->Boolean) 过滤出满足条件的元素子集赋值给des
    val listFilter = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    val desList = mutableListOf<Int>()
    listFilter.filterTo(desList, { it % 2 == 0 })
    desList.forEach(::println)
    //filter(predicate:(T):Boolean) 过滤出满足条件的元素组成的子集合
    listFilter.filter { it % 2 == 0 }.forEach(::println)
    //filterNot(predicate:(T->Boolean)) 过滤所有不满足条件的元素
    //filterNotNull() 过滤掉null元素


    //映射操作函数
    //map(transform:(T)->R):List<R> 将集合中的元素通过转换函数transform映射后的结果，存到一个集合中返回
    val listMap = listOf(1, 2, 3, 4, 5)
    listMap.map { it * it }.forEach(::println)
    listMap.map { it + 10 }.forEach(::println)
    //mapIndexed(transform:(kotlin.Int,T)->R) transform转换函数带有下标和元素
    listMap.mapIndexed({ index, it -> index * it }).forEach(::println)
    //mapNotNull(transform:(T)->R?) 遍历所有元素返回一个无null 的集合
    //在原始集合的每个元素上调用transform转换函数，得到的映射结果组成单个列表
    //flatmap(transform:(T)->Iterable<R>):List<R>
    val listFmap = listOf("a", "b", "c")
    listFmap.map { it -> listOf(it + 1, it + 2, it + 3) }  //[[a1,a2,a3],[b1,b2,b3],[c1,c2,c3]]
    listFmap.flatMap { it -> listOf(it + 1, it + 2, it + 3) }//[[a1,a2,a3,b1,b2,b3,c1,c2,c3]


    //分组操作函数
    val words = listOf("add", "bcvbnf", "cs", "1dd", "2fghts")
    //groupBy(keySelector: (T) -> K): Map<K, List<T>>
    //将集合中的元素按照keySelector条件选择器分组，并返回map
    val lengthGroup = words.groupBy { it.length } //按照元素长度进行分组
    println(lengthGroup) //{3=[add, 1dd], 6=[bcvbnf, 2fghts], 2=[cs]}
    //groupBy(keySelector: (T) -> K, valueTransform: (T) -> V): Map<K, List<V>>
    //将集合中的元素按照keySelector条件选择器和变换函数valueTransform进行分组，并返回map
    val programmer = listOf("K&R" to "C", "Bjar" to "C++", "James" to "Java", "Linus" to "C") //Pair 二元数据组 a to b
    val programmer2 = programmer.groupBy({ it.second }, { it.first }) //按照Value分组 key变换
    println(programmer2)//{C=[K&R, Linus], C++=[Bjar], Java=[James]}


    //排序操作函数
    val listR = listOf(1, 2, 3, 4, 5, 6)
    val listR2 = listR.reversed() //倒序排列
    println(listR2) //[6, 5, 4, 3, 2, 1]
    var listSort = listOf(3, 9, 1, 5, 2, 8)
    listSort = listSort.sorted() //升序
    println(listSort) //[1, 2, 3, 5, 8, 9]
    listSort = listSort.sortedDescending() //降序
    println(listSort) //[9, 8, 5, 3, 2, 1]
    var listWord = listOf("junec", "a", "adc", "", "sddd")
    listWord = listWord.sortedBy { it.length }
    println(listWord) //[, a, adc, sddd, junec]
    listWord = listWord.sortedByDescending { it.length }
    println(listWord) //[junec, sddd, adc, a, ]


    //生产操作符
    //zip 两个集合按照下标配对 组合成新的list<Pair<T,R>>
    val list11 = listOf(1, 2, 3)
    val list22 = listOf(1, 2, 3, 4)
    val list33 = listOf("a", "b", "c")
    val zipList1 = list11.zip(list33)
    println(zipList1) //[(1, a), (2, b), (3, c)]
    val zipList2 = list22.zip(list33)
    println(zipList2) //[(1, a), (2, b), (3, c)] //取最短的长度
    val zipList3 = list33.zip(list22)
    println(zipList3) //[(a, 1), (b, 2), (c, 3)]
    //partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>>
    //判断元素是否满足predicate条件 进行分组
    val list44 = listOf(11, 2, 33, 3, 5, 4, 8)
    val pairList = list44.partition { it > 5 }
    println(pairList) //([11, 33, 8], [2, 3, 5, 4])
    //plus 合并两个list
    //plusElement 在集合中添加一个元素

    
}