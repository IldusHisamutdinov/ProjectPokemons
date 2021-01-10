package ru.geekbrains.githubclient.mvp.model.entity.room


import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.githubclient.mvp.model.entity.room.dao.RepositoryDao
import ru.geekbrains.githubclient.mvp.model.entity.room.dao.UserDao


@Database(entities = [RoomGithubUser::class, RoomGithubRepository::class],
        version = 1, exportSchema = false)
abstract class GithubDatabase : RoomDatabase() {
    abstract val userDao: UserDao
    abstract val repositoryDao: RepositoryDao

    companion object {
        const val DB_NAME = "database.db"
    }
}