package com.example.phonebook.main.framework.network

import androidx.test.rule.ActivityTestRule
import com.example.phonebook.login.ui.LoginActivity
import com.example.phonebook.main.ui.getCredentials
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule

import org.junit.Test


class UserApiTest {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)
    lateinit var username: String
    lateinit var password: String

    @Before
    fun setUp() {
        username = activityRule.activity.getCredentials().username
        password = activityRule.activity.getCredentials().apiKey
    }

    @After
    fun tearDown() {
        activityRule.finishActivity()
    }

    @Test
    fun getUserContactsTest() {
        runBlocking {
            val response = UserApi(username, password).retrofitService.getContactsAsync(1).await()
            assertEquals(response.status, "ok")
        }
    }
}