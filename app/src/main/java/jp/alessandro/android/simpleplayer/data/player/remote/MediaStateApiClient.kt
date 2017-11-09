package jp.alessandro.android.simpleplayer.data.player.remote

import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import jp.alessandro.android.media.service.MediaState

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
class MediaStateApiClient constructor(private val state: MediaState) : MediaStateApi {

    override fun isLoading(): Single<Boolean> {
        return state.isLoading()
    }

    override fun isPaused(): Single<Boolean> {
        return state.isPaused()
    }

    override fun isStopped(): Single<Boolean> {
        return state.isStopped()
    }

    override fun isPlaying(): Single<Boolean> {
        return state.isPlaying()
    }

    override fun getOnEndedObserver(): Observable<Unit> {
        return state.getOnEndedObserver()
    }

    override fun getOnPlaybackStateChangedObserver(): Flowable<Int> {
        return state.getOnPlaybackStateChangedObserver()
    }

    override fun getOnPlaybackErrorObserver(): Observable<Bundle> {
        return state.getOnPlaybackErrorObserver()
    }
}