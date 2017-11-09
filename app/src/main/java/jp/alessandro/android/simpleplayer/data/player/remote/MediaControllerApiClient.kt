package jp.alessandro.android.simpleplayer.data.player.remote

import android.os.Bundle
import io.reactivex.Completable
import jp.alessandro.android.media.service.MediaController

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
class MediaControllerApiClient constructor(private val controller: MediaController) : MediaControllerApi {

    override fun updateNotification(metadata: Bundle): Completable {
        return controller.updateNotification(metadata)
    }

    override fun prepare(trackInfo: Bundle): Completable {
        return controller.prepare(trackInfo)
    }

    override fun play(): Completable {
        return controller.play()
    }

    override fun pause(): Completable {
        return controller.pause()
    }

    override fun stop(): Completable {
        return controller.stop()
    }
}