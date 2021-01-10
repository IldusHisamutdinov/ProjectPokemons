package ru.geekbrains.githubclient.mvp.model.cache.room

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.githubclient.mvp.model.cache.IReposUserCache
import ru.geekbrains.githubclient.mvp.model.entity.Pokemon
import ru.geekbrains.githubclient.mvp.model.entity.room.GithubDatabase
import ru.geekbrains.githubclient.mvp.model.entity.room.RoomGithubRepository

class RoomRepositoriesCache(val db: GithubDatabase) : IReposUserCache {
    override fun addReposUser(listRepos: List<Pokemon>) = Single.fromCallable {
        val roomRepos = listRepos.map {
            RoomGithubRepository(
                it.id ?: 0,
                it.name ?: "",
                it.candy_count?: "",
                it.height ?: "",
                it.weight ?: ""

            )
        }
        db.repositoryDao.insert(roomRepos)
        listRepos
    }

    override fun getReposUser(): Single<List<Pokemon>> = Single.fromCallable {
        db.repositoryDao.getAllUsers().map {
            Pokemon(
                it.id,
                it.name,
                it.candy_count,
                it.height,
                it.weight
            )
        }

    }
}
