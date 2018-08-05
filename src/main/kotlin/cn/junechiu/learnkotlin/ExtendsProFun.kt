package cn.junechiu.learnkotlin

/**
 * 扩展方法
 * anko库中的定义：
 * fun Context.toast(message: Int) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
 *
 * 扩展方法很普通用法不同就是加了个类名。表示这个方法是那个类的方法。
 * 我们知道在Java语言中，要给一个类加个方法只能继承这个类。Kotlin能够很简单的给类价格方法。
 * toast扩展方法表示这个方法类Context的，那么toast方法可以访问Context类的所有成员。
 *
 * 比用Utils代码更简单。
 * fun ImageView.loadImage(url: String) {
 *   Glide.with(context).load(url).into(this)
 * }
 *
 * 扩展属性
 * val View.ctx: Context
 *      get() = context
 * var TextView.textColor: Int
 *   get() = currentTextColor
 *   set(v) = setTextColor(v)
 * */

fun String.notEmpty(): Boolean {
    return !this.isEmpty()
}

//this在扩展函数内部表示对象接收者
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tem = this[index1]
    this[index1] = this[index2]
    this[index2] = tem
}

fun <T> MutableList<T>.mswap(index1: Int, index2: Int) {
    val tem = this[index1]
    this[index1] = this[index2]
    this[index2] = tem
}

//扩展属性 由于扩展没有实际的将成员插入到类中，对于扩展属性来说只能显示的提供set/get方法
val <T> List<T>.lastIndex: Int
    get() = size - 1

fun main(args: Array<String>) {
    println("abc".notEmpty())

    val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6)
    val list2 = mutableListOf<String>("a", "b", "c", "d", "e")
    list.swap(2, 3)
    list2.mswap(1, 2)

    list.forEach {
        println(it)
    }

    list2.forEach {
        println(it)
    }

    println(list.lastIndex) //5
}