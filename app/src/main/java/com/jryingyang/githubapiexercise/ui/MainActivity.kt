package com.jryingyang.githubapiexercise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jryingyang.githubapiexercise.R
import com.jryingyang.githubapiexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewDataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_main
            )

        setContentView(viewDataBinding.root)
        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = fragmentManager.fragments
        if (fragment.size == 0) {
            fragmentTransaction.add(
                R.id.fragment,
                MainFragment()
            )
            fragmentTransaction.commit()
        }
    }
}