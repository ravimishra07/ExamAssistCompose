package com.ravi.examassist.OnBoarding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import android.view.View

import android.view.ViewGroup

import android.view.LayoutInflater

import androidx.viewpager2.widget.ViewPager2

import android.view.MenuInflater
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import androidx.recyclerview.widget.RecyclerView

import androidx.appcompat.widget.PopupMenu
import com.ravi.examassist.R
import android.R.attr.radius

import android.graphics.drawable.GradientDrawable
import android.widget.Button
import com.ravi.examassist.UtilsAnimations
import com.ravi.examassist.animation.animationtypes.*
import com.ravi.examassist.databinding.ActivityOnBoardingBinding


class OnBoardingActivity : AppCompatActivity() {
    private lateinit var context: Context
    private var mAdapter: ViewsSliderAdapter? = null
    private lateinit var dots: ArrayList<TextView>
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


            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.size - 1) {
                // last page. make button text to GOT IT
//                binding.btnNext.text = getString(R.string.start)
//                binding.btnSkip.setVisibility(View.GONE)
            } else {
                // still pages are left
//                binding.btnNext.text = getString(R.string.next)
//                binding.btnSkip.setVisibility(View.VISIBLE)
            }
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
            var title: TextView? = null
            var year: TextView? = null
            var genre: TextView? = null
        }
    }

}


