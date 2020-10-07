package com.jryingyang.githubapiexercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.jryingyang.githubapiexercise.api.GithubService
import com.jryingyang.githubapiexercise.data.GithubRepository

class DetailFragment : Fragment() {
    private lateinit var viewModel: UserViewModel

    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_user_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = args.data
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                GithubRepository(GithubService.create())
            )
        ).get(UserViewModel::class.java)

        val closeBtn: ImageView = view.findViewById(R.id.close_icon)
        closeBtn.setOnClickListener {
            val navController = findNavController()
            navController.popBackStack()
        }

        lifecycleScope.launchWhenCreated {
            val user = viewModel.getUserDetail(data!!)
            val avatar: ImageView = view.findViewById(R.id.detail_avatar)
            val login: TextView = view.findViewById(R.id.detail_login)
            val admin: TextView = view.findViewById(R.id.detail_admin)
            val bio: TextView = view.findViewById(R.id.bio)
            val name: TextView = view.findViewById(R.id.name)
            val location: TextView = view.findViewById(R.id.location)
            val link: TextView = view.findViewById(R.id.link)
            if (user != null) {
                login.text = user.login
                if (user.site_admin) {
                    admin.visibility = View.VISIBLE
                }
                bio.text = user.bio
                name.text = user.name
                location.text = user.location
                link.text = user.blog
                Glide.with(view).load(user.avatar_url).apply(RequestOptions.circleCropTransform())
                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(avatar)
            }
        }
    }
}