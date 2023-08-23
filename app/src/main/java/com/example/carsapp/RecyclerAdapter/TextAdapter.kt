package com.example.carsapp.RecyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carsapp.R
import com.example.carsapp.modal.VType
class TextAdapter(var typList:List<VType>):RecyclerView.Adapter<TextAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var vTypeText:TextView = itemView.findViewById(R.id.vTypeText)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.ViewHolder {
        var inflatedLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_text_view, parent, false)
        return ViewHolder(inflatedLayout)
    }
    override fun onBindViewHolder(holder: TextAdapter.ViewHolder, position: Int) {
        var vtypeText = typList[position]
       holder.vTypeText.text =vtypeText.Name
    }
    override fun getItemCount(): Int {
       return typList.size
    }
}