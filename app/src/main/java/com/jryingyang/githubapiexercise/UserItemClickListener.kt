package com.jryingyang.githubapiexercise

import com.jryingyang.githubapiexercise.model.User

interface UserItemClickListener {

    fun onUserItemClick(user: User)
}