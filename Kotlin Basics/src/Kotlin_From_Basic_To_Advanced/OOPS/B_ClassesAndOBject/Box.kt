package Kotlin_From_Basic_To_Advanced.OOPS

/**
 * property are defined using variable's and behaviours  are defined using functions
 * Use Capital letter for the starting
 */


class Box {

    //These are the property of the Box
    //here we define val so these are immutable
    val length: Int = 10
    val width: Int = 20
    var height: Int = 5


    /**
     * we won't write getter and setter unless it is absolutely necessary
     * below is the syntax of getter and setter syntax
    var x: Int = 0
    get() = 10
    set(value) {
    field = value  //field means we are assigning the past value to the field
    }

     * setter should be var as we are reassigning it later
     * getter should be val as we are not reassigning it later
     */
    val volume
        get() = length * width * height

    //this is the setter
    var boxName: String = "Box Name"
        set(value) {
            if (value.length < 3){
                println("Name cannot be less than 3 characters")
            }else{
                field = value
            }
        }


    //These are the behaviour of the box
    fun fillContents() {
        println("Box is filled")
    }

    fun open() {
        println("Box Opened")
    }

}