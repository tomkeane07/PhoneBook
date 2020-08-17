package com.example.phonebook.network.model

import com.squareup.moshi.JsonClass

data class NetworkResponseObject(
    val status: Int?,
    val message: String? = "",
    val timestamp: Int?,
    val data: Data?,
    val error_name: String? = "",
    val error_message: String? = "",
    val errors: Errors?
)

@JsonClass(generateAdapter = true)
data class Data(val user: User?)

@JsonClass(generateAdapter = true)
data class User(
    val id: String? = "",
    val first_name: String? = "",
    val last_name: String? = "",
    val email: String? = "",
    val company_name: String? = "",
    val account_rights: List<String>?,
    val photo_url: String? = "",
    val country_code: String? = "",
    val account_role: String? = "",
    val bcc_email: String? = "",
    val google_contacts_email: String? = ""
)

data class Errors(val attribute_name: String? = "")