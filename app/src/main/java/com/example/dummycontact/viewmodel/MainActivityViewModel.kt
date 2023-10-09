package com.example.dummycontact.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dummycontact.models.UserModel
import com.example.dummycontact.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repo:UserRepo):ViewModel(){
    val data by lazy { MutableLiveData<UserModel>() }

    fun getAllData() =
        viewModelScope.launch {
            try {
                val dataApi = repo.getAllData()
                data.value = dataApi
            } catch (e:Exception) {
                Log.d("Errornya adalah ",e.toString())
            }
        }
}