package Kotlin_From_Basic_To_Advanced

var Name: String? = null

/**
 * Whenever you have to check condition before doing something at that time you had to use if-else condition
 *
 * if you had to group the line and phrase it inside the if condition then you need to group the line's inside {} bracket's
 *
 * else executes then if block of code is not executed
 */

fun main() {
    if (Name != null) {
        println("Hello $Name") //o/p :- blank as the condition is not true
    }else
        println("It is  null therefore it's coming here ")

    Name = "Aditya"
    if (Name != null){
        println("Hello $firstName")
        println("Hello $firstName")
        println("Hello $firstName")
        println("Hello $firstName")
        println("Hello $firstName")
    }
}