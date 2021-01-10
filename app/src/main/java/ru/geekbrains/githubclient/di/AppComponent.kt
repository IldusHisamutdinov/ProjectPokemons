package ru.geekbrains.githubclient.di

import dagger.Component
import ru.geekbrains.githubclient.MainActivity
import ru.geekbrains.githubclient.di.module.*
import ru.geekbrains.githubclient.di.repository.RepositorySubcomponent
import ru.geekbrains.githubclient.di.user.UsersSubcomponent
import ru.geekbrains.githubclient.mvp.presenters.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ApiModule::class,
            AppModule::class,
            CacheModule::class,
            CiceroneModule::class,
            ImageModule::class
        ]
)
interface AppComponent {
    fun userSubcomponent(): UsersSubcomponent
    fun repositorySubcomponent(): RepositorySubcomponent

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
}