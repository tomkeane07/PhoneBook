package com.example.phonebook.main.ui.viewmodels

import android.app.Application
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

    var pageCounter = 2

    init {
        addContactsFromApitoList(1)
    }

    private fun addContactsFromApitoList(page: Int) = runBlocking {
        val userContactsResponseObject =
            UserApi(username, password).retrofitService
                .getContactsAsync(page).await()

        addContactToList(
            userContactsResponseObject.data?.contacts!!.getContacts()
        )
    }

    fun addContactToList(contacts: List<Contact>) {
        if (contactList.value.isNullOrEmpty())
            _contactList.value = contacts
        else
            _contactList.value = _contactList.value?.plus(contacts)
    }

    fun List<ContactHolder>.getContacts(): List<Contact> {
        val contacts = ArrayList<Contact>()
        this.forEach() {
            contacts.add(it.contact!!)
        }
        return contacts
    }

    fun onLoadMoreContactsClicked() {
        addContactsFromApitoList(pageCounter)
        //fortesting
        //for (id in 1..10) addfakeContactForTesting(id.toString())
        pageCounter++
    }

    //fortesting
    fun addfakeContactForTesting(id: String) {
        val currentList = contactList.value
        _contactList.value = currentList?.plus(Contact((id)))
    }
}