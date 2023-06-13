package com.example.assistantdriller.gnvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assistantdriller.R
import com.example.assistantdriller.databinding.ItemGnvpBinding

class AdapterGNVP(
    private var gnvpData: List<GNVPData>,
    val click: onClick
): RecyclerView.Adapter<AdapterGNVP.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding=ItemGnvpBinding.bind(itemView)
        fun bind(gnvpData: GNVPData, click: onClick){
            binding.apply {
                buttonGnvp.setText(gnvpData.buttonTextGNVP)
                textOfSubcategoriesGnvp.setText(gnvpData.textGNVP)
                buttonGnvp.setOnClickListener{ click.click(textOfSubcategoriesGnvp, gnvpData) }

            }
        }
    }

    override fun getItemCount(): Int {
        return gnvpData.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(gnvpData[position],click)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout= LayoutInflater.from(parent.context).inflate(
            R.layout.item_gnvp,parent,false
        )
        return AdapterGNVP.ItemViewHolder(adapterLayout)
    }
    interface onClick {
        fun click(textView: TextView,gnvpData: GNVPData){
        }
    }
}