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

    private val fragments by lazy { listOf(CashFlowFragment(), LoansDashboardFragment(), RiskManagementFragment()) }

    private val onTabSelectedListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab?) {
            tab?.position?.let { (fragments[it] as? OnSelectListener)?.onSelected() }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) = Unit

        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.position?.let { (fragments[it] as? OnSelectListener)?.onSelected() }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        viewPager.adapter = SectionsPagerAdapter(activity!!.supportFragmentManager)

        activity?.findViewById<TabLayout>(R.id.tabs)?.apply {
            viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(this))
            setupWithViewPager(viewPager)
            addOnTabSelectedListener(onTabSelectedListener)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.findViewById<TabLayout>(R.id.tabs)?.removeOnTabSelectedListener(onTabSelectedListener)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_dashboard, menu)
    }

    private inner class SectionsPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

        private val titles by lazy {
            listOf(
                    getString(R.string.cash_flow),
                    getString(R.string.loans),
                    getString(R.string.risk_management)
            )
        }

        override fun getPageTitle(position: Int): CharSequence? = titles[position]

        override fun getItem(position: Int): Fragment = fragments[position]

        override fun getCount(): Int = fragments.size
    }

    interface OnSelectListener {
        fun onSelected()
    }
}