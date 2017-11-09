package jp.alessandro.android.media.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.processors.BehaviorProcessor
import io.reactivex.subjects.PublishSubject
import jp.alessandro.android.media.IMediaService
import jp.alessandro.android.media.IMediaServiceListener
import timber.log.Timber

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
internal class MediaServiceGetter private constructor(context: Context) {

    companion object {

        private var instance: MediaServiceGetter? = null

        @Synchronized
        fun get(context: Context): MediaServiceGetter {
            if (instance == null) {
                instance = MediaServiceGetter(context)
            }
            return instance!!
        }
    }

    private var serviceSubject: BehaviorProcessor<IMediaService?> = BehaviorProcessor.create()
    private var playbackStateSubject: BehaviorProcessor<Int> = BehaviorProcessor.create()
    private var playbackEndedSubject: PublishSubject<Unit> = PublishSubject.create()
    private var playbackErrorSubject: PublishSubject<Bundle> = PublishSubject.create()

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            serviceSubject.onComplete()
            serviceSubject = BehaviorProcessor.create()
        }

        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            val service = IMediaService.Stub.asInterface(binder)
            service?.let { service ->
                service.addPlaybackListener(playbackListener)
            }
            serviceSubject.onNext(service)
        }
    }

    fun prepare(trackInfo: Bundle): Completable {
        Timber.d("prepare was called!!")
        return Completable.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    it.prepare(trackInfo)
                }
                emitter.onComplete()
            }
        }
    }

    fun play(): Completable {
        Timber.d("play was called!!")
        return Completable.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    it.play()
                }
                emitter.onComplete()
            }
        }
    }

    fun pause(): Completable {
        Timber.d("pause was called!!")
        return Completable.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    it.pause()
                }
                emitter.onComplete()
            }
        }
    }

    fun stop(): Completable {
        Timber.d("stop was called!!")
        return Completable.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    it.stop()
                }
                emitter.onComplete()
            }
        }
    }

    fun updateNotification(metadata: Bundle): Completable {
        Timber.d("updateNotification was called!!")
        return Completable.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    it.updateNotification(metadata)
                }
                emitter.onComplete()
            }
        }
    }

    fun isLoading(): Single<Boolean> {
        Timber.d("isLoading was called!!")
        return Single.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    emitter.onSuccess(it.isLoading)
                } ?: emitter.onError(IllegalStateException())
            }
        }
    }

    fun isPaused(): Single<Boolean> {
        Timber.d("isPaused was called!!")
        return Single.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    emitter.onSuccess(it.isPaused)
                } ?: emitter.onError(IllegalStateException())
            }
        }
    }

    fun isStopped(): Single<Boolean> {
        Timber.d("isStopped was called!!")
        return Single.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    emitter.onSuccess(it.isStopped)
                } ?: emitter.onError(IllegalStateException())
            }
        }
    }

    fun isPlaying(): Single<Boolean> {
        Timber.d("isPlaying was called!!")
        return Single.create { emitter ->
            serviceSubject.subscribe { service ->
                service?.let {
                    emitter.onSuccess(it.isPlaying)
                } ?: emitter.onError(IllegalStateException())
            }
        }
    }

    fun getOnPlaybackStateChangedObserver(): Flowable<Int> {
        return playbackStateSubject.onBackpressureLatest()
    }

    fun getOnEndedObserver(): Observable<Unit> {
        return playbackEndedSubject
    }

    fun getOnPlaybackErrorObserver(): Observable<Bundle> {
        return playbackErrorSubject
    }

    private val playbackListener = object : IMediaServiceListener.Stub() {
        override fun onPlaybackStateChanged(state: Int) {
            Timber.d("onPlaybackStateChanged was called!!")
        }

        override fun onPlaybackEnded() {
            Timber.d("onPlaybackEnded was called!!")
            playbackEndedSubject.onNext(Unit)
        }

        override fun onPlaybackError(error: Bundle?) {
            Timber.d("onPlaybackError was called!!")
        }
    }

    init {
        val intent = Intent(context, MediaService::class.java)
        val bound = context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        Timber.d("Service bound: $bound")
    }
}