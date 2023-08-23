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
import com.example.carsapp.RecyclerAdapter.TextAdapter
import com.example.carsapp.modal.Data
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class List_details : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var country_name: TextView
    lateinit var ids: TextView
    lateinit var manName: TextView
    lateinit var commonName: TextView
    lateinit var recycler_vehicleType: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflatedView = inflater.inflate(R.layout.fragment_list_details, container, false)
        val recieveData = arguments?.getParcelable<Data>("country")

        if (recieveData != null) {
            with(inflatedView) {
                country_name = findViewById(R.id.country_name)
                ids = findViewById(R.id.ids)
                commonName = findViewById(R.id.commonName)
                manName = findViewById(R.id.manName)

                recycler_vehicleType = findViewById(R.id.recycler_vehicleType)
                recycler_vehicleType.layoutManager = LinearLayoutManager(requireContext())
                recieveData?.let {
                    country_name.text = it.Country
                    ids.text = it.Mfr_ID.toString()
                    commonName.text = it.Mfr_CommonName
                    manName.text = it.Mfr_Name

                    it?.let {
                        var adapter = TextAdapter(it.VehicleTypes)
                        recycler_vehicleType.adapter = adapter
                    }
                }
            }
        }
        return inflatedView
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List_details().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}