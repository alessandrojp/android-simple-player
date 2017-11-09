package jp.alessandro.android.simpleplayer.ui.main

import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import jp.alessandro.android.simpleplayer.R
import jp.alessandro.android.simpleplayer.domain.media_controller.Play
import jp.alessandro.android.simpleplayer.domain.media_state.GetOnEndedObserver
import jp.alessandro.android.simpleplayer.domain.media_state.IsLoading
import jp.alessandro.android.simpleplayer.ui.InjectActivity
import jp.alessandro.android.simpleplayer.ui.main.di.DaggerMainComponent
import jp.alessandro.android.simpleplayer.ui.main.di.MainComponent
import jp.alessandro.android.simpleplayer.ui.main.di.MainModule
import timber.log.Timber
import javax.inject.Inject
import kotlin.properties.Delegates

class MainActivity : InjectActivity<MainComponent>() {

    @Inject
    lateinit var play: Play

    @Inject
    lateinit var isLoading: IsLoading

    @Inject
    lateinit var onEndedObserver: GetOnEndedObserver

    private var composite: CompositeDisposable by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("Process onCreate id: ${android.os.Process.myPid()}")
    }

    override fun buildComponent(): MainComponent {
        return DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                .mainModule(MainModule())
                .build()
    }

    override fun injectDependency(component: MainComponent) {
        component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        composite = CompositeDisposable()

        play.execute().subscribe {
            Timber.d("play FINISHED!!!")

            isLoading.execute().subscribe { isLoading ->
                Timber.d("isLoading: $isLoading FINISHED!!!")
            }.run { composite.add(this) }

        }.run { composite.add(this) }

        // Previous and Next actions will be done inside the Queue
        onEndedObserver.execute().subscribe {
            Timber.d("onEndedObserver was called.")
        }.run { composite.add(this) }
    }

    override fun onPause() {
        super.onPause()
        composite.clear()
    }
}
