package ru.geekbrains.githubclient.mvp.model.cache.room

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.githubclient.mvp.model.cache.IGithubUsersCache
import ru.geekbrains.githubclient.mvp.model.entity.GithubUser
import ru.geekbrains.githubclient.mvp.model.entity.ReposGithubUser
import ru.geekbrains.githubclient.mvp.model.entity.room.GithubDatabase
import ru.geekbrains.githubclient.mvp.model.entity.room.RoomGithubUser


class RoomGithubUsersCache(val db: GithubDatabase) : IGithubUsersCache {

    override fun addUsers(users: List<ReposGithubUser>) =
        Single.fromCallable {
            val roomUsers = users.map {
                RoomGithubUser(
                    it.id ?: "",
                    it.name ?: "",
                    it.img ?: ""

                )
            }
            db.userDao.insert(roomUsers)
            users
     }

    override fun getUsers() = Single.fromCallable { //: Single<ReposGithubUser>
        db.userDao.getAllUsers().map {
            ReposGithubUser(
                it.id,
                it.name,
                it.img


            )
        }
    }
}