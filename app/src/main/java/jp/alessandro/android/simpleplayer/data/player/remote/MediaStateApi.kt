package jp.alessandro.android.simpleplayer.data.player.remote

import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
interface MediaStateApi {

    fun isLoading(): Single<Boolean>
    fun isPaused(): Single<Boolean>
    fun isStopped(): Single<Boolean>
    fun isPlaying(): Single<Boolean>
    fun getOnPlaybackStateChangedObserver(): Flowable<Int>
    fun getOnEndedObserver(): Observable<Unit>
    fun getOnPlaybackErrorObserver(): Observable<Bundle>
}