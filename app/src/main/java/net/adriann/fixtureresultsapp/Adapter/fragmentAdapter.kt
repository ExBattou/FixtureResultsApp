package net.adriann.fixtureresultsapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import net.adriann.fixtureresultsapp.UI.Fragments.FixturesFragment
import net.adriann.fixtureresultsapp.UI.Fragments.ResultsFragment


class fragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){


    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {
                return FixturesFragment()

          }
            1 -> {
                return ResultsFragment()
            }

            else -> return null
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Fixtures"
            else -> {
                return "Results"
            }
        }
    }
}