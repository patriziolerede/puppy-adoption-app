package com.example.androiddevchallenge.catdetail

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

@Composable
fun Player() {
    val context = LocalContext.current as? Context ?: return

    var autoPlay = true
    var window = 0
    var position = 0L

    val player = remember {
        val player = SimpleExoPlayer.Builder(context)
            .build()

        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            context,
            Util.getUserAgent(context, context.packageName)
        )

        val source = ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(
                Uri.parse(
                   "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                 )
            )
        player.prepare(source)
        player.playWhenReady = autoPlay
        player.seekTo(window, position)
        player
    }

    fun updateState() {
        autoPlay = player.playWhenReady
        window = player.currentWindowIndex
        position = 0L.coerceAtLeast(player.contentPosition)
    }

    val playerView = remember {
         PlayerView(context)


    }


    AndroidView(
        factory = { playerView },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        playerView.player = player
    }
}