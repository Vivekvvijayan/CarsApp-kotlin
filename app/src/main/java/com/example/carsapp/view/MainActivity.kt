package com.example.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.carapp.List_details
import com.example.carsapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        first fragment rendering

        var f1 = List.newInstance("","")
        supportFragmentManager.beginTransaction().replace(R.id.container,f1,"list_fragment").commit()


//        var f2 = List_details.newInstance("","")
//        supportFragmentManager.beginTransaction().replace(R.id.container,f2,"details_fragment").commit()



    }



}