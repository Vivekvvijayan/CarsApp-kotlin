package com.example.carsapp.retrofitConfig;
import com.example.carsapp.modal.LoginRequest
import com.example.carsapp.modal.LoginRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST;

interface LoginInterface {
    @POST("auth/login")
    suspend fun getUsers(@Body loginRequest: LoginRequest):Response<LoginRes>
}
