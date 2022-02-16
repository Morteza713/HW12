package com.example.movieapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment_container) }
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<ViewModelProfile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.FillData.observe(this,{
            viewModel.setFillData(it)
        })
        NavigationUI.setupActionBarWithNavController(this, navController )

        binding.bottomNavigationMain.menu.findItem(R.id.profileFragment).isChecked = true
        pageSelect()


    }
    private fun pageSelect(){
        binding.bottomNavigationMain?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    if (viewModel.FillData.value == true){
                        navController.navigate(R.id.homeFragment)
                    }else{
                        Toast.makeText(this, "Register Profile", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.comingSoonFragment -> {
                    if (viewModel.FillData.value == true){
                        navController.navigate(R.id.comingSoonFragment)
                    }else{
                        Toast.makeText(this, "Register Profile", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.favoriteFragment -> {
                    if (viewModel.FillData.value == true){
                        navController.navigate(R.id.favoriteFragment)
                    }else{
                        Toast.makeText(this, "Register Profile", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                }
            }
            true
        }
    }
    fun btnClick(view: View){
        Toast.makeText(this, "${view.id}", Toast.LENGTH_SHORT).show()
    }

}