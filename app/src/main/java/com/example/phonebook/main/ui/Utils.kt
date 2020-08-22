package com.example.phonebook.main.ui

import androidx.annotation.VisibleForTesting
import com.example.phonebook.login.ui.LoginActivity

@VisibleForTesting
fun LoginActivity.getCredentials(): Credentials {
    return Credentials(
        this.applicationContext.resources.getString(com.example.phonebook.R.string.testUsername),
        this.applicationContext.resources.getString(com.example.phonebook.R.string.testPassword)
    )
}

data class Credentials(
    val username: String,
    val apiKey: String
)

