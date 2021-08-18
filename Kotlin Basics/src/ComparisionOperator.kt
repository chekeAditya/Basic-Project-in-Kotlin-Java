import java.util.*

fun main() {
    //comparison operator
    val a = 4
    val b = 10;
    val c = if (a > b) a else b //o.p -> 10
    println(c)

    //loops
    for (i in 0..10) {
        print("$i ") //o.p -> 0 1 2 3 4 5 6 7 8 9 10
    }

    println()

    val name = "Aditya"
    for (element in name)
        print(element)

    println()
    //stepping 2 steps each
    for (i in 1..10 step 2) {
        println("Moving Up side $i")
    }

    println()

    //going down 1 steps each
    for (i in 10 downTo 1 step 2) {
        println("Going down $i")
    }

    println("Printing days :- ")

    //switch Statement
    val day = "Tuesday"
    when (day) {
        "Monday" -> {
            println("Mon")
        }
        "Tuesday" -> {
            println("Tue")
        }
        "Wednesday" -> {
            println("Wed")
        }
        "Friday" -> {
            println("Fri")
        }
        "Saturday" -> {
            println("Sat")
        }
        "Sunday" -> {
            println("Sun")
        }
    }

    //inbetween
    val date = 12;
    when(date){
        in 10..15 -> println("In between 10 to 15")
        in 16..20 -> println("In between 16 to 20")
        in 20..25 -> print("In between 20 to 25")
        else -> print("Above 25")
    }
}