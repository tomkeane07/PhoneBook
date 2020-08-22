package com.example.phonebook.main.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.phonebook.R
import com.example.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun setupNavigation() {
        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, binding.drawerLayout)
    }

/*    private fun getCredentials(savedInstanceState: Bundle?):  {
        val newString: String?
        newString = if (savedInstanceState == null) {
            val extras = intent.extras
            extras?.getString("STRING_I_NEED")
        } else {
            savedInstanceState.getSerializable("STRING_I_NEED") as String?
        }
    }*/
}