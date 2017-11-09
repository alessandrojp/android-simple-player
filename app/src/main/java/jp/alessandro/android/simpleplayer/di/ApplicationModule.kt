package jp.alessandro.android.simpleplayer.di

import android.content.Context
import dagger.Module
import dagger.Provides
import jp.alessandro.android.simpleplayer.App
import javax.inject.Singleton

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Module
class ApplicationModule(private val app: App) {

    interface Provider {
        fun app(): App
        fun applicationContext(): Context
    }

    @Provides
    fun provideApp(): App {
        return app
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return app.applicationContext
    }
}