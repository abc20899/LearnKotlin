package cn.junechiu.learnkotlin

/**
 * 中辍函数
 * val map = mapOf(1 to ("one"),2 to ("two"),3 to ("three"))
 *
 * mapOf的源码:
 *   public fun <K, V> mapOf(vararg pairs: Pair<K, V>): Map<K, V> =
 *     if (pairs.size > 0) linkedMapOf(*pairs) else emptyMap()
 * mapOf需要一个可变参数，类型是Pair
 *
 * to的源码:
 * public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
 *
 * infix函数需要几个条件:
 * - 只有一个参数
 * - 在方法前必须加infix关键字
 * - 必须是成员方法或者扩展方法
 * infix函数，增加了可读性，让我们的代码更易读懂
 * */

//扩展函数
infix fun Int.add(b: Int): Int {
    return this + b
}

class Account {
    var balance = 100.0

    infix fun add(account: Double): Unit {
        this.balance = balance + account
    }
}

fun main(args: Array<String>) {
    println(1 add 2) //调用函数

    val account = Account()
    account add 100.0
    println(account.balance)
}

