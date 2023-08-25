package com.example.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carsFragment = CarsFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container,carsFragment,"list_fragment").commit()

    }
}