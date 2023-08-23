package com.example.carapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        first fragment rendering

        var f1 = List.newInstance("","")
        supportFragmentManager.beginTransaction().replace(R.id.container,f1,"list_fragment").commit()



    }



}