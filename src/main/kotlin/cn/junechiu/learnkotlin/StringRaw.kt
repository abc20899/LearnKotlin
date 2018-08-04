package cn.junechiu.learnkotlin

fun main(args: Array<String>) {
    //原始字符串 跟python一样 """
    val rawString = """
       fun hello(){
          println("hello world")
       }
    """
    println(rawString)

    //字符串模板
    val fooTemplateString = "$rawString has ${rawString.length} characters"
    println(fooTemplateString)
}