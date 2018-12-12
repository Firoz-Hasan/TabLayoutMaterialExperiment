package com.fhd.firozhasan.tablayout_material_experiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_layout.addTab(tab_layout.newTab().setText("Tab Name onek boro"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab arekta o boro"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 3"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 4"))
        tab_layout.tabGravity = TabLayout.MODE_SCROLLABLE
        tab_layout.getTabAt(1)?.select()
        selectFragment(1)
        /*smoothScroller = object : LinearSmoothScroller(this@MainActivity) {
            override fun getVerticalSnapPreference(): Int {
                return LinearSmoothScroller.SNAP_TO_START
            }
        }*/
     /*   recyclerViewHori()
        first = true*/
        setUpTabs()
    }

    private fun setUpTabs() {
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("tabSelectedRe", "${tab?.position} and ")
                selectFragment(tab?.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("tabSelectedUn", "${tab?.position} and ")
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("tabSelected", "${tab?.position} and $")
                selectFragment(tab?.position)
            }

        })
    }
    private fun selectFragment(position: Int?) {
        when (position) {
            0 -> {
                fragment = FragmentOne()
                goToFragment(fragment)
            }
            1 -> {
                fragment = FragmentTwo()
                goToFragment(fragment)
            }
            2 -> {
                fragment = FragmentThree()
                goToFragment(fragment)
            }

            else -> goToFragment(fragment)
        }
    }
    private fun goToFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frag_container, fragment)
        ft.commit()
    }
}
