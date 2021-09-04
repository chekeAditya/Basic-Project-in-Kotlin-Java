package Kotlin_From_Basic_To_Advanced.OOPS.B_ClassesAndOBject

import Kotlin_From_Basic_To_Advanced.OOPS.Box

fun main() {
    //Creating an object
    val box = Box() //this is the instance of the box, we can create as many instance as requires
    val box1 = Box()
    val box2 = Box()

    /**
     * kotlin is creating getter, and it is using getter's under the hood to fetch the property
     * we can also crate our own getter and setters
     */
    println("Height before changes: ${box.height}") //here we are using getter as we want the property
    box.height = 10 //here we are using setter as we are setting the property
    println("Height after changes : ${box.height}")

    println("Length: ${box.length}")
    println("Width: ${box.width}")

    box1.open()
    box1.fillContents()


    println("Volume : ")
    println("Volume is ${box.volume}")


    println("Setter Volume :")
    box1.boxName = "My Box"
    println("Name modified : ${box1.boxName}")
}
/**
 * o/p.
Height before changes: 5
Height after changes : 10
Length: 10
Width: 20
Box Opened
Box is filled
 */