package com.jryingyang.githubapiexercise.api

import com.jryingyang.githubapiexercise.model.User
import com.jryingyang.githubapiexercise.model.UserDetail
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users")
    suspend fun getUserList(
    ): List<User>

    @GET("users/{userName}")
    suspend fun getUserDetail(
        @Path("userName") userName: String
    ): UserDetail

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): GithubService {
            val client = OkHttpClient.Builder()
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService::class.java)
        }
    }
}
