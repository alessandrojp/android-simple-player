package jp.alessandro.android.simpleplayer.model.di

import dagger.Module
import jp.alessandro.android.simpleplayer.data.di.DataModule
import jp.alessandro.android.simpleplayer.model.MediaControllerModel
import jp.alessandro.android.simpleplayer.model.MediaStateModel

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
@Module(
        includes = arrayOf(
                DataModule::class
        )
)
class ModelModule {

    interface Provider {

        fun mediaControllerModel(): MediaControllerModel
        fun mediaStateModel(): MediaStateModel
    }
}