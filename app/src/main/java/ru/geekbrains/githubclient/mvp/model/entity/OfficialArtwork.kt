package ru.geekbrains.githubclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class OfficialArtwork(
        @Expose
        val front_default: String? = null
)
