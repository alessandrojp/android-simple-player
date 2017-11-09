package jp.alessandro.android.simpleplayer.domain.media_state

import io.reactivex.Observable
import jp.alessandro.android.simpleplayer.model.MediaStateModel
import javax.inject.Inject

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
class GetOnEndedObserver @Inject constructor(private val model: MediaStateModel) {

    fun execute(): Observable<Unit> {
        return model.getOnEndedObserver()
    }
}