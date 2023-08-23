package com.example.carsapp.utils

import com.example.carsapp.Constants.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuotesRetrofit {

    fun getQuotesInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL_QUOTES).addConverterFactory(
            GsonConverterFactory.create()
        ).build()
    }

}