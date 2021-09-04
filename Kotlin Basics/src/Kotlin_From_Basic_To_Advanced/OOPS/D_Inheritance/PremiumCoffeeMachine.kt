package Kotlin_From_Basic_To_Advanced.OOPS.D_Inheritance

/*
 * This is the child class
 * ":" colon -> refers to the extends or inheriting
 * if constructor is present then we had to pass the constructor also
 *
 * all the classes in kotlin are final by default so if you want to integrate a class you need to inherit the class you
 had to tell them we had to inherit this class for that make the class as open
 *
 * If some properties are private then you cannot access them in the child classes
 */
class PremiumCoffeeMachine(
    private val pricePremium: Double,
    private val colorPremium: String
) : BaseCoffeMaching(pricePremium, colorPremium) {

    fun makePremiumCoffee(){
        makeCoffee() //it's public so you can assess
//        makePrivateCoffee() //can't access as it's private
    }

    fun makeCappuccino(){
        println("Cappuccino is bring ready in 5 min")
    }

}