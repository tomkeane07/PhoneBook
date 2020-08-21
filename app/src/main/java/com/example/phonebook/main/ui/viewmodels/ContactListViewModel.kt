package com.example.phonebook.main.ui.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonebook.main.framework.network.UserApi
import com.example.phonebook.main.framework.network.model.Contact
import com.example.phonebook.main.framework.network.model.UserContactsResponseObject
import kotlinx.coroutines.runBlocking

class ContactListViewModel(
    app: Application,

) : ViewModel() {

    val _contactList = MutableLiveData<List<Contact>>()
    val movieList: LiveData<List<Contact>>
        get() = _contactList

    fun getContacts() = runBlocking {
        val userContactsResponseObject =
            UserApi()
    }
}