package cn.junechiu.learnkotlin

/**
 * Map 不可变
 *MutableMap 可变
 * */

fun main(args: Array<String>) {

    val map = mapOf<Int, String>(1 to "a", 2 to "b", 3 to "c")
    println(map) //{1=a, 2=b, 3=c}

    val mmap = mutableMapOf<Int, String>(1 to "a", 2 to "b", 3 to "c")
    mmap.put(4, "d")
    println(mmap) //{1=a, 2=b, 3=c, 4=d}

    //访问map元素
    val entries = mmap.entries //Set<Entry>
    entries.forEach { println("key=" + it.key + " value=" + it.value) }
    /**
     * key=1 value=a
     * key=2 value=b
     * key=3 value=c
     * key=4 value=d
     * */
    //map.keys
    //map.valuse
    //map.size
    //map.get()

    //操作符
    //    mmap.containsKey()
    //    mmap.containsValue()
    //    mmap.filterKeys {  }
    //    mmap.filterValues {  }
    //    mmap.mapKeys {  }
    //    mmap.mapValues {  }

}