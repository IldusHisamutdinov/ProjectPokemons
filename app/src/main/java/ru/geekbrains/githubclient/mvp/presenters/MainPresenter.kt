package ru.geekbrains.githubclient.mvp.presenters

import moxy.MvpPresenter
import ru.geekbrains.githubclient.GithubApplication
import ru.geekbrains.githubclient.mvp.view.MainView
import ru.geekbrains.githubclient.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router
    init {
        GithubApplication.instance.appComponent.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen())
    }

    fun backClicked() {
        router.exit()
    }
}