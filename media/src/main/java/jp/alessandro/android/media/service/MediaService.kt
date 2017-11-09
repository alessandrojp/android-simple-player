package jp.alessandro.android.media.service

import android.app.Service
import android.content.Intent
import android.os.Bundle
import android.os.IBinder
import jp.alessandro.android.media.IMediaService
import jp.alessandro.android.media.IMediaServiceListener
import jp.alessandro.android.media.player.Player
import timber.log.Timber

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
internal class MediaService : Service() {

    private var listener: IMediaServiceListener? = null
    private val player = Player()

    private val binder = object : IMediaService.Stub() {

        override fun addPlaybackListener(listener: IMediaServiceListener?) {
            this@MediaService.listener = listener
        }

        override fun updateNotification(metadata: Bundle?) {
            Timber.d("updateNotification was called!!")
        }

        override fun prepare(trackInfo: Bundle?) {
            Timber.d("prepare was called!!")
        }

        override fun play() {
            Timber.d("play was called!!")
            listener?.let { it.onPlaybackEnded() }
        }

        override fun pause() {
            Timber.d("pause was called!!")
        }

        override fun stop() {
            Timber.d("stop was called!!")
        }

        override fun isLoading(): Boolean {
            Timber.d("isLoading was called!!")
            return false
        }

        override fun isPlaying(): Boolean {
            Timber.d("isPlaying was called!!")
            return false
        }

        override fun isPaused(): Boolean {
            Timber.d("isPaused was called!!")
            return false
        }

        override fun isStopped(): Boolean {
            Timber.d("isStopped was called!!")
            return false
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("MediaService#onCreate was called.")
        Timber.d("Process onCreate id: ${android.os.Process.myPid()}")

    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }
}