package com.example.dummycontact.network

import com.example.dummycontact.models.UserModel
import retrofit2.http.GET

interface UserAPI {

    @GET("users")
    suspend fun getAllUsers():UserModel
}