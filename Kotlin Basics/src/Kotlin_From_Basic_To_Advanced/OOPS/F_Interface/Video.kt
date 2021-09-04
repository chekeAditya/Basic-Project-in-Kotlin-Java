package Kotlin_From_Basic_To_Advanced.OOPS.F_Interface

class Video(private val name: String) : Downloader() {

    override fun download(){
        println("Downloading Video $name")
    }

}