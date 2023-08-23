package com.example.carapp.viewmodal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carapp.RetrofitConfig.CarsInterface
import com.example.carapp.RetrofitConfig.QuotesInterface
import com.example.carapp.modal.Data
import com.example.carapp.modal.Quotesmodel
import com.example.carapp.utils.CarRetrofit
import com.example.carapp.utils.QuotesRetrofit
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