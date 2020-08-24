package com.example.phonebook.main.ui.fragments

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.phonebook.R
import com.example.phonebook.main.framework.model.Contact
import com.example.phonebook.main.framework.model.Phone
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactDetailsFragmentTest {

    val contactFullName = contact.first_name + " " + contact.last_name
    lateinit var scenario: FragmentScenario<ContactDetailsFragment>

    @Before
    fun setUp() {
        DetailTestSetup(contact)
    }

    @Test
    fun detailsTest() {
        onView(withId(R.id.contact_name))
            .check(matches(withText(contactFullName)))
    }

    fun DetailTestSetup(contact: Contact) {
        val fragmentArgs = Bundle().apply {
            putAll(bundleOf("selectedContact" to contact))
        }
        runBlocking {
            scenario = launchFragmentInContainer<ContactDetailsFragment>(
                fragmentArgs
            )
        }

    }
}

val contact = Contact(
    first_name = "Enda",
    last_name = "Henehan",
    job_title = "plumber",
    company_name = "EH Plumbing Ltd",
    phones = listOf(
        Phone("work", "087123456"),
        Phone("mobile", "12345678")
    ),
    photo_url = "https://cdn-static.onepagecrm.com/photos/joe_bloggs.png"
)