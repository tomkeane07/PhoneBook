package com.example.phonebook.main.ui.fragments

import android.content.Intent
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.phonebook.login.ui.LoginActivity
import com.example.phonebook.main.ui.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import com.example.phonebook.main.ui.getCredentials
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactListFragmentTest {

    @get:Rule
    val loginActivityRule = ActivityTestRule(LoginActivity::class.java)

    @get:Rule
    val mainActivityRule = ActivityTestRule(MainActivity::class.java, false, false)
    lateinit var username: String
    lateinit var password: String
    lateinit var intent : Intent

    @Before
    @Throws(Exception::class)
    fun setUp() {
        username = loginActivityRule.activity.getCredentials().username
        password = loginActivityRule.activity.getCredentials().apiKey
        intent = Intent()
        intent.putExtra("username", username)
        intent.putExtra("password", password)
    }

    @After
    fun tearDown() {
        mainActivityRule.finishActivity()
        loginActivityRule.finishActivity()
    }

    @Test
    fun x() {
        runBlocking {
            mainActivityRule.launchActivity(intent)

        }
    }

}