package ru.geekbrains.githubclient.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrains.githubclient.GithubApplication
import ru.geekbrains.githubclient.mvp.model.api.IDataSource
import ru.geekbrains.githubclient.mvp.model.network.INetworkStatus
import ru.geekbrains.githubclient.ui.network.AndroidNetworkStatus
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = "https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/"

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .setLenient()
        .create()

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun networkStatus(): INetworkStatus =
        AndroidNetworkStatus(GithubApplication.instance.baseContext)

}