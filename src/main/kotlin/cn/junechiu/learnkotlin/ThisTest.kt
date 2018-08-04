package cn.junechiu.learnkotlin

/**
 * 如果this没有限定符
 * 想要引用其他作用域中的this，可以使用this@label
 * */
class Outer {
    val oh = "OH!"

    inner class Inner {
        fun m() {
            val outer = this@Outer
            val inner = this@Inner
            val pthis = this
            println("outer = " + outer)
            println("inner = " + inner)
            println("pthis = " + pthis)
            println(outer.oh)

            val fun1 = hello@ fun String.() {
                val d1 = this //fun1 的接受者
                println("d1=" + d1)
            }

            val fun2 = { s: String ->
                val d2 = this
                println("d2=" + d2)
            }

            "abc".fun1()
            fun2
        }
    }
}

fun main(args: Array<String>) {
    val outer = Outer()
    outer.Inner().m()
}