package com.example.phonebook.login.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.phonebook.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun loginTest() {
        onView(withId(R.id.username))
            .perform(TypeTextAction("5f396af9109070518efb43e0"))

        onView(withId(R.id.password))
            .perform(TypeTextAction("/R/HAR9Qi5wR5rnrJBBXT3DZDqE6hWpKfdqnra5lHxc="))
            .perform(closeSoftKeyboard())
        Thread.sleep(250)

        onView(withId(R.id.login))
            .perform(click())
    }
}