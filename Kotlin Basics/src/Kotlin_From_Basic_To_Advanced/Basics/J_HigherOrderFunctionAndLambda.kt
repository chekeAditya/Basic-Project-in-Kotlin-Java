package Kotlin_From_Basic_To_Advanced

import kotlin.concurrent.thread

/**
 * in kotlin function are first class means we can store function in variable,
 * we can pass functions as arguments to other function,
 * and we can also return function as a function's
 *
 * Higher Order Function :- A function is called the higher order function when it is accepting an argument that is the function,
 * or it is returning a function, or it is doing both
 * Accepting a function as an argument and returning a function as a return type.
 */

fun main() {
    rollingDice(1..6, 4, { result ->
        println(result)
    })

    val result = RollDice {
        println(it)
    }
        println(result)
}
// when you have the function argument as the last argument of the function then we can put the lambda outside the parenthesis and this is called trailing lambda


fun rollingDice(
    range: IntRange,
    time: Int,
    //put all the parameter which requires
    //Unit means it don't have any return type
    callBack: (result: Int) -> Unit
) {
    for (i in 0..time) {
        val result = range.random()
        callBack(result)
    }
}


fun RollDice(callBack: (result: Int) -> Unit): String {

    thread {
        Thread.sleep(3000)
        callBack(4)
    }
    return "Dice Rolled"
}
/**
 * o.p
 *
 * 3
2
6
1
5
Dice Rolled
4 //here after 3 sec we are getting 4
 */