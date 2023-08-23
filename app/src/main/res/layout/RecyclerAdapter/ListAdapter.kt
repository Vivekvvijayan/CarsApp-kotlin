package com.example.carapp.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carapp.R
import com.example.carapp.modal.Data

class ListAdapter(var listItems: List<Data>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var countryName = itemView.findViewById<TextView>(R.id.countryName)
        var companyName = itemView.findViewById<TextView>(R.id.companyName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        var inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_content_layout, parent, false)
        return ViewHolder(inflatedLayout)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        var data = listItems[position]
        holder.countryName.text = data.Country
        holder.companyName.text = data.Mfr_Name
    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}