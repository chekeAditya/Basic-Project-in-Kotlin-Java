package Kotlin_From_Basic_To_Advanced.OOPS.C_Constructor

import java.awt.Color

/**
 * we can't write any logic inside constructor
 * but we if you want to write any logic you can write it inside init block this is called just after the primary constructor
 */


//this is a primary constructor
class BoxConstructor constructor(
    val lengthConstructor: Int,
    val widthConstructor: Int,
    val heightConstructor: Int
) {

    init {
        //used to write the logic
        //called after the primary constructor
        println("Init Block Called")
    }


    //    this the secondary constructor and you had to pass the primary constructor inside secondary using this keyword
    constructor(color: String = "Red") : this(0, 0, 0) {//passing default value
        println("Secondary constructor called")
    }

//    instead of writing the default value in the secondary constructor you can also write it in primary constructor as well

    //you can call as many init block as you want
    init {


    }

    init {

    }

}