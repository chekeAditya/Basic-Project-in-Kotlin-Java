package Kotlin_From_Basic_To_Advanced

fun main() {
    val a = 10
    val b = 20
    val c = if (a > b) a else b //here we can also write it as a stmt
    println(c) //here it's printing b as a < b


    val userType =  "admin"
    val result = when(userType){
        "admin" -> "User is an Admin"
        "editor" -> "User is an Editor"
        "author" -> "User is an Author"
        else -> "Hey you are not matches"
    }
    println(result) //as the userType matches it wil print those accordingly
}