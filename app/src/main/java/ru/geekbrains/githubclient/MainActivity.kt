package ru.geekbrains.githubclient

import android.os.Bundle

import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.geekbrains.githubclient.mvp.presenters.MainPresenter
import ru.geekbrains.githubclient.mvp.view.MainView
import ru.geekbrains.githubclient.ui.BackButtonListener
import ru.terrakok.cicerone.NavigatorHolder

import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject


class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    private val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

    val presenter: MainPresenter by moxyPresenter {
        MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GithubApplication.instance.appComponent.inject(this)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}