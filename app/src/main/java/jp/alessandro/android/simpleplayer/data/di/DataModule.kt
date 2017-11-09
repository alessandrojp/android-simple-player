package jp.alessandro.android.simpleplayer.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import jp.alessandro.android.media.service.MediaController
import jp.alessandro.android.media.service.MediaState
import jp.alessandro.android.simpleplayer.data.player.remote.MediaControllerApi
import jp.alessandro.android.simpleplayer.data.player.remote.MediaControllerApiClient
import jp.alessandro.android.simpleplayer.data.player.remote.MediaStateApi
import jp.alessandro.android.simpleplayer.data.player.remote.MediaStateApiClient
import javax.inject.Singleton

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMediaControllerApi(controller: MediaController): MediaControllerApi {
        return MediaControllerApiClient(controller)
    }

    @Provides
    @Singleton
    fun provideMediaStateApi(state: MediaState): MediaStateApi {
        return MediaStateApiClient(state)
    }

    @Provides
    @Singleton
    fun provideMediaController(context: Context): MediaController {
        return MediaController(context)
    }

    @Provides
    @Singleton
    fun provideMediaState(context: Context): MediaState {
        return MediaState(context)
    }
}