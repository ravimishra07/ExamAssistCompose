package com.ravi.examassist.core

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.viewbinding.ViewBinding
import com.google.android.material.navigation.NavigationView
import com.ravi.examassist.R
import com.ravi.examassist.databinding.ActivityBaseBinding
import com.ravi.examassist.databinding.BaseLayoutBinding
import androidx.databinding.DataBindingUtil

import androidx.databinding.ViewDataBinding

open class BaseActivity<B:ViewDataBinding> : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityBaseBinding
    private lateinit var bindingBase: BaseLayoutBinding

    private lateinit var context: Context
    private var dataBinding: B? = null
    protected fun bindView(layoutId: Int) {
        dataBinding = DataBindingUtil.setContentView(this, layoutId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)

        bindingBase = BaseLayoutBinding.bind(binding.baseBinding.root)

        val view = binding.root
        context = this
        setContentView(view)
        init()
    }

    private fun init() {
        bindingBase.toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.white))
        setSupportActionBar(bindingBase.toolbar)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.root,
            bindingBase.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)


        bindingBase.bottomNavigationView.background = null
        bindingBase.bottomNavigationView.menu.getItem(3).isEnabled = false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.isChecked) {
            binding.root.closeDrawer(GravityCompat.START)
            return true
        }
        when (item.itemId) {
            R.id.navigation_home -> {
              Toast.makeText(this,"tapped",Toast.LENGTH_SHORT).show()
            }
            else -> binding.root.closeDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onBackPressed() {
        if (binding.root.isDrawerOpen(GravityCompat.START)) {
            binding.root.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    /*
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
    */
}