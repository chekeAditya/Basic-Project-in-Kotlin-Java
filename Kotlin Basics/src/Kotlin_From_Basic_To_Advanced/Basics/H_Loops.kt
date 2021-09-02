package Kotlin_From_Basic_To_Advanced

/**
 * In every language we had to 3 types of loops in kotlin also we had the same
1. While 2. Do-While 3.For
 *
 * In while loop it check the conditions in the starting
 * In Do-while loop it check the conditions at the bottom
 */

fun main() {

    val a: IntArray = intArrayOf(2, 3, 4, 5, 10)


    //while loop
    println("While loop : ")
    var i = 1
    while (i <= 10) {
        print("$i ")
        i += 2; //if won't write this line then it will be an infinite loop as value of i is not incrementing
    }

    println()


    //do loop
    println("Do-while loop : ")
    var b = 1;
    do {
        print("$b ")
        b++;
    } while (b <= 10)

    println()

    println("For loop")
    //for loop
    for (x in 1..10) {
        print("$x ")
    }

    println()

    println("All the index of the line number 13")
    for (y in a.indices){
        println(a[y])
    }
}