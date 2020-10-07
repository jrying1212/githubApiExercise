package com.jryingyang.githubapiexercise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.jryingyang.githubapiexercise.model.User

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var avatar: ImageView = view.findViewById(R.id.avatar)
    private var login: TextView = view.findViewById(R.id.login)
    private var admin: TextView = view.findViewById(R.id.admin)

    fun bind(item: User, listener: UserItemClickListener) {
        login.text = item.login
        if (item.site_admin) {
            admin.visibility = View.VISIBLE
        }
        Glide.with(itemView).load(item.avatar_url).apply(RequestOptions.circleCropTransform())
            .diskCacheStrategy(DiskCacheStrategy.ALL).into(avatar)
    }


    companion object {
        fun create(parent: ViewGroup): RecyclerViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
            return RecyclerViewHolder(view)
        }
    }
}
