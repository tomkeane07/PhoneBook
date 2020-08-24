package com.example.phonebook.main.framework.network

import com.example.phonebook.main.framework.model.UserContactsResponseObject
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApiService {
    @GET("contacts")
    fun getContactsAsync(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int = 10,
        @Query("team") team: Boolean = false
    ): Deferred<UserContactsResponseObject>
}

class UserApi(username: String, password: String) {
    val retrofitService: UserApiService by lazy {
        initRetrofit(username, password).create(UserApiService::class.java)
    }
}

private fun initRetrofit(username: String, password: String): Retrofit {
    val BASE_URL = "https://app.onepagecrm.com/api/v3/"

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor(username, password))
        .addInterceptor(logger).build()

    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client)
        .baseUrl(BASE_URL)
        .build()
}

class BasicAuthInterceptor(user: String, password: String) : Interceptor {
    private val credentials: String

    init {
        this.credentials = Credentials.basic(user, password)
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("accept", "application/json")
            .header("Authorization", credentials).build()
        return chain.proceed(authenticatedRequest)
    }
}