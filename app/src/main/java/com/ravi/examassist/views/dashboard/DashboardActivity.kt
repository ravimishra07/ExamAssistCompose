package com.ravi.examassist.views.dashboard

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.ravi.examassist.R
import com.ravi.examassist.core.BaseActivity
import com.ravi.examassist.databinding.ActivityBaseBinding
import com.ravi.examassist.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_dashboard)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        context = this
        setContentView(view)
      //  layoutInflater.inflate(R.layout.activity_dashboard,bind)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(3).isEnabled = false
       // binding.bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod)

    }

}