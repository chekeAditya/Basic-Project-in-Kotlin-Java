package Kotlin_From_Basic_To_Advanced.OOPS.F_Interface

/**
 * when we abstract class we need to call the constructor as abstract class have the constructor. If don't have any constructor
    then you have the default constructor.
 * But in case of interfere you don't have to write the parenthesis ()
 */

class Audio(private val name: String) : Downloader() {

    override fun download() {
        println("Downloading Audio $name")
    }
}