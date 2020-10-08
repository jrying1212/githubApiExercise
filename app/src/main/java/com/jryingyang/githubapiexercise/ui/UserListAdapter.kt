package com.jryingyang.githubapiexercise.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.githubapiexercise.model.User
import com.jryingyang.githubapiexercise.ui.RecyclerViewHolder
import com.jryingyang.githubapiexercise.ui.UserItemClickListener

class UserListAdapter(private val data: List<User>, private val listener: UserItemClickListener) :
    RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val item = data[position]
        holder.itemView.setOnClickListener {
            listener.onUserItemClick(item)
        }
        holder.bind(item, listener)
    }
}