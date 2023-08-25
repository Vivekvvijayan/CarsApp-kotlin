package com.example.carsapp.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carsapp.R
import com.example.carsapp.modal.Data

class CarsAdapter(private val carsList: List<Data>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {


    interface ItemClickListener {
        fun onItemClick(clickedItem: Data)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryTextView: TextView
        val companyTextView: TextView
        val CarsListItem: LinearLayout

        init {
            itemView.apply {
                countryTextView = findViewById<TextView>(R.id.countryName)
                companyTextView = findViewById<TextView>(R.id.companyName)
                CarsListItem = findViewById<LinearLayout>(R.id.listItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsAdapter.ViewHolder {
        val inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_content_layout, parent, false)
        return ViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: CarsAdapter.ViewHolder, position: Int) {
        val data = carsList[position]
        holder.apply {
            data.apply {
                countryTextView.text = Country
                companyTextView.text = Mfr_CommonName
            }
            CarsListItem.setOnClickListener {
                val clickedItem = carsList[position]
                itemClickListener.onItemClick(clickedItem)
            }
        }

    }

    override fun getItemCount() = carsList.size


}

