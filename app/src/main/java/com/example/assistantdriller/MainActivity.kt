package com.example.assistantdriller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assistantdriller.categories.AdapterCategories
import com.example.assistantdriller.categories.Categories
import com.example.assistantdriller.categories.CategoriesData
import com.example.assistantdriller.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerListOfCategories, FragmentListOfCategories()).commit()
        binding.apply {
            navigationView.setNavigationItemSelectedListener {
                val bundles = Bundle()

                when(it.itemId){
                    R.id.GNVP_menu-> {
                        bundles.putInt("number", 0)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.containerListOfCategories,
                                FragmentCategories.newInstance(bundles)).addToBackStack(null)
                            .commit()

                    }
                    R.id.Pogloschenie_menu-> {
                        bundles.putInt("number", 1)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.containerListOfCategories,
                                FragmentCategories.newInstance(bundles)).addToBackStack(null)
                            .commit()
                    }
                    R.id.Prihvat_menu-> {
                        bundles.putInt("number", 2)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.containerListOfCategories,
                                FragmentCategories.newInstance(bundles)).addToBackStack(null)
                            .commit()
                    }
                    R.id.H2S_menu-> {
                        bundles.putInt("number", 3)
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.containerListOfCategories,
                                FragmentCategories.newInstance(bundles)).addToBackStack(null)
                            .commit()
                    }
                }

                drawer.closeDrawer(GravityCompat.START)
                true }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home) {
            binding.drawer.openDrawer(GravityCompat.START)
        }

            return true
    }
}




