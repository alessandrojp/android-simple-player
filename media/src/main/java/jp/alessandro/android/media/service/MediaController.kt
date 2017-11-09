package jp.alessandro.android.media.service

import android.content.Context
import android.os.Bundle
import io.reactivex.Completable

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/09.
 */
class MediaController constructor(context: Context) {

    private val service: MediaServiceGetter = MediaServiceGetter.get(context)

    fun updateNotification(metadata: Bundle): Completable {
        return service.updateNotification(metadata)
    }

    fun prepare(trackInfo: Bundle): Completable {
        return service.prepare(trackInfo)
    }

    fun play(): Completable {
        return service.play()
    }

    fun pause(): Completable {
        return service.pause()
    }

    fun stop(): Completable {
        return service.stop()
    }
}