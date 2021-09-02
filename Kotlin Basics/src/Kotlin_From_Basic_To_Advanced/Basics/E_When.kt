package Kotlin_From_Basic_To_Advanced

/**
 * When must be used whenever you had more than 1 condition to check
 * Here we had 3 condition you can write as much condition as you want, and we also had else if nothing matches then it will go their
 *
 * when is an enhanced version of java
 */

fun main() {

    val userType = "admin" //o/p -> Hey you are admin

    when (userType) {
        "admin" -> {
            //if userType is admin then it will come here
            println("Hey you are admin")
        }
        "editor" -> {
            println("Hey you are editor")
        }
        "author" -> {
            println("Hey you are author")
        }
        else -> {
            println("You won't matches any of the above UserType")
        }
    }
}