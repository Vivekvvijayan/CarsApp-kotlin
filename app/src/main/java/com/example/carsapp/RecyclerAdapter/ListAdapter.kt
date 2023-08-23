package com.example.carsapp.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.carsapp.R
import com.example.carsapp.modal.Data

class ListAdapter(var listItems: List<Data>,private val itemClickListener:ItemClickListener) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    interface ItemClickListener{

        fun onItemClick(clickedItem: Data)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName = itemView.findViewById<TextView>(R.id.countryName)
        var companyName = itemView.findViewById<TextView>(R.id.companyName)
        var listItem = itemView.findViewById<LinearLayout>(R.id.listItem)

        init {
            listItem.setOnClickListener {

                val clickedItem = listItems[adapterPosition]
                itemClickListener.onItemClick(clickedItem)
            }
        }


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        var inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_content_layout, parent, false)
        return ViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        var data = listItems[position]
        holder.countryName.text = data.Country
        holder.companyName.text = data.Mfr_CommonName

    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}

