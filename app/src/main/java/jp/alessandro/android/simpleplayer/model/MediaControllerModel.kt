package jp.alessandro.android.simpleplayer.model

import android.os.Bundle
import io.reactivex.Completable
import jp.alessandro.android.simpleplayer.data.player.remote.MediaControllerApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Singleton
class MediaControllerModel @Inject constructor(private val api: MediaControllerApi) {

    fun updateNotification(metadata: Bundle): Completable {
        return api.updateNotification(metadata)
    }

    fun prepare(trackInfo: Bundle): Completable {
        return api.prepare(trackInfo)
    }

    fun play(): Completable {
        return api.play()
    }

    fun pause(): Completable {
        return api.pause()
    }

    fun stop(): Completable {
        return api.stop()
    }
}