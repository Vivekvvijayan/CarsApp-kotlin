package com.example.carsapp.retrofitConfig

import com.example.carsapp.constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    fun getCarsInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_CARS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getQuotesInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_QUOTES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}