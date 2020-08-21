package com.example.phonebook.main.framework.network

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before

import org.junit.Test

class UserApiTest {
    val username = "5f396af9109070518efb43e0"
    val apiKey = "/R/HAR9Qi5wR5rnrJBBXT3DZDqE6hWpKfdqnra5lHxc="

    @Before
    fun setUp() {

    }

    @After
    fun tearDown() {
    }

    @Test
    fun getUserContactsTest() {
        runBlocking {
            UserApi(username, apiKey).retrofitService.getContactsAsync().await()
        }
    }

}