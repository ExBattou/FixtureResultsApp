package net.adriann.fixtureresultsapp.UI.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import net.adriann.fixtureresultsapp.Adapter.fragmentAdapter
import net.adriann.fixtureresultsapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapterFragments = fragmentAdapter( supportFragmentManager)
        viewPager!!.adapter = adapterFragments


        tabLayout.setupWithViewPager(viewPager)

    }
}
