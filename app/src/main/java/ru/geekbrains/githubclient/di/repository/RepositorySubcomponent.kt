package ru.geekbrains.githubclient.di.repository

import dagger.Subcomponent
import ru.geekbrains.githubclient.di.repository.module.RepositoryModule
import ru.geekbrains.githubclient.mvp.presenters.ReposLoginPresenter
import ru.geekbrains.githubclient.mvp.presenters.UsersPresenter

@RepositoryScope
@Subcomponent (
        modules = [
                RepositoryModule::class
        ]
        )
interface RepositorySubcomponent {

//   fun inject(loginPresenter: LoginPresenter)
    fun inject(reposLoginPresenter: ReposLoginPresenter)
 //   fun inject(usersPresenter: UsersPresenter)
}