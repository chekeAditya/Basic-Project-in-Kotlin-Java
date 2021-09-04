package Kotlin_From_Basic_To_Advanced.OOPS.F_Interface

abstract class Player {
    init {
        println("Player Initiated")
    }

    fun downloadInfo(){
        println("Player V1")
    }

    abstract fun download()
}