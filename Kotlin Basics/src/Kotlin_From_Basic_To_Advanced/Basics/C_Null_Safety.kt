package Kotlin_From_Basic_To_Advanced

//val firstName: String = null //"Aditya"
var firstName: String? = null //"Aditya"
val lastName = "Cheke"

/**
 * Here in line number 3 if we wrote null instead of Aditya then it will show an error
 * So in this case you need to make that as a nullable by typing ? after String as line no. 4
 *
 * If your variable is of null type and you had to assign some property then you had to put ? (line no. 23) means it is null safe
 * There is one more option use !! (we should avoid using this operator)
 *
 * You can use this operator(!!) only when you are absolutely sure variable is not null
 * for e.g :- in line number 20 ;- throws error Exception in thread "main" java.lang.NullPointerException
 */

fun main() {

    print("Hello ${firstName!!.length}") //o/p : Hello null Cheke


    print("Hello $firstName $lastName") //o/p : Hello null Cheke
    firstName = "karan"
    print("Hello $firstName $lastName") //o/p : Hello karan Cheke

    println("Hello ${firstName?.length}") //o/p :

}