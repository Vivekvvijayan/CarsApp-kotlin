package com.example.carsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp.DetailsFragment
import com.example.carsapp.viewmodal.QuotesViewmodel
import com.example.carsapp.RecyclerAdapter.CarsAdapter
import com.example.carsapp.modal.Data

lateinit var viewmodel: QuotesViewmodel
class CarsFragment : Fragment(), CarsAdapter.ItemClickListener {

    lateinit var quoteTextView: TextView
    lateinit var refreshBtn: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var recyclerview = view.findViewById<RecyclerView>(R.id.recylerLists)
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        viewmodel = ViewModelProvider(this).get(QuotesViewmodel::class.java)

        viewmodel.apply {
            getRandomQuotes()
            getCarManufacureList()
        }
//observer for quotes
        viewmodel.quotes.observe(viewLifecycleOwner) { result ->
            quoteTextView.text = "\"${result[0]}\""
        }
        refreshBtn.setOnClickListener {
            viewmodel.getRandomQuotes()
        }
        //observer for list
        viewmodel.carsDataList.observe(viewLifecycleOwner) { result ->
            var adapter = CarsAdapter(result, this)
            recyclerview.adapter = adapter
        }
    }

    override fun onItemClick(clickedItem: Data) {
        // Here, you have access to the clickedItem
        val detailsFragment = DetailsFragment.newInstance()

        var args = Bundle()

        args.apply {
            putParcelable("country", clickedItem)
        }

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
        var inflatedView = inflater.inflate(R.layout.fragment_list, container, false)

        with(inflatedView) {
            quoteTextView = findViewById(R.id.quoteText)
            refreshBtn = findViewById(R.id.refreshBtn)
        }
        return inflatedView
    }

    companion object {
        fun newInstance() = CarsFragment()

    }
}