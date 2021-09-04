package Kotlin_From_Basic_To_Advanced.OOPS.E_Abstraction

/*
 * To remove the error either you had to make the child class abstract or if you don't want to make child class abstract then
 * override or implement, or you need to define the implementation all the abstract function and variable
 *
 * you can also override open function and varible
 */
class PremiumCoffeeMachineAbstract(
    private val pricePremium: Double,
    private val colorPremium: String
) : BaseCoffeMachingAbstract(pricePremium, colorPremium) {

    //here we had overridden
    override val brand: String
        get() = "Brand X"

    //to override the function and variable we use this override keyword
    override fun makeCoffeeAbstract(types: String): String {
        return "Your $types is ready "
    }

}