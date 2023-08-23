package com.example.carsapp.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsapp.RetrofitConfig.CarsInterface
import com.example.carsapp.RetrofitConfig.QuotesInterface
import com.example.carsapp.modal.Data
import com.example.carsapp.modal.Quotesmodel
import com.example.carsapp.utils.CarRetrofit
import com.example.carsapp.utils.QuotesRetrofit
import kotlinx.coroutines.launch

class QuotesViewmodel : ViewModel() {

    var quotes = MutableLiveData<List<String>>()
    var manuList = MutableLiveData<List<Data>>()

    var quoteAPI = QuotesRetrofit().getQuotesInstance()
        .create(QuotesInterface::class.java) //api setup for quotes
    var listAPI = CarRetrofit().getCarsInstance().create(CarsInterface::class.java)

//    get random quotes

    fun getRandomQuotes() {
//        logic to call api

        viewModelScope.launch {

            var res = quoteAPI.generateRandomQuote()

            quotes.value = res.body()

        }
    }

    //get manufacures list

    fun getCarManufacureList() {
        viewModelScope.launch {
            var res = listAPI.getCarsManufacList()
            manuList.value = res.body()?.Results
        }
    }


}