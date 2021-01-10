package ru.geekbrains.githubclient.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReposGithubUser(
        @Expose
        val id: String? = "",
        @Expose
        val name: String? = "",
        @Expose
        val img: String? = "",
        @Expose
        val candy_count: String? = "",
        @Expose
        val height: String? = "",
//        @Expose
//        val isDefault: Boolean? = null,
        @Expose
        val order: Int? = null,
        @Expose
        val weight:String? = ""


) : Parcelable

