package com.example.phonebook.main.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactListViewModelFactory(
    private val application: Application,
    private val username: String,
    private val password: String
) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactListViewModel::class.java)) {
            return ContactListViewModel(
                application,
                username,
                password
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}