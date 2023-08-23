package com.example.carsapp.RetrofitConfig

import com.example.carsapp.modal.Quotesmodel
import retrofit2.Response
import retrofit2.http.GET

interface QuotesInterface {

    @GET("/v2/quotes")
    suspend fun generateRandomQuote():Response<List<String>>
}