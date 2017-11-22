package com.credium.dashboard

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
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

        activity?.findViewById<TabLayout>(R.id.tabs)?.apply {
            setupWithViewPager(viewPager)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_dashboard, menu)
    }

    private inner class SectionsPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

        private val fragments by lazy { listOf(CashFlowFragment(), LoansDashboardFragment(), RiskManagementFragment()) }

        private val titles by lazy {
            listOf(
                    getString(R.string.cash_flow),
                    getString(R.string.loans),
                    getString(R.string.risk_management)
            )
        }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = 3
    }

    interface OnSelectListener {
        fun onSelected()
    }
}