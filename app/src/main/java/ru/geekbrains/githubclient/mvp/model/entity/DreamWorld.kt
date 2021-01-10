package ru.geekbrains.githubclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class DreamWorld(
        @Expose
        val front_default: String? = null,
        @Expose
        val front_female: Any? = null
)
