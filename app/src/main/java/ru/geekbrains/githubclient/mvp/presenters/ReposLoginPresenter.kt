package ru.geekbrains.githubclient.mvp.presenters

import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.mvp.model.repo.IGithubRepositoriesRepo
import ru.geekbrains.githubclient.mvp.model.repo.IGithubUsersRepo
import ru.geekbrains.githubclient.mvp.view.ReposLoginView
import ru.geekbrains.githubclient.mvp.view.list.LoginItemView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class ReposLoginPresenter : MvpPresenter<ReposLoginView>() {
    @Inject
    lateinit var mainThreadScheduler: Scheduler
    @Inject
    lateinit var userRepo: IGithubRepositoriesRepo
    @Inject
    lateinit var router: Router

    var repos:ReposGithubUser? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repos?.let { viewState.init(it) }
        loadPokemon()
    }

    fun loadPokemon() {
        userRepo.getRepositories(repos?.img.toString())
                .observeOn(mainThreadScheduler)
                .subscribe({
                    viewState.init(it)
                    it.img?.let {
                        viewState.loadImage(it)
                    }
                },{error->
                    viewState.showError(error)
                })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        viewState.release()
    }
}