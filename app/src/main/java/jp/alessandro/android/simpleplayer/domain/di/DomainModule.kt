package jp.alessandro.android.simpleplayer.domain.di

import dagger.Module
import jp.alessandro.android.simpleplayer.domain.media_controller.*
import jp.alessandro.android.simpleplayer.model.di.ModelModule

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Module(
        includes = arrayOf(
                ModelModule::class
        )
)
class DomainModule {

    interface Provider {

        fun updateNotification(): UpdateNotification
        fun prepare(): Prepare
        fun play(): Play
        fun pause(): Pause
        fun stop(): Stop
    }
}