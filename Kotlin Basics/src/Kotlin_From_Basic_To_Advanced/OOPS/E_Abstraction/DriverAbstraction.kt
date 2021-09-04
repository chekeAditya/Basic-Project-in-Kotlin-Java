package Kotlin_From_Basic_To_Advanced.OOPS.E_Abstraction

/**
 * using BaseCoffeeMachine and PremiumCoffeeMachine
 */

fun main() {
    val coffeMachingAbstract = PremiumCoffeeMachineAbstract(1200.9, "black")
    val infor = coffeMachingAbstract.machineInfoAbstract()
    val coffee = coffeMachingAbstract.makeCoffeeAbstract("CAPPUCCINO")
    println(infor)
    println(coffee)
}