package jp.alessandro.android.media.service

import android.content.Context
import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/09.
 */
class MediaState constructor(context: Context) {

    private val service: MediaServiceGetter = MediaServiceGetter.get(context)

    fun isLoading(): Single<Boolean> {
        return service.isLoading()
    }

    fun isPaused(): Single<Boolean> {
        return service.isPaused()
    }

    fun isStopped(): Single<Boolean> {
        return service.isStopped()
    }

    fun isPlaying(): Single<Boolean> {
        return service.isPlaying()
    }

    fun getOnPlaybackStateChangedObserver(): Flowable<Int> {
        return service.getOnPlaybackStateChangedObserver()
    }

    fun getOnEndedObserver(): Observable<Unit> {
        return service.getOnEndedObserver()
    }

    fun getOnPlaybackErrorObserver(): Observable<Bundle> {
        return service.getOnPlaybackErrorObserver()
    }
}