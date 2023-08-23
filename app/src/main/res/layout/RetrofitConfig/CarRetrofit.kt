package com.example.carapp.utils

import com.example.carapp.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarRetrofit {

    fun getCarsInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_CARS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}