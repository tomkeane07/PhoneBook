package com.example.phonebook.login.data

import com.example.phonebook.login.data.model.LoggedInUser
import com.example.phonebook.login.network.AuthApi
import com.example.phonebook.login.network.model.UserAuthenticationResponseObject
import kotlinx.coroutines.runBlocking
import java.io.IOException
import android.util.Log

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, apiKey: String): Result<LoggedInUser> = runBlocking {
        try {
            lateinit var authResponse: UserAuthenticationResponseObject

            authResponse = getAuthenticationResponse(username, apiKey)
            Log.d("IN LOGIN", authResponse.message!!)

            Log.d("authentication", authResponse.status.toString())
            val displayName = authResponse.data?.user?.first_name +
                    " " + authResponse.data?.user?.last_name
            val user = LoggedInUser(
                authResponse.data?.user?.id!!,
                displayName
            )
            return@runBlocking Result.Success(
                user
            )
        } catch (e: Throwable) {
            Log.d("ERROR", e.toString())
            return@runBlocking Result.Error(
                IOException("Error logging in", e)
            )
        }
    }

    suspend fun getAuthenticationResponse(
        username: String,
        password: String
    ): UserAuthenticationResponseObject {
        return AuthApi(username, password)
            .retrofitService.authenticateAsync(username).await()
    }

    fun logout() {
        // TODO: revoke authentication
    }
}