package Kotlin_From_Basic_To_Advanced

/**
 * In everyone programming language array are the fundamental
 * I hope you know what an array is
 * In kotlin arrays represented using the array class
 *
 * 1. We can use the ArrayOf function
 *
 */

fun main() {


    //Here we define the array of Int i.e Primitive Datatype
    val a: Array<Int> = arrayOf(2, 3, 4, 5, 10, 7, 4, 14)
    println(a[0])  // to print the array you can write a[0] here 0 is the index


    //if we had to define array of Primitive Datatypes then we had classes and function defined for primitive datatypes
    val b: IntArray = intArrayOf(2, 3, 4, 5, 110)
    println("IntArray :- " + b[4]) // (o/p => 110)

    //float
    val c: FloatArray = floatArrayOf(2.5f, 3.9f, 4.2f, 5.09f, 1.10f)
    println("IntArray :- " + c[3]) // (o/p => 5.09)


    //5 = size of the array and the pass the lambda i.e { } and an initializer inside lambda
    val x = Array(5) { 0 }
    println(x[3])
    println(x[1])
}