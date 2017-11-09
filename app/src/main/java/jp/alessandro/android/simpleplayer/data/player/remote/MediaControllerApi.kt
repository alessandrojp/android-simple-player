package jp.alessandro.android.simpleplayer.data.player.remote

import android.os.Bundle
import io.reactivex.Completable

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
interface MediaControllerApi {

    fun updateNotification(metadata: Bundle): Completable
    fun prepare(trackInfo: Bundle): Completable
    fun play(): Completable
    fun pause(): Completable
    fun stop(): Completable
}