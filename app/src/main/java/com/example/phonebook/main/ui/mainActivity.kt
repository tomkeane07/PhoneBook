package com.example.phonebook.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.phonebook.R
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.phonebook.databinding.ActivityMainBinding

class mainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, binding.drawerLayout)
    }
}