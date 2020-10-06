package com.jryingyang.githubapiexercise

import androidx.lifecycle.ViewModel
import com.jryingyang.githubapiexercise.data.GithubRepository
import com.jryingyang.githubapiexercise.model.User

class UserViewModel(private val repository: GithubRepository) : ViewModel() {

    suspend fun getUserList():List<User> {
        return repository.requestUserList()
    }
}