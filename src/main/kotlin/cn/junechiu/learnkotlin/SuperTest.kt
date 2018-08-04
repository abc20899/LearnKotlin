package cn.junechiu.learnkotlin

open class Father {
    open val firstName = "chiu"
    open val lastName = "june"

    fun ff() {
        println("fff")
    }
}

class Son : Father {
    override var firstName = super.firstName
    override var lastName = "jiji"

    constructor(lastName: String) {
        this.lastName = lastName
    }

    fun love() {
        super.ff()
        println(super.firstName + " " + super.lastName + " Love " + this.firstName + " " + this.lastName)
    }
}

fun main(args: Array<String>) {
    val son = Son("Harry")
    son.love()
}