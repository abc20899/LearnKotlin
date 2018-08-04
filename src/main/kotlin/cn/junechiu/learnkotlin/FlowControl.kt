package cn.junechiu.learnkotlin

/**
 *  if表达式
 *  if作为代码块，最后一行为其返回值
 *  kotlin中没有三元表达式---> if(true) 1 else 0
 *
 *  when(值，表达式，in,!in)
 *
 *  for,while
 *
 *  break,continue
 *
 *  return kotlin中可以直接用=来返回一个函数的值
 * */
fun main(args: Array<String>) {

    println(max(2, 4))
    println(max1(3, 6))
    whenIn()
    testFor()
    testWhile()
    breakDemo()
    continueDemo()
    returnTest()
}

//if表达式
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//if作为代码块
fun max1(a: Int, b: Int): Int {
    val max = if (a > b) {
        println("max is a")
        a
    } else {
        println("max is b")
        b
    }
    return max
}

fun cases(obj: Any) {
    when (obj) {
        1 -> println("int")
        "abc" -> println("字符串")
        is Long -> println("is long")
        !is String -> println("not string")
        else -> println("java 中的 default")
    }
}

fun switch(x: Any) {
    when (x) {
        -1, 0 -> println("x == -1 or x == 0")
        1 -> println("x is 1")
        else -> { //代码块
            println("代码块")
        }
    }
}

fun switch(x: Int) {
    val s = "123"
    when (x) {
        2 -> println("x == 2")
        s.toInt() -> println("x is 123")
    }
}

fun whenIn() {
    val x = 1
    val arr = arrayOf(1, 2, 3)
    when (x) {
        in 1..10 -> println("x is in range")
        in arr -> println("x is in arr")
        !in 10..20 -> println("x is not in range")
    }
}

fun testFor() {
    val list = arrayOf(1, 2, 3, 4, 5, 6, 7, 8)

    for (i in list) {
        print(i)
    }

    for (index in list.indices) {
        print(list[index])
    }

    for ((index, value) in list.withIndex()) {
        print("$index == $value")
    }
}

fun testWhile() {
    var x = 0
    while (x < 10) {
        println(x)
        x += 1
    }

    var y = 10
    do {
        y -= 1
        println(y)
    } while (y <= 0)
}

fun breakDemo() {
    for (i in 1..10) {
        println(i)
        if (i % 2 == 0) {
            break
        }
    }
}

fun continueDemo() {
    for (i in 1..10) {
        if (i % 2 == 0) {
            continue //跳出此次循环
        }
        println(i)
    }
}

fun sum(a: Int, b: Int) = a + b
//fun max(a: Int, b: Int) = if (a > b) a else b
fun returnTest() {
    println(sum(2, 3))

    println(sumf(3, 4).invoke())
}

//返回值是函数类型 ()->Kotlin.Int
fun sumf(a: Int, b: Int) = { a + b }


