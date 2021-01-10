package ru.geekbrains.githubclient.mvp.model.entity

import com.google.gson.annotations.Expose

data class Sprites(
        @Expose
        var back_default: String?,
        @Expose
        var back_female: String?,
        @Expose
        var back_shiny: String?,
        @Expose
        var back_shiny_female: String?,
        @Expose
        var front_default: String?,
        @Expose
        var front_female: String?,
        @Expose
        var front_shiny: String?,
        @Expose
        var front_shiny_female: String?,
        @Expose
        var other: Other? = null
)
