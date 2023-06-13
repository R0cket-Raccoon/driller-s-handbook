package com.example.assistantdriller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistantdriller.categories.AdapterCategories
import com.example.assistantdriller.categories.Categories
import com.example.assistantdriller.databinding.FragmentCategoriesBinding
import com.example.assistantdriller.gnvp.AdapterGNVP
import com.example.assistantdriller.gnvp.GNVPCategories
import com.example.assistantdriller.gnvp.GNVPData
import com.example.assistantdriller.h2s.H2SCategories
import com.example.assistantdriller.pogloschenie.PogloschenieCategories
import com.example.assistantdriller.prixvat.PrihvatCategories

class FragmentCategories : Fragment(), AdapterGNVP.onClick {
    lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("number")?.let { fragmentSelection(it) }
        binding.recyclerCategories.layoutManager = LinearLayoutManager(this.context)
        binding.buttonPrihvat.setOnClickListener{
            val bundles = Bundle()
            bundles.putBoolean("meh", true)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerListOfCategories,
                FragmentTackMechanism.newInstance(bundles)).addToBackStack("MechanismБК").commit()
        }
        binding.buttonPrihvatOK.setOnClickListener{
            val bundles = Bundle()
            bundles.putBoolean("meh", false)
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerListOfCategories,
                FragmentTackMechanism.newInstance(bundles)).addToBackStack("MechanismОК").commit()
        }


    }

    companion object {
        @JvmStatic
        fun newInstance(args: Bundle?): FragmentCategories {
            val fragment = FragmentCategories()
            fragment.arguments = args
            return fragment
        }

    }

    override fun click(textView: TextView, gnvpData: GNVPData) {

        if (gnvpData.number) {
            textView.visibility = View.GONE
            gnvpData.number = false
        } else {
            textView.visibility = View.VISIBLE
            gnvpData.number = true
        }
    }

    private fun fragmentSelection(number: Int, ) {
        when (number) {
            0 -> {
                binding.imageCategories.setImageResource(R.drawable.gnvp)
                binding.textCategories.setText(R.string.GNVPText)
                binding.recyclerCategories.adapter =
                    AdapterGNVP(GNVPCategories().gnvpCategories(), this)
            }
            1 -> {
                binding.imageCategories.setImageResource(R.drawable.pogloschenie)
                binding.textCategories.setText(R.string.Pogloschenie)
                binding.recyclerCategories.adapter =
                    AdapterGNVP(PogloschenieCategories().pogloschenieCategories(), this)
            }
            2 -> {
                binding.imageCategories.setImageResource(R.drawable.prihvat)
                binding.textCategories.setText(R.string.PrihvatOpr)
                binding.recyclerCategories.adapter =
                    AdapterGNVP(PrihvatCategories().prihvatCategories(), this)
                binding.buttonPrihvat.visibility = View.VISIBLE
                binding.buttonPrihvatOK.visibility = View.VISIBLE
            }
            3 -> {
                binding.imageCategories.setImageResource(R.drawable.serovodorod)
                binding.textCategories.setText(R.string.H2S)
                binding.recyclerCategories.adapter =
                    AdapterGNVP(H2SCategories().h2sCategories(), this)
            }
        }
    }
}