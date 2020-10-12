package com.example.runningtracker.ui

import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.runningtracker.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.example.runningtracker.R
import com.example.runningtracker.db.RunDAO
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigate(intent)
        setSupportActionBar(toolbar)
        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        navHostFragment.findNavController().addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.settingFragment,R.id.staticsFragment,R.id.runFragment->
                    bottomNavigationView.visibility= View.VISIBLE
                else->bottomNavigationView.visibility=View.GONE
            }

        }
        
    }

    override fun onNewIntent(intent: Intent?) {
        navigate(intent)
        super.onNewIntent(intent)
    }
    private fun navigate(intent: Intent?){
        if (intent?.action == ACTION_SHOW_TRACKING_FRAGMENT){
            navHostFragment.findNavController().navigate(R.id.global)
        }
        else
        {
            navHostFragment.findNavController().navigate(R.id.global1)
        }

    }
}