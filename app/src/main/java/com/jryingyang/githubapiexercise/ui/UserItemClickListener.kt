package com.jryingyang.githubapiexercise.ui

import com.jryingyang.githubapiexercise.model.User

interface UserItemClickListener {

    fun onUserItemClick(user: User)
}