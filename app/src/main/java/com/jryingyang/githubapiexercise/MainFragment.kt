package com.jryingyang.githubapiexercise

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jryingyang.githubapiexercise.api.GithubService
import com.jryingyang.githubapiexercise.data.GithubRepository
import com.jryingyang.githubapiexercise.model.User
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainFragment : Fragment(), UserItemClickListener {

    companion object {
        private val TAG = MainFragment::class.java.name
    }

    private lateinit var viewModel: UserViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated")

        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                GithubRepository(GithubService.create())
            )
        ).get(UserViewModel::class.java)

        recyclerView = view.findViewById(R.id.userList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        MainScope().launch {
            recyclerView.adapter = UserListAdapter(viewModel.getUserList(), this@MainFragment)
        }
    }

    override fun onUserItemClick(user: User) {
        val navController = findNavController()
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(user.login)
        navController.navigate(action)
    }
}