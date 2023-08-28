package com.example.carsapp.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carsapp.R
import com.example.carsapp.modal.VType
class VehicleTypeAdapter(val typList:List<VType>):RecyclerView.Adapter<VehicleTypeAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val vehicleTypeTextView:TextView = itemView.findViewById(R.id.vTypeText)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleTypeAdapter.ViewHolder {
        val inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_text_view, parent, false)
        return ViewHolder(inflatedLayout)
    }
    override fun onBindViewHolder(holder: VehicleTypeAdapter.ViewHolder, position: Int) {
        val vtypeText = typList[position]
       holder.vehicleTypeTextView.text =vtypeText.Name
    }
    override fun getItemCount(): Int {
       return typList.size
    }
}