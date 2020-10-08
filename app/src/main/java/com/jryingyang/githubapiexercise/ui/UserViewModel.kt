package com.jryingyang.githubapiexercise.ui

import androidx.lifecycle.ViewModel
import com.jryingyang.githubapiexercise.data.GithubRepository
import com.jryingyang.githubapiexercise.model.User
import com.jryingyang.githubapiexercise.model.UserDetail

class UserViewModel(private val repository: GithubRepository) : ViewModel() {

    suspend fun getUserList():List<User> {
        return repository.requestUserList()
    }

    suspend fun getUserDetail(name: String): UserDetail? {
        return repository.requestUserDetail(name)
    }
}