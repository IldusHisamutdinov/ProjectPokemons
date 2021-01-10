package ru.geekbrains.githubclient.mvp.model.repo.retrofit



import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.githubclient.mvp.model.api.IDataSource
import ru.geekbrains.githubclient.mvp.model.cache.IGithubUsersCache
import ru.geekbrains.githubclient.mvp.model.entity.GithubUser
import ru.geekbrains.githubclient.mvp.model.network.INetworkStatus
import ru.geekbrains.githubclient.mvp.model.repo.IGithubUsersRepo

class RetrofitGithubUsersRepo(
         val api: IDataSource,
        val networkStatus: INetworkStatus,
         val cache: IGithubUsersCache
): IGithubUsersRepo {
    override fun getUsers(): Single<GithubUser> = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.loadUsers()
//                       .flatMap { users ->
//                        cache.addUsers(users)
//                    }
        } else {
 //          cache.getUsers()
            api.loadUsers()
        }
    }.subscribeOn(Schedulers.io())
}
