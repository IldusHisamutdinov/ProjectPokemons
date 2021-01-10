package ru.geekbrains.githubclient.mvp.model.repo.retrofit

import android.os.Parcelable
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.githubclient.mvp.model.api.IDataSource
import ru.geekbrains.githubclient.mvp.model.cache.IReposUserCache
//import ru.geekbrains.githubclient.mvp.model.cache.IReposUserCache
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.mvp.model.network.INetworkStatus
import ru.geekbrains.githubclient.mvp.model.repo.IGithubRepositoriesRepo

class RetrofitGithubRepositoriesRepo(
        val api: IDataSource,
        val networkStatus: INetworkStatus,
        val cache: IReposUserCache
): IGithubRepositoriesRepo {

    override fun getRepositories(url: String) = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if(isOnline) {
                api.getRepositories(url)//.flatMap {
       //             cache.addReposUser(url)

 //           }
        } else {
  //          cache.getReposUser(url)
            api.getRepositories(url)
        }

    }.subscribeOn(Schedulers.io())

}