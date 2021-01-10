package ru.geekbrains.githubclient.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.geekbrains.githubclient.GithubApplication

@Module
class AppModule(val app: GithubApplication) {

    @Provides
    fun app(): GithubApplication{
        return app
    }
    @Provides
    fun mainThreadSchedulers(): Scheduler{
        return AndroidSchedulers.mainThread()
    }
}