package com.example.carsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carsapp.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginFragment = LoginFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.login_container, loginFragment, "login_container").commit()
    }

}