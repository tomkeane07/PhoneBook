package com.example.phonebook.main.framework.model

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

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
    val contacts: List<ContactHolder>?,
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
@Parcelize
data class Contact(
    val id: String? = "123",
    val first_name: String? = "Enda",
    val last_name: String? = "Henehan",
    val job_title: String? = "Plumber",
    val company_id: String? = "234",
    val company_name: String? = "EH Plumbing",
    val company_size: Int? = null,
    val owner_id: String? = null,
    val status: String? = null,
    val status_id: String? = null,
    val tags: List<String>? = null,
    val starred: Boolean? = null,
    val background: String? = null,
    val lead_source_id: String? = null,
    val pending_deal: Boolean? = null,
    val total_pendings: Int? = null,
    val total_deals_count: Int? = null,
    val photo_url: String? = "https://cdn-static.onepagecrm.com/photos/joe_bloggs.png",
    val custom_fields: @RawValue List<Any>? = null,
    val address_list: @RawValue List<Address_list>? = null,
    val google_contacts_data: @RawValue Any? = null,
    val letter: String? = null,
    val urls: @RawValue List<Url>? = null,
    val phones: @RawValue List<Phone>? = null,
    val emails: @RawValue List<Email>? = null,
    val sales_closed_for: @RawValue List<Any>? = null,
    val closed_sales: @RawValue List<Any>? = null,
    val created_at: String? = null,
    val modified_at: String? = null
) : Parcelable

@JsonClass(generateAdapter = true)
data class ContactHolder(
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