package com.example.phonebook.main.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.phonebook.R
import com.example.phonebook.main.framework.model.Contact

class ContactDetailsViewModel(
    app: Application,
    val contact: Contact
) : ViewModel() {

    val contactFullName = app.applicationContext.getString(
        R.string.contact_full_name,
        contact.first_name,
        contact.last_name
    )

}