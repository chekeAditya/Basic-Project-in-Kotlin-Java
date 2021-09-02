package Kotlin_From_Basic_To_Advanced

/**
 * So far we had seen 2 function i.e main function and a pre-defined function called printLn()
 * But we are not limited there are so many pre-defined function, and we can also create our own function
 *
 * Why do we use function?
 * Suppose you had a problem statement. Now you had to option to solve it either write the answer in the main function or
 * can break down that problem into sub-problem and write it inside separate function.
 *
 * Function is a block of statement that can perform a specific task, it also helps to code re-usability
 *
 * We can also pass multiple argument inside a function
 */


fun main() {
    //it means whatever we write inside rollDice
    //here we can call as many funcation as we want and value will different as we are using .random function
    println("Roll dice")
    rollDice() // o/p : random
    rollDice() // o/p : random
    rollDice() // o/p : random

    println("Roll dice with Argument")
    //with argument
    rollDiceWithArgument(4) // o/p : 2


    println("Roll dice with Multiple Argument")
    //with multiple argument
    rollDiceWithMultipleArgument(4, (1..10)) // o/p : 9 10 5 10 or can come random


    println("When you don't have fix number of argument")
    //if you don't have fix number of argument
    getSum(5, 6, 10, 20)  //o/p : 41

    println("Roll Dice With DefaultValue")
//    rollDiceWithDefaultValue() //here if we won't define any range then it will take default range
    rollDiceWithDefaultValue(5, (10..19)) //here if we won't define any range then it will take default range


    println("Make Burger")
    makeBurger("XL", true, true, "Chicken")

    println()

    println("If you used named Argument then it is not necessary to pass the parameter in the same sequential")
    makeBurger(types = "Chicken", size = "XL", makeItAMeal = true, extraCheese = true)

    println()
    println("Printing the return stmt")
    val returnSum = getSumWithReturnType(5, 20, 5, 20)
    println(returnSum)

    println()
    println("single Expression Function")
    val returnSumWithSingleLineExpression = getSingleExpressionFunction(46, 220, 9, 20)
    println(returnSumWithSingleLineExpression)

}


//function
fun rollDice() {
    val result = (1..6).random() //this random function will return random value from this range
    println(result)
}

// we can also pass argument
fun rollDiceWithArgument(times: Int) {
    val result = (1..6).random() //this random function will return random value from this range
    println(result)
}

//passing multiple argument
fun rollDiceWithMultipleArgument(times: Int, range: IntRange) {
    for (i in 0 until times) {
        val result = range.random()
        println(result)
    }
}

//if you don't have fix number of argument, here it will accept variable number of argument use keyWord vararg
fun getSum(vararg numbers: Int) {
    println(numbers.sum())
}

//if we don't pass any value then it will take default value
fun rollDiceWithDefaultValue(
    times: Int = 1,
    range: IntRange = (1..6)
) {
    val result = (1..6).random()
    println(result)
}

//here we had write the reponse as it is asking in the parameters
fun makeBurger(
    size: String,
    extraCheese: Boolean,
    makeItAMeal: Boolean,
    types: String
) {

    println("Size: $size")
    println("Extra Cheese: $extraCheese")
    println("Make It A Meal: $makeItAMeal")
    println("Type : $types")
}

//here this function is returning int
fun getSumWithReturnType(vararg nums: Int): Int {
    return nums.sum() //this time it will not print it will return the sum value
}

//single Expression Function
fun getSingleExpressionFunction(vararg nums:Int) = nums.sum() //if you have a single expression of the function then you can use this


/**
 * Output of all the mainFunction
Roll dice
6
4
4
Roll dice with Argument
6
Roll dice with Multiple Argument
7
2
8
1
When you don't have fix number of argument
41
Roll Dice With DefaultValue
6
Make Burger
Size: XL
Extra Cheese: true
Make It A Meal: true
Type : Chicken

If you used named Argument then it is not necessary to pass the parameter in the same sequential
Size: XL
Extra Cheese: true
Make It A Meal: true
Type : Chicken

Printing the return stmt
50

single Expression Function
295

 */