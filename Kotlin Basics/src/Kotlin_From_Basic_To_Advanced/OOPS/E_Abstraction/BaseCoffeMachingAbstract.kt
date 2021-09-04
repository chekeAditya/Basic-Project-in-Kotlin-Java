package Kotlin_From_Basic_To_Advanced.OOPS.E_Abstraction

/**
 * The difference between open and abstract keyword is you can't create instances or the objects of this class but for open class you can create objects
 * if we don't have the actual implementation or the value use for the function or the member variable then it's Abstract
 * Remember :- You can only use this abstract keyword for your member or function inside an abstract class only
 */

abstract class BaseCoffeMachingAbstract(
    private val price: Double,
    private val color: String
) {
    //if you want to make a function or variable abstract then you had to make it abstract or explicitly tell the compiler to make it abstract
    abstract val brand: String

    abstract fun makeCoffeeAbstract(types: String): String

    open fun machineInfoAbstract():String{
        return "Coffee machine details" +
                "Price :"
    }

}