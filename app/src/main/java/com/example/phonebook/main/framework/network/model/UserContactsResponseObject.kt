package com.example.phonebook.main.framework.network.model

import com.squareup.moshi.JsonClass

// result generated from /json

@JsonClass(generateAdapter = true)
data class UserContactsResponseObject(
    val status: Int?,
    val message: String?,
    val timestamp: Int?,
    val data: Data?,
    val lead_sources: List<Lead_sources>? = listOf(),
    val statuses: Any? = null,
    val tags: Any? = null,
    val contacts_count: Any? = null,
    val team_stream: Any? = null
)

@JsonClass(generateAdapter = true)
data class Data(
    val contacts: List<Contacts>?,
    val total_count: Int?,
    val page: Int?,
    val per_page: Int?,
    val max_page: Int?
)

@JsonClass(generateAdapter = true)
data class Address(
    val address: Any?,
    val city: Any?,
    val state: Any?,
    val zip_code: Any?,
    val country_code: Any?
)

@JsonClass(generateAdapter = true)
data class Address_list(
    val address: String?,
    val city: String?,
    val state: String?,
    val zip_code: String?,
    val country_code: String?,
    val type: String?
)

@JsonClass(generateAdapter = true)
data class Company(
    val id: String?,
    val name: String?,
    val description: String?,
    val phone: String?,
    val url: String?,
    val company_fields: List<Any>?,
    val syncing_status: Boolean?,
    val synced_status_id: Any?,
    val syncing_tags: Boolean?,
    val synced_tags: Any?,
    val address: Address?,
    val created_at: String?,
    val modified_at: String?,
    val contacts_count: Int?
)

@JsonClass(generateAdapter = true)
data class Contact(
    val id: String?,
    val first_name: String?,
    val last_name: String?,
    val job_title: String?,
    val company_id: String?,
    val company_name: String?,
    val company_size: Int?,
    val owner_id: String?,
    val status: String?,
    val status_id: String?,
    val tags: List<String>?,
    val starred: Boolean?,
    val background: String?,
    val lead_source_id: String?,
    val pending_deal: Boolean?,
    val total_pendings: Int?,
    val total_deals_count: Int?,
    val photo_url: String?,
    val custom_fields: List<Any>?,
    val address_list: List<Address_list>?,
    val google_contacts_data: Any?,
    val letter: String?,
    val urls: List<Url>?,
    val phones: List<Phone>?,
    val emails: List<Email>?,
    val sales_closed_for: List<Any>?,
    val closed_sales: List<Any>?,
    val created_at: String?,
    val modified_at: String?
)

@JsonClass(generateAdapter = true)
data class Contacts(
    val contact: Contact?,
    val next_actions: List<Next_action>? = null,
    val next_action: Next_action? = null,
    val queued_actions: List<Any>? = null,
    val next_action_conflicts: List<Any>? = null,
    val company: Company? = null
)

@JsonClass(generateAdapter = true)
data class Email(val type: String?, val value: String?)

@JsonClass(generateAdapter = true)
data class Next_action(
    val id: String?,
    val assignee_id: String?,
    val contact_id: String?,
    val text: String? = null,
    val status: String?,
    val done: Boolean?,
    val created_at: String?,
    val modified_at: String?,
    val date: String?
)

@JsonClass(generateAdapter = true)
data class Phone(val type: String?, val value: String?)

@JsonClass(generateAdapter = true)
data class Url(val type: String?, val value: String?)

@JsonClass(generateAdapter = true)
data class Lead_sources(
    val id: String? = null,
    val text: String? = null,
    val counts: Int? = null,
    val total_count: Int? = null,
    val action_stream_count: Int? = null,
    val team_counts: List<Team_counts>? = null
)

@JsonClass(generateAdapter = true)
data class Team_counts(val user_id: String?, val counts: Int?)