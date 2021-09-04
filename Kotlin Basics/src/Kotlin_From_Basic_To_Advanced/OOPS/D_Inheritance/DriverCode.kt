package Kotlin_From_Basic_To_Advanced.OOPS.D_Inheritance

fun main() {
    //here we are inheriting the properties of the Coffee
    val coffeMaching = BaseCoffeMaching(1000.0,"brown")
    coffeMaching.makeCoffee()

    //now you can call the premiumCoffee Machine here
    val premiumCoffeeMachine = PremiumCoffeeMachine(2000.6,"Black")
    premiumCoffeeMachine.makeCoffee() //inheriting the function of baseCoffee machine as this class is inheriting the properties

    premiumCoffeeMachine.makeCappuccino()
}
/*
o/p :-
Here is you coffee is ready
Here is you coffee is ready
Cappuccino is bring ready in 5 min
 */