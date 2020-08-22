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
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactDetailsFragmentTest {
    val contact = Contact()
    val contactFullName = contact.first_name + " " + contact.last_name
    lateinit var scenario: FragmentScenario<ContactDetailsFragment>

    @Before
    fun setUp() {
        DetailTestSetup(contact)
    }

    @Test
    fun q() {
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