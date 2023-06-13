package com.example.assistantdriller.mechanism

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assistantdriller.R
import com.example.assistantdriller.categories.CategoriesData
import com.example.assistantdriller.databinding.FragmentTackMechanismBinding
import com.example.assistantdriller.databinding.ItemMehanismBinding

class AdapterMechanism (
    private var mechanismData: List<MechanismData>,
    val result: Result,


): RecyclerView.Adapter<AdapterMechanism.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMehanismBinding.bind(itemView)

        fun bind(mechanismData: MechanismData, result: Result) {
            binding.apply {
                question.setText(mechanismData.Question)
                answerOne.setText(mechanismData.answer_1)
                answerTwo.setText(mechanismData.answer_2)
                answerThree.setText(mechanismData.answer_3)
                answerOne.setOnClickListener {
                    result.result(radioGroup.checkedRadioButtonId, mechanismData)
                }
                answerTwo.setOnClickListener {
                    result.result(radioGroup.checkedRadioButtonId,
                        mechanismData)
                }
                answerThree.setOnClickListener {
                    result.result(radioGroup.checkedRadioButtonId,
                        mechanismData)
                }

            }

        }

    }

    override fun getItemCount(): Int {
        return mechanismData.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mechanismData[position], result)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_mehanism, parent, false
        )
        return AdapterMechanism.ItemViewHolder(adapterLayout)
    }

    interface Result {
        fun result(id: Int, mechanismData: MechanismData)
    }
}
