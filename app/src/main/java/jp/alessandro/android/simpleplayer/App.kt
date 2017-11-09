package jp.alessandro.android.simpleplayer

import android.app.Application
import jp.alessandro.android.simpleplayer.di.ApplicationComponent
import jp.alessandro.android.simpleplayer.di.ApplicationModule
import jp.alessandro.android.simpleplayer.di.DaggerApplicationComponent
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
class App : Application() {

    var applicationComponent: ApplicationComponent by Delegates.notNull<ApplicationComponent>()

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
        initInjector()
    }

    private fun initInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}