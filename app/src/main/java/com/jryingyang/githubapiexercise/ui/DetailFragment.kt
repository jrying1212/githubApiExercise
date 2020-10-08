package com.jryingyang.githubapiexercise.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.jryingyang.githubapiexercise.R
import com.jryingyang.githubapiexercise.api.GithubService
import com.jryingyang.githubapiexercise.data.GithubRepository
import com.jryingyang.githubapiexercise.databinding.FragmentUserDetailBinding

class DetailFragment : Fragment() {
    private lateinit var viewModel: UserViewModel
    private lateinit var viewDataBinding: FragmentUserDetailBinding

    private val args: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentUserDetailBinding.inflate(inflater)

        return viewDataBinding.root
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
            viewDataBinding.data = user
            Glide.with(viewDataBinding.detailAvatar.context)
                .load(user!!.avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewDataBinding.detailAvatar)
        }
    }
}