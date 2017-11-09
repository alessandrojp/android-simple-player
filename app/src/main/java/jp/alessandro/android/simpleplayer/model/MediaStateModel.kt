package jp.alessandro.android.simpleplayer.model

import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import jp.alessandro.android.simpleplayer.data.player.remote.MediaStateApi
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Singleton
class MediaStateModel @Inject constructor(private val api: MediaStateApi) {

    fun isLoading(): Single<Boolean> {
        return api.isLoading()
    }

    fun isPaused(): Single<Boolean> {
        return api.isPaused()
    }

    fun isStopped(): Single<Boolean> {
        return api.isStopped()
    }

    fun isPlaying(): Single<Boolean> {
        return api.isPlaying()
    }

    fun getOnPlaybackStateChangedObserver(): Flowable<Int> {
        return api.getOnPlaybackStateChangedObserver()
    }

    fun getOnEndedObserver(): Observable<Unit> {
        return api.getOnEndedObserver()
    }

    fun getOnPlaybackErrorObserver(): Observable<Bundle> {
        return api.getOnPlaybackErrorObserver()
    }
}