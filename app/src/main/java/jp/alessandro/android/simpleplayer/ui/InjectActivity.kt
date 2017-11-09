package jp.alessandro.android.simpleplayer.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import jp.alessandro.android.simpleplayer.App
import jp.alessandro.android.simpleplayer.di.ApplicationComponent

/**
 * Created by Alessandro Yuichi Okimoto on 2017/11/08.
 */
abstract class InjectActivity<C> : AppCompatActivity() {

    private val component: C by lazy {
        buildComponent()
    }

    protected abstract fun buildComponent(): C

    protected abstract fun injectDependency(component: C)

    fun getApplicationComponent(): ApplicationComponent {
        return (application as App).applicationComponent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependency(component)
    }
}