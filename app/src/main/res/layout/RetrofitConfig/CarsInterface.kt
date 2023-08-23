package com.example.carapp.RetrofitConfig

import com.example.carapp.modal.CarsModel
import retrofit2.Response
import retrofit2.http.GET

interface CarsInterface {
    @GET("api/vehicles/getallmanufacturers?format=json")
    suspend fun getCarsManufacList():Response<CarsModel>
}