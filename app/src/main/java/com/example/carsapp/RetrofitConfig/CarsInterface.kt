package com.example.carsapp.RetrofitConfig

import com.example.carsapp.modal.CarsModel
import retrofit2.Response
import retrofit2.http.GET

interface CarsInterface {
    @GET("api/vehicles/getallmanufacturers?format=json")
    suspend fun getCarsManufacList():Response<CarsModel>
}