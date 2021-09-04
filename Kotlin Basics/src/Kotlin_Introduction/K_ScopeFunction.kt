package Kotlin_Introduction

import kotlin.math.sqrt

/**
 *Kotlin Scope

Function / Context Obj / Return value
let         it          lambda result
run         this        lambda result
with        this        lambda result
apply       this        context object
also        it          context object

 * All these function find a scope where you can find the object.
 *
 * let -> we use let function for the null safety or to check if the value is null of not
 */

class Square(
    private val width: Int,
    private val height: Int,
    private var color: String? = null,
    private var text: String? = null
) {
    fun fillColor(color: String) {
        this.color = color
        println("$color Color filled")
    }

    fun addText(text: String) {
        this.text = text
        println("\"$text\" text added")
    }

    override fun toString(): String {
        return "Square(width=$width,height=$height,color=$color,text=$text)"
    }
}

lateinit var square: Square

fun main() {

//  Using the block of curly braces scope is formed
    val square = Square(10, 20).let {//square-> if you want you can change the name of the argument i.e it to square
//        square.fillColor("RED") //then instead of it we had to write Square
        it.fillColor("RED")
        it.addText("Some Text")

        // now the last stmt you are going to write is the return value, and it's optional if don't write anytime it means you are returning units
        it
    }
//    println(square)       //printing the o/p
    /**
     * o/p : RED Color filled
    "Some Text" text added
    Square(width=10,height=20,color=RED,text=Some Text)
     */

//    var square1: Square? = null//square comming from somewhere and it can be null
//    square1.let {
//        square = it
//    }

    // now square is being referred using this
    val square1 = Square(20, 30).run {
        this.addText("Run Scope Text")
        this.fillColor("Blue")
        //it also returns this as it returns the lambda value abd you don't have to write explicit function
        this
    }
//    println(square1)      //printing the o/p

    /**
     * o.p:- Run Scope Text" text added
    Blue Color filled
    Square(width=20,height=30,color=Blue,text=Run Scope Text)
     */


//    if you are having so many function then you can use with to simply your code
//    you can pass your object inside with function, and it will form a temporary scope so that you can call all the function
    val square3 = Square(10, 20)
    with(square3) {
        square.addText("Text In WIth tag")
        square.fillColor("Green")
    }
    println(square3)

    /**
     * O.P:-    Text In WIth tag" text added
    Green Color filled
    Square(width=10,height=20,color=null,text=null)

     */
//    square3.fillColor("Green")
//    square3.addText("With scopre function")

//    apply we can use to perform the initial configuration object
    val square4 = Square(30, 40).apply {
        fillColor("Yellow")
        addText("Apply text function")
    }
    println(square4)
    /**
     * o/p :- Yellow Color filled
              Apply text function" text added
              Square(width=30,height=40,color=Yellow,text=Apply text function)

     */

    val square5 = Square(30, 40).apply {
        fillColor("Purple")
        addText("Also text function")
    }
    println(square5)
    /**
     * o/p :-   Purple Color filled
                Also text function" text added
                Square(width=30,height=40,color=Purple,text=Also text function)


     */
}