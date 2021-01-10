package ru.geekbrains.githubclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class Other(
        @Expose
        val dream_word: DreamWorld? = null,
        @Expose
        val officialArtwork: OfficialArtwork? = null
)
