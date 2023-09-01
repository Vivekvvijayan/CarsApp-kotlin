package com.example.carsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.carsapp.view.ProfileScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carsFragment = CarsFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container,carsFragment,"list_fragment").commit()

        val profileBtn = findViewById<ImageView>(R.id.profileScreenBtn).setOnClickListener{
            val profileFragment = ProfileScreenFragment.newInstance()
            supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.container,profileFragment,"profile_fragment").commit()
        }

    }
}