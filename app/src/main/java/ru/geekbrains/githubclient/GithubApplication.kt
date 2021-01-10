package ru.geekbrains.githubclient

import android.app.Application
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import ru.geekbrains.githubclient.di.AppComponent
import ru.geekbrains.githubclient.di.DaggerAppComponent
import ru.geekbrains.githubclient.di.module.AppModule
import ru.geekbrains.githubclient.di.repository.RepositorySubcomponent
import ru.geekbrains.githubclient.di.user.UsersSubcomponent


class GithubApplication : Application() {
    companion object {
         lateinit var instance: GithubApplication
    }

    lateinit var appComponent: AppComponent

    var userSubcomponent: UsersSubcomponent? = null
        private set
    var repositorySubcomponent: RepositorySubcomponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        //      ApiHolder.api

    }

    @NonNull
    fun initUserSubcomponent() = appComponent.userSubcomponent().also {
        userSubcomponent = it
    }

    fun releaseUserSubcomponent() {
        userSubcomponent = null
    }

    @Nullable
    fun initRepositoriesSubcomponent() = userSubcomponent?.repositorySubComponent().also {
        repositorySubcomponent = it
    }



//    @Nullable
//    fun initRepositoriesSubcomponent(): RepositorySubcomponent? {
//        val repositorySubcomponent = if (userSubcomponent != null) userSubcomponent!!.repositorySubComponent() else null
//        this.repositorySubcomponent = repositorySubcomponent
//        return repositorySubcomponent
//    }

    fun releaseRepositorySubcomponent() {
        repositorySubcomponent = null
    }

}

