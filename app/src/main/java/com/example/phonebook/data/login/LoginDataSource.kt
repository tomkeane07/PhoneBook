package com.example.phonebook.data.login

import com.example.phonebook.data.model.LoggedInUser
import com.example.phonebook.network.AuthApi
import com.example.phonebook.network.model.NetworkResponseObject
import kotlinx.coroutines.runBlocking
import java.io.IOException
import android.util.Log

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> = runBlocking {
        try {
            Log.d("IN LOGIN", "IN LOGIN")
            // TODO: handle loggedInUser authentication
            lateinit var authResponse: NetworkResponseObject

            Log.d("IN LOGIN", "RUNBLOCKING")
            authResponse = getAuthenticationResponse(username, password)
            Log.d("IN LOGIN", authResponse.message!!)

            Log.d("authentication", authResponse.status.toString())
            val displayName = authResponse.data?.user?.first_name +
                    " " + authResponse.data?.user?.last_name
            val user = LoggedInUser(
                authResponse.data?.user?.id!!,
                displayName
            )
            return@runBlocking Result.Success(user)
        } catch (e: Throwable) {
            Log.d("ERROR", e.toString())
            return@runBlocking Result.Error(IOException("Error logging in", e))
        }
    }

    suspend fun getAuthenticationResponse(
        username: String,
        password: String
    ): NetworkResponseObject {
        return AuthApi(username, password)
            .retrofitService.authenticateAsync(username).await()
    }

    fun logout() {
        // TODO: revoke authentication
    }
}