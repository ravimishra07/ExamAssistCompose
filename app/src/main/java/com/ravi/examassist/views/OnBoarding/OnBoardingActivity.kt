package com.ravi.examassist.views.OnBoarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View

import android.view.ViewGroup

import android.view.LayoutInflater

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import androidx.recyclerview.widget.RecyclerView

import com.ravi.examassist.R

import com.ravi.examassist.animation.animationtypes.*
import com.ravi.examassist.databinding.ActivityOnBoardingBinding
import com.ravi.examassist.views.dashboard.DashboardActivity


class OnBoardingActivity : AppCompatActivity() {
    private lateinit var context: Context
    private var mAdapter: ViewsSliderAdapter? = null
    private lateinit var layouts: IntArray
    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        context = this
        setContentView(view)
        init()
    }

    private fun init() {

        layouts = intArrayOf(R.layout.onboarding_one, R.layout.onboarding_two, R.layout.onboarding_three)
        mAdapter = ViewsSliderAdapter()
        binding.onBoardingVP.adapter = mAdapter
        binding.onBoardingVP.registerOnPageChangeCallback(pageChangeCallback)
        binding.btnNext.setOnClickListener { _ ->
            val current: Int = getItem(+1)
            if (current < layouts.size) {
                binding.onBoardingVP.currentItem = current
            } else {
                launchHomeScreen()
            }
        }
        binding.wormDotsIndicator.setViewPager2(binding.onBoardingVP)
        binding.onBoardingVP.setPageTransformer(AntiClockSpinTransformation())
        binding.btnNext.setOnClickListener{startActivity(Intent(this, DashboardActivity::class.java))}
    }
/*
Shortlisted animations
CubeInScalingTransformation
CubeInDepthTransformation 2
CubeInRotationTransformation 3
DepthPageTransformer 4
FidgetSpinTransformation 7
AntiClockSpinTransformation 1
DepthTransformation 5
FanTransformation 6
 */

    private fun getItem(i: Int): Int {
        return binding.onBoardingVP.currentItem + i
    }
    private fun launchHomeScreen() {}

    private var pageChangeCallback: OnPageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
        }
    }


   inner class ViewsSliderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
            return SliderViewHolder(view)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}
        override fun getItemViewType(position: Int): Int {
            return layouts[position]
        }

        override fun getItemCount(): Int {
            return layouts.size
        }

        inner class SliderViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

        }
    }

}


