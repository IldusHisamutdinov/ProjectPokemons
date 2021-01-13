package ru.geekbrains.githubclient.mvp.presenters

import android.util.Log
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.mvp.model.repo.IGithubRepositoriesRepo
import ru.geekbrains.githubclient.mvp.model.repo.IGithubUsersRepo
import ru.geekbrains.githubclient.mvp.presenters.list.ILoginListPresenter
import ru.geekbrains.githubclient.mvp.view.UsersView
import ru.geekbrains.githubclient.mvp.view.list.LoginItemView
import ru.geekbrains.githubclient.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class UsersPresenter() : MvpPresenter<UsersView>() {
    @Inject
    lateinit var scheduler: Scheduler

//    @Inject
//    lateinit var userRepo: IGithubRepositoriesRepo
    @Inject
    lateinit var usersRepo: IGithubUsersRepo

    @Inject
    lateinit var router: Router

    inner class UsersListPresenter : ILoginListPresenter {

        val users = mutableListOf<ReposGithubUser>()

        override var itemClickListener: ((LoginItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: LoginItemView) {
            val user = users[view.pos]
            user.id?.let { view.id(it) }
            user.name?.let { view.setName(it)}
            user.img?.let { view.loadAvatar(it) }
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = {
  //          val user: GithubUser = usersListPresenter.users[it.pos]
            router.navigateTo(Screens.ReposScreen(usersListPresenter.users[it.pos]))
        }
    }

    private fun loadData() {
        usersRepo.getUsers()
                .observeOn(scheduler)
                .subscribe({ repos ->
                    usersListPresenter.users.clear()
                    repos.pokemon?.let { it ->
                        usersListPresenter.users.addAll(it) }
                    viewState.updateList()
                }, { error -> (Log.e("log", "Error: ${error}")) })
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



