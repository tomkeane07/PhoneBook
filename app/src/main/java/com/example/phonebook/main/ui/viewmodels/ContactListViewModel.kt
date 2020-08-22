package com.example.phonebook.main.ui.viewmodels

import android.app.Application
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.phonebook.main.framework.model.Contact
import com.example.phonebook.main.framework.model.ContactHolder
import com.example.phonebook.main.framework.network.UserApi
import kotlinx.coroutines.runBlocking

class ContactListViewModel(
    app: Application,
    private val username: String,
    private val password: String
) : ViewModel() {

    val _contactList = MutableLiveData<List<Contact>>()
    val contactList: LiveData<List<Contact>>
        get() = _contactList

    init {
        getContacts()
    }

    @VisibleForTesting
    private fun getContacts() = runBlocking {
        val userContactsResponseObject =
            UserApi(username, password).retrofitService.getContactsAsync().await()
        Log.d(
            "getContactsStatus",
            userContactsResponseObject.message.toString()
        )
        _contactList.value =
            userContactsResponseObject.data?.contacts!!.getContacts()

        Log.d(
            "contactList",
            contactList.value.toString()
        )
    }

    fun List<ContactHolder>.getContacts(): List<Contact> {
        val contacts = ArrayList<Contact>()

        this.forEach() {
            contacts.add(it.contact!!)
        }
        return contacts
    }
}