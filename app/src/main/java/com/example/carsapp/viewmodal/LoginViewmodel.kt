package com.example.carsapp.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsapp.modal.LoginRequest
import com.example.carsapp.modal.LoginRes
import com.example.carsapp.retrofitConfig.LoginInterface
import com.example.carsapp.retrofitConfig.RetrofitHelper
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class LoginViewmodel : ViewModel() {

    var liveData = MutableLiveData<Boolean>()
    var responseBody = MutableLiveData<LoginRes>()
    val loginApi = RetrofitHelper().getLoginInstance().create(LoginInterface::class.java)
    fun validateInput(username: String, password: String): Boolean {
        return !(username.isEmpty() || password.isEmpty())
    }

    fun loginUser(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)
        viewModelScope.launch {
            try {
                var res = loginApi.getUsers(loginRequest)

                res?.let {
                    liveData.value = it.isSuccessful
                    responseBody.value = it.body()
                }
            } catch (e: Exception) {
                println(e.message)
            }
        }

    }

}