package ru.geekbrains.githubclient.mvp.model.entity.room.dao

import androidx.room.*
import ru.geekbrains.githubclient.mvp.model.entity.room.RoomGithubRepository
import ru.geekbrains.githubclient.mvp.model.entity.room.RoomGithubUser

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: RoomGithubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: RoomGithubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(listUser: List<RoomGithubUser>)

    @Update
    fun update(gitHubUser: RoomGithubUser)

    @Update
    fun update(vararg gitHubUser: RoomGithubUser)

    @Update
    fun update(listUser: List<RoomGithubUser>)

    @Delete
    fun delete(gitHubUser: RoomGithubUser)

    @Delete
    fun delete(vararg gitHubUser: RoomGithubUser)

    @Delete
    fun delete(listUser: List<RoomGithubUser>)

    @Query("SELECT * FROM RoomGithubUser")
    fun getAllUsers():List<RoomGithubUser>

    @Query("SELECT * FROM RoomGithubUser WHERE id = :login LIMIT 2")
    fun getByLogin(login:String): RoomGithubUser?
}