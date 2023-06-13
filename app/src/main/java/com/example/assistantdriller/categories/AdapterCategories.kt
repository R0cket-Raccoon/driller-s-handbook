package com.example.assistantdriller.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assistantdriller.R
import com.example.assistantdriller.databinding.FragmentTackMechanismBinding
import com.example.assistantdriller.databinding.ItemCategoriesBinding

class AdapterCategories (
    private var categoriesData: List<CategoriesData>,
    val click:onClick,

        ):RecyclerView.Adapter<AdapterCategories.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding =ItemCategoriesBinding.bind(itemView)
        fun bind(categoriesData:CategoriesData,click: onClick){
            binding.apply {
                imageCategories.setImageResource(categoriesData.categoriesImage)
                textCategories.setText(categoriesData.categoriesString)
                buttonCategories.setOnClickListener{click.click(categoriesData)}
            }
        }
    }

    override fun getItemCount(): Int {
        return categoriesData.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(categoriesData[position],click)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout=LayoutInflater.from(parent.context).inflate(
            R.layout.item_categories,parent,false
        )
        return AdapterCategories.ItemViewHolder(adapterLayout)
    }
    interface onClick {
        fun click(categoriesData: CategoriesData)
    }
}