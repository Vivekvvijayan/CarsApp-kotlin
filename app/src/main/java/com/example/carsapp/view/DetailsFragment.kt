package com.example.carapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carsapp.R
import com.example.carsapp.RecyclerAdapter.VehicleTypeAdapter
import com.example.carsapp.modal.Data
class DetailsFragment : Fragment() {
    lateinit var countryTextView: TextView
    lateinit var idTextView: TextView
    lateinit var manNameTextView: TextView
    lateinit var comminNameTextView: TextView
    lateinit var recyclerVehicleType: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val inflatedView = inflater.inflate(R.layout.fragment_list_details, container, false)
        val recieveData = arguments?.getParcelable<Data>("country")
        with(inflatedView) {
            countryTextView = findViewById(R.id.country_name)
            idTextView = findViewById(R.id.ids)
            comminNameTextView = findViewById(R.id.commonName)
            manNameTextView = findViewById(R.id.manName)

            recyclerVehicleType = findViewById(R.id.recycler_vehicleType)
            recyclerVehicleType.layoutManager = LinearLayoutManager(requireContext())
            recieveData?.let {
                countryTextView.text = it.Country
                idTextView.text = it.Mfr_ID.toString()
                comminNameTextView.text = it.Mfr_CommonName
                manNameTextView.text = it.Mfr_Name

                it?.let {
                    var adapter = VehicleTypeAdapter(it.VehicleTypes)
                    recyclerVehicleType.adapter = adapter
                }
            }
        }

        return inflatedView
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }
}