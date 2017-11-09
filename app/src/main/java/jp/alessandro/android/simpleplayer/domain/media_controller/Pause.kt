package jp.alessandro.android.simpleplayer.domain.media_controller

import io.reactivex.Completable
import jp.alessandro.android.simpleplayer.model.MediaControllerModel
import javax.inject.Inject

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
class Pause @Inject constructor(private val model: MediaControllerModel) {

    fun execute(): Completable {
        return model.pause()
    }
}