package com.example.phonebook

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.phonebook.login.ui.LoginActivity
import com.example.phonebook.main.mainActivity
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class maininActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(mainActivity::class.java)

}
