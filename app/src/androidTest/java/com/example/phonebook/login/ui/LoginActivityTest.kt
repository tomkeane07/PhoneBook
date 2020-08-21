package com.example.phonebook.login.ui

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.TypeTextAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.phonebook.R
import com.example.phonebook.main.ui.mainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    /*
    * This test is just to help development & confirm navigation to new activity occurs upon login,
    * & ensure mainActivity is initialising correctly
    *
    *  APi_key will expire eventually, then test will fail
    * */
    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)
    val username = "5f396af9109070518efb43e0"
    val password = "/R/HAR9Qi5wR5rnrJBBXT3DZDqE6hWpKfdqnra5lHxc="

    @Before
    @Throws(Exception::class)
    fun setUp() {
        Intents.init()
    }

    @After
    @Throws(java.lang.Exception::class)
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun loginTest() {
        onView(withId(R.id.username))
            .perform(TypeTextAction(username))

        onView(withId(R.id.password))
            .perform(TypeTextAction(password))
            .perform(closeSoftKeyboard())
        Thread.sleep(250)

        onView(withId(R.id.login))
            .perform(click())

        activityRule.launchActivity(Intent())
        intended(hasComponent(mainActivity::class.java.getName()))
    }
}