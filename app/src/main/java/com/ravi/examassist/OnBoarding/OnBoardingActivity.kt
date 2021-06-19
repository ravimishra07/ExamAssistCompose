package com.ravi.examassist.OnBoarding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ravi.examassist.databinding.ActivityOnBoardingBinding
import android.widget.TextView

import android.widget.LinearLayout

import androidx.viewpager.widget.ViewPager
import android.view.View

import android.view.ViewGroup

import android.view.LayoutInflater

import android.text.Html
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

import android.view.MenuInflater
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import androidx.recyclerview.widget.RecyclerView

import androidx.annotation.NonNull
import androidx.appcompat.widget.PopupMenu
import com.ravi.examassist.R
import com.ravi.examassist.OnBoarding.OnBoardingActivity.ViewsSliderAdapter





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

        addBottomDots(0)
    }
    private fun addBottomDots(currentPage: Int) {
     dots = ArrayList(3)
        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)
        binding.layoutDots.removeAllViews()
        for (i in 0 until dots.size) {
            dots[i] = TextView(this)
            dots[i].text = Html.fromHtml("&#8226;")
            dots[i].textSize = 35F
            dots[i].setTextColor(colorsInactive[currentPage])
            binding.layoutDots.addView(dots[i])
        }
        if (dots.size > 0) dots[currentPage].setTextColor(colorsActive[currentPage])
    }

    private fun getItem(i: Int): Int {
        return binding.onBoardingVP.currentItem + i
    }
    private fun launchHomeScreen() {
//        Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_LONG).show()
//        finish()
    }
    private fun showMenu(view: View) {
        val popup = PopupMenu(this, view)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.pager_transformer, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            if (item.itemId === R.id.action_orientation) {
                binding.onBoardingVP.orientation = ViewPager2.ORIENTATION_VERTICAL
            } else {
               // binding.onBoardingVP.setPageTransformer(Utils.getTransformer(item.getItemId()))
                binding.onBoardingVP.currentItem = 0
                binding.onBoardingVP.adapter?.notifyDataSetChanged()
            }
            false
        }
        popup.show()
    }

    private var pageChangeCallback: OnPageChangeCallback = object : OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            addBottomDots(position)

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


