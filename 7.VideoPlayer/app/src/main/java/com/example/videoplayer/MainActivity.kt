package com.example.videoplayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val onLinerUri = Uri.parse("https://www.youtube.com/watch?v=fgqEyC19538&ab_channel=FilmSpotTrailer")
        val offlineUri = Uri.parse("android.")
        mediaController.setMediaPlayer()
    }
}