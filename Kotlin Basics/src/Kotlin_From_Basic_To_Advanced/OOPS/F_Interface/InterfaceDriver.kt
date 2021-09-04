package Kotlin_From_Basic_To_Advanced.OOPS.F_Interface

fun main(){
    val audioDownloader: Downloader = Audio("Audio1.mp3")
    val videoDownloader: Downloader = Video("Video1.mkv")

    audioDownloader.download();
    audioDownloader.downloadInfo()

    videoDownloader.downloadInfo()
    videoDownloader.download()

}