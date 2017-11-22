package com.credium.dashboard

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.*
import com.credium.R
import kotlinx.android.synthetic.main.fragment_notes_main.*


class DashboardFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewPager.adapter = SectionsPagerAdapter(activity!!.supportFragmentManager)

        activity?.findViewById<TabLayout>(R.id.tabs)?.setupWithViewPager(viewPager)
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_dashboard, menu)
    }

    inner class SectionsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        private val titles by lazy {
            listOf(
                    getString(R.string.cash_flow),
                    getString(R.string.loans),
                    getString(R.string.risk_management)
            )
        }
        private val fragments by lazy { listOf(Fragment(), Fragment(), Fragment()) }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = 3
    }

}