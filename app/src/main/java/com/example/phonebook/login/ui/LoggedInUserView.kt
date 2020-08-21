package com.example.phonebook.login.ui

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val displayName: String,
    val username: String,
    val password: String
)