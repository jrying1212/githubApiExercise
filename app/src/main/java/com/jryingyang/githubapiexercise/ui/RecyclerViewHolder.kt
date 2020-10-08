package com.jryingyang.githubapiexercise.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.githubapiexercise.databinding.UserItemBinding
import com.jryingyang.githubapiexercise.model.User

class RecyclerViewHolder(private val binding: UserItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: User, listener: UserItemClickListener) {
        binding.user = item
        binding.listener = listener
        binding.executePendingBindings()
    }


    companion object {
        fun create(parent: ViewGroup): RecyclerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = UserItemBinding.inflate(layoutInflater, parent, false)
            return RecyclerViewHolder(binding)
        }
    }
}
