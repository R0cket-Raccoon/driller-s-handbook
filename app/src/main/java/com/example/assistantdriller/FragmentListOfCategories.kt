package com.example.assistantdriller

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistantdriller.categories.AdapterCategories
import com.example.assistantdriller.categories.Categories
import com.example.assistantdriller.categories.CategoriesData
import com.example.assistantdriller.databinding.FragmentListOfCategoriesBinding

class FragmentListOfCategories : Fragment(),AdapterCategories.onClick {
    lateinit var binding: FragmentListOfCategoriesBinding
    private val adapter = AdapterCategories(Categories().categories(),this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentListOfCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerCategories.adapter=adapter
        binding.recyclerCategories.layoutManager= LinearLayoutManager(this.context)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentListOfCategories()

    }
    override fun click(categoriesData: CategoriesData) {
        val bundles = Bundle()
        bundles.putInt("number", categoriesData.number)
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerListOfCategories,
            FragmentCategories.newInstance(bundles)).addToBackStack(null).commit()
    }


}

