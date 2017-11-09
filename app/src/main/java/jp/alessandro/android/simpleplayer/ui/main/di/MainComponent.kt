package jp.alessandro.android.simpleplayer.ui.main.di

import dagger.Component
import jp.alessandro.android.simpleplayer.di.ApplicationComponent
import jp.alessandro.android.simpleplayer.ui.main.MainActivity

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(
                MainModule::class
        )
)

@MainScope
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}