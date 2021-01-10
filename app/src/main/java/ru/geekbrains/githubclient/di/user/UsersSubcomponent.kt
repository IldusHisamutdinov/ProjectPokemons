package ru.geekbrains.githubclient.di.user

import dagger.Subcomponent
import ru.geekbrains.githubclient.di.repository.RepositorySubcomponent
import ru.geekbrains.githubclient.di.user.module.UsersModule
import ru.geekbrains.githubclient.mvp.presenters.UsersPresenter
import ru.geekbrains.githubclient.ui.adapter.UsersRVAdapter

@UsersScope
@Subcomponent(
        modules = [
            UsersModule::class
        ]
)
interface UsersSubcomponent {
    fun repositorySubComponent(): RepositorySubcomponent?

    fun inject(usersPresenter: UsersPresenter)
    fun inject(usersRVAdapter: UsersRVAdapter)
}