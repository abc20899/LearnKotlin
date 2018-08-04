package cn.junechiu.learnkotlin

import java.util.*

/**
 * kotlin中，一切皆对象，变量也是对象
 * var 可写，可被多次赋值
 * val 可读只能赋值一次
 * kotlin首选val不变值
 * */

class VariableVSValue {

    fun declareVar() {
        var a = 1
        a = 2
        println(a)  //2
        println(a::class) //int (Kotlin reflection is not available)
        println(a::class.java)//int

        var x = 5  //自动推断x 为Int类型
        x += 1
        println("x = $x")
    }

    fun declareVal() {
        val b = "a"
        println(b)
        println(b::class)
        println(b::class.java) //class java.lang.String

        val c: Int = 1 //立即赋值
        val d = 2  //自动推断类型
        val e: Int  //如果没有初始值类型不能省略
        e = 3    //明确赋值
        println("c = $c , d = $d , e = $e")
    }

    //类型自动推断
    fun typeInference() {
        val str = "abcd"
        println(str)
        println(str::class.java)

        val d = Date()
        println(d)
        println(d::class.java)

        val bool = true
        println(bool)
        println(bool::class.java)

        val array = arrayOf(1, 2, 3)
        println(array)
        println(array::class.java)
    }

    //is进行类型检测
    fun getLength(obj: Any): Int? {
        var len = 0
        if (obj is String) {
            //if块内 obj 自动转换为string类型
            println(obj::class.java)
            len = obj.length
            println(len)
        }
        //离开类型检测分支后 obj 仍然是Any类型
        println(obj::class.java)
        return len
    }
}

fun main(args: Array<String>) {
    VariableVSValue().declareVar()
    VariableVSValue().declareVal()
    VariableVSValue().typeInference()
//    VariableVSValue().getLength("dddd")
//    VariableVSValue().getLength(333)
}