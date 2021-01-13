package ru.geekbrains.githubclient.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Pokemon(
        @Expose
        val id: Int? = null,
        @Expose
        val name: String? = "",
        @Expose
        val img: String? = "",
        @Expose
        val candy_count: String? = "",
        @Expose
        val height: String? = "",
        @Expose
        val weight:String? = ""
) : Parcelable
