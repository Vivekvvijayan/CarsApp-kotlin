package com.example.carsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp.List_details
import com.example.carsapp.viewmodal.QuotesViewmodel
import com.example.carsapp.RecyclerAdapter.ListAdapter
import com.example.carsapp.modal.Data

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var viewmodel: QuotesViewmodel

/**
 * A simple [Fragment] subclass.
 * Use the [List.newInstance] factory method to
 * create an instance of this fragment.
 */
class List : Fragment(), ListAdapter.ItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var quoteText: TextView
    lateinit var refreshBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerview = view.findViewById<RecyclerView>(R.id.recylerLists)
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        viewmodel = ViewModelProvider(this).get(QuotesViewmodel::class.java)

        viewmodel.getRandomQuotes()
        viewmodel.getCarManufacureList()

//observer for quotes
        viewmodel.quotes.observe(viewLifecycleOwner) { result ->
            quoteText.text = "\"${result[0]}\""
        }

        refreshBtn.setOnClickListener {
            viewmodel.getRandomQuotes()
        }

        //observer for list

        viewmodel.manuList.observe(viewLifecycleOwner) { result ->

            var adapter = ListAdapter(result, this)
            recyclerview.adapter = adapter
        }

    }

    override fun onItemClick(clickedItem: Data) {
        // Here, you have access to the clickedItem

        val detailsFragment = List_details.newInstance("", "")

        var args = Bundle()
        args.putParcelable("manu_data",clickedItem)
        detailsFragment.arguments = args


        parentFragmentManager.beginTransaction()
            .replace(R.id.container, detailsFragment, "new").addToBackStack(null)
            .commit()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var inflater = inflater.inflate(R.layout.fragment_list, container, false)

        with(inflater) {
            quoteText = findViewById(R.id.quoteText)
            refreshBtn = findViewById(R.id.refreshBtn)
        }
        return inflater
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment List.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}