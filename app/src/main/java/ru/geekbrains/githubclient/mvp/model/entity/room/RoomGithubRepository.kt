package ru.geekbrains.githubclient.mvp.model.entity.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
        foreignKeys = [ForeignKey(
                entity = RoomGithubUser::class,
                parentColumns = ["id"],
                childColumns = ["id"],
                onDelete = ForeignKey.CASCADE
        )]
)

data class RoomGithubRepository(
        @PrimaryKey
        var id: Int,
        @ColumnInfo
        var name: String,
        @ColumnInfo
        var candy_count: String,
        @ColumnInfo
        var height: String,
        @ColumnInfo
        var weight: String
//        @ColumnInfo
//        var userId: String
)

