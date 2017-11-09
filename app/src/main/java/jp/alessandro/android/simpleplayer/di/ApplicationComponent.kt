package jp.alessandro.android.simpleplayer.di

import dagger.Component
import jp.alessandro.android.simpleplayer.domain.di.DomainModule
import jp.alessandro.android.simpleplayer.model.di.ModelModule
import javax.inject.Singleton

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Singleton
@Component(
        modules = arrayOf(
                ApplicationModule::class,
                DomainModule::class,
                ModelModule::class
        )
)

interface ApplicationComponent : ApplicationModule.Provider,
        DomainModule.Provider,
        ModelModule.Provider {
}