package com.example.dummycontact.di

import com.example.dummycontact.network.UserAPI
import com.example.dummycontact.utils.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Module {

    @Singleton
    @Provides
    fun clientProvider() =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build()


    @Singleton
    @Provides
    fun retrofitProvider():UserAPI =
        Retrofit
            .Builder()
            .baseUrl(BaseUrl.BASE_URL)
            .client(clientProvider())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
}