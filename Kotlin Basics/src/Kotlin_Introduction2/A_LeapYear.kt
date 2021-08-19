package Kotlin_Introduction2

fun main() {
    var year = 2014
    if (((year % 4 == 0) && ((year % 400 == 0) || (year % 100 !== 0)))) println("$year is a Leap year") else println("$year Not a leap year")
    year = 2012
    if (((year % 4 == 0) && ((year % 400 == 0) || (year % 100 !== 0)))) println("$year is a Leap year") else println("Not a leap year")

}