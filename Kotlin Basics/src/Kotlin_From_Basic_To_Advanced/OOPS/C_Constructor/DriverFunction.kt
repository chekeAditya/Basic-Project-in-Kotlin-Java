package Kotlin_From_Basic_To_Advanced.OOPS.C_Constructor

import Kotlin_From_Basic_To_Advanced.OOPS.Box

fun main() {
//    instance
//    you can also pass named argument as well as shown below
//    val boxConstructor = BoxConstructor(lengthConstructor = 10,widthConstructor = 18,heightConstructor = 19)


    val boxConstructor = BoxConstructor(10,18,19)

}
// if we won't write inside the primary constructor then by default secondary constructor will be called