package com.example.carsapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.carsapp.R
import com.example.carsapp.modal.LoginRes
import com.example.carsapp.utils.setImage
import com.google.gson.Gson

class ProfileScreenFragment : Fragment() {

    lateinit var idTextView: TextView
    lateinit var usernameTextView: TextView
    lateinit var emailTextView: TextView
    lateinit var fullnameTextView: TextView
    lateinit var genderTextView: TextView
    lateinit var profileImageView: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflatedView = inflater.inflate(R.layout.fragment_profile_screen, container, false)
        with(inflatedView) {
            idTextView = findViewById(R.id.idTextView)
            usernameTextView = findViewById(R.id.usernameTextView)
            emailTextView = findViewById(R.id.emailTextView)
            fullnameTextView = findViewById(R.id.fullnameTextView)
            genderTextView = findViewById(R.id.genderTextView)
            profileImageView = findViewById(R.id.profileImage)
        }
        return inflatedView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var sharedPref = requireContext().getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val userData = sharedPref.getString("user_data", null)
        if (userData != null) {
            val finalUserData = Gson().fromJson(userData, LoginRes::class.java)
            finalUserData.apply {
                idTextView.text = id.toString()
                usernameTextView.text = username
                emailTextView.text = email
                fullnameTextView.text = firstName + " " + lastName
                genderTextView.text = gender
                profileImageView.setImage(image)

            }
        }
    }

    companion object {
        fun newInstance() = ProfileScreenFragment()
    }
}