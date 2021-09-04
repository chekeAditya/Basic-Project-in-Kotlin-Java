package Kotlin_From_Basic_To_Advanced.OOPS.D_Inheritance

/**
 * All the classes in kotlin are final by default so if you want to integrate a class you need to inherit the class you
   had to tell them we had to inherit this class
 * open is used to make the class inheritable, now you can inherit this class in the another class
 */

open class BaseCoffeMaching(
    private val price: Double,
    private val color: String
) {
    //it's private we can't access
     private fun makeCoffeePrivate(){
        println("Here your private coffee is ready")
    }

    fun makeCoffee(){
        println("Here is you coffee is ready")
    }
}