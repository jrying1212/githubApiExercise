package com.jryingyang.githubapiexercise

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.githubapiexercise.model.User

class UserListAdapter(private val data: List<User>) : RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}