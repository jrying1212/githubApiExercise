package com.jryingyang.githubapiexercise.data

import android.util.Log
import com.jryingyang.githubapiexercise.api.GithubService
import com.jryingyang.githubapiexercise.model.User
import retrofit2.HttpException
import java.io.IOException

class GithubRepository (private val githubService: GithubService) {

    companion object {
        private val TAG = GithubRepository::class.java.name
    }

    suspend fun requestUserList(): List<User> {
        return try {
            githubService.getUserList()
        } catch (e: IOException) {
            Log.e(TAG, e.toString())
            emptyList()
        } catch (e: HttpException) {
            Log.e(TAG, e.toString())
            emptyList()
        }
    }
}