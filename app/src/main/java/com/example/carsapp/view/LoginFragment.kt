package com.example.carsapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.carsapp.MainActivity
import com.example.carsapp.R
import com.example.carsapp.constants.Constants
import com.example.carsapp.viewmodal.LoginViewmodel
import com.example.carsapp.viewmodal.QuotesViewmodel
import com.example.carsapp.viewmodel
import com.google.gson.Gson

lateinit var loginViewmodel: LoginViewmodel

class LoginFragment : Fragment() {

    lateinit var usernameTextView: TextView
    lateinit var passwordTextView: TextView
    lateinit var loginBtn: Button
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewmodel = ViewModelProvider(this).get(LoginViewmodel::class.java)
        loginBtn.setOnClickListener {
            loginViewmodel.apply {
                val isValid = validateInput(
                    usernameTextView.text.toString(),
                    passwordTextView.text.toString()
                )
                if (!isValid) {
                    Toast.makeText(
                        requireContext(),
                        Constants.FIELD_BLANK_MESSAGE,
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    loginUser(
                        usernameTextView.text.toString(),
                        passwordTextView.text.toString()
                    )
                }
            }
        }

        loginViewmodel.liveData.observe(viewLifecycleOwner) { result ->
            if (result) {
                Toast.makeText(
                    requireContext(),
                    Constants.LOGIN_SUCCESS_MESSAGE,
                    Toast.LENGTH_SHORT
                ).show()
                var intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(requireContext(), Constants.LOGIN_FAIL_MESSAGE, Toast.LENGTH_SHORT)
                    .show()
            }
        }

        loginViewmodel.responseBody.observe(viewLifecycleOwner) { result ->
            sharedPref = requireContext().getSharedPreferences("myPref", Context.MODE_PRIVATE)
            try {
                val edit = sharedPref.edit()
                val userData = Gson().toJson(result)
                edit.putString("user_data", userData)
                edit.apply()
            } catch (e: Exception) {
                println(e.message)
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedView = inflater.inflate(R.layout.fragment_login, container, false)
        with(inflatedView) {
            usernameTextView = findViewById(R.id.usernameText)
            passwordTextView = findViewById(R.id.passwordText)
            loginBtn = findViewById(R.id.loginBtn)
        }

        return inflatedView
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoginFragment()

    }
}