package com.jryingyang.githubapiexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = fragmentManager.fragments
        if (fragment.size == 0) {
            fragmentTransaction.add(R.id.fragment, MainFragment())
            fragmentTransaction.commit()
        }
    }
}