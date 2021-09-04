package Kotlin_From_Basic_To_Advanced.OOPS.F_Interface

/**
 * Difference Between interface and abstract class
 * In an interface you can't have init block or constructor but for an abstract block you can have primary constructor as well as secondary constructor and you can have init blocks
 */

abstract class Downloader {

    init {
        println("Downloader Initiated")
    }

    fun downloadInfo(){
        println("Download V1")
    }

    abstract fun download()
}