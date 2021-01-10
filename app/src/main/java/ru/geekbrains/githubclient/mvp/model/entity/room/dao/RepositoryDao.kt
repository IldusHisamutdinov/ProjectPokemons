package ru.geekbrains.githubclient.mvp.model.entity.room.dao

import androidx.room.*
import ru.geekbrains.githubclient.mvp.model.entity.room.RoomGithubRepository

@Dao
interface RepositoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitHubUser: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: RoomGithubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(listUser: List<RoomGithubRepository>)

    @Update
    fun update(gitHubUser: RoomGithubRepository)

    @Update
    fun update(vararg gitHubUser: RoomGithubRepository)

    @Update
    fun update(listUser: List<RoomGithubRepository>)

    @Delete
    fun delete(gitHubUser: RoomGithubRepository)

    @Delete
    fun delete(vararg gitHubUser: RoomGithubRepository)

    @Delete
    fun delete(listUser: List<RoomGithubRepository>)

    @Query("SELECT * FROM RoomGithubRepository")
    fun getAllUsers(): List<RoomGithubRepository>

    @Query("SELECT * FROM RoomGithubRepository WHERE id = :userId")
    fun getByLogin(userId: String): RoomGithubRepository?
}