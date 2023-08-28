package com.example.carsapp.viewmodal

import com.example.carsapp.retrofitConfig.QuotesInterface
import com.example.carsapp.retrofitConfig.CarsInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carsapp.modal.Data
import com.example.carsapp.retrofitConfig.RetrofitHelper
import kotlinx.coroutines.launch

class QuotesViewmodel : ViewModel() {
    var quotes = MutableLiveData<List<String>>()
    var carsDataList = MutableLiveData<List<Data>>()

    private var quoteAPI = RetrofitHelper().getQuotesInstance()
        .create(QuotesInterface::class.java) //api setup for quotes
    private var listAPI = RetrofitHelper().getCarsInstance().create(CarsInterface::class.java)

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
            carsDataList.value = res.body()?.Results
        }
    }
}