package Kotlin_From_Basic_To_Advanced

val middleName = "Ravindra"

fun main() {
    /**
     * Variable refres to memory location where we can store value
     * For storing the data we had two options val and var
     *
     * To learn more about basic type of variable refer :- https://kotlinlang.org/docs/basic-types.html#explicit-conversions
     * val -> we can't re-assign variable
     * var -> we can re-assign variable
     *
     * you can also write these variable outside the main function as written in line 3
     *
     * Concatenate
     */

    val firstName: String = "Aditya"
//    firstName = "karan"  //can't possible to modifies
    var lastName: String = "Cheke"
    println(firstName)   // o/p : Aditya
    println(lastName)    // o/p : Cheke


    lastName = "cheke"  //able to modifies
    println(lastName)    // o/p : cheke after modification

    println(middleName)  //o/p : Ravindra


    println("Concatenate first name and last name :- " + firstName + " " + lastName) //will work but not appropriate method

    println("Concatenate first name and last name :- $firstName $lastName") //appropriate method

}