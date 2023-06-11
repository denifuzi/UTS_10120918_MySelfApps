package com.example.myselfapps.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myselfapps.MainActivity
import com.example.myselfapps.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val tlOnBoarding = findViewById<TabLayout>(R.id.tlOnBoarding)

        vpOnBoarding.apply {
            adapter = OnBoardingPagerAdapter(this@OnBoardingActivity)
            TabLayoutMediator(
                tlOnBoarding,
                this
            ) { tab, position ->
            }.attach()
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    initSetBtnNext()
                }
            })
        }

        initSetBtnNext()
        initSetOnClick()

    }

    private fun initSetBtnNext() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.text =
            if (vpOnBoarding.currentItem == 2) resources.getString(R.string.start)
            else resources.getString(R.string.next)
    }

    private fun initSetOnClick() {
        val vpOnBoarding = findViewById<ViewPager2>(R.id.vpOnBoarding)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            if (vpOnBoarding.currentItem == 2) {
                startActivity(Intent(this, MainActivity::class.java))
            } else vpOnBoarding.setCurrentItem(
                vpOnBoarding.currentItem.plus(1),
                true
            )
            initSetBtnNext()
        }
    }

}