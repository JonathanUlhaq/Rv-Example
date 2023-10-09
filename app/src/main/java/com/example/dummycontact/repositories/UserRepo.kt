package com.example.dummycontact.repositories

import com.example.dummycontact.models.UserModel
import com.example.dummycontact.network.UserAPI
import javax.inject.Inject

class UserRepo @Inject constructor(private val api:UserAPI) {
    suspend fun getAllData():UserModel = api.getAllUsers()
}