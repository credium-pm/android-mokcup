package com.credium.dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


class CashFlowFragment : Fragment(), DashboardFragment.OnSelectListener {

    private lateinit var dataSet: BarDataSet

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_cash_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entries = listOf(BarEntry(1f, floatArrayOf(820f, 110f, 309f)))
        val colors = listOf(
                R.color.chartColorBlue,
                R.color.chartColorGray,
                R.color.chartColorGreen
        ).map { ResourcesCompat.getColor(resources, it, context!!.theme) }

        dataSet = BarDataSet(entries, "").apply {
            this.colors = colors
            barBorderWidth = 0f
            formLineWidth = 1f
            //setDrawValues(false)
        }
        animate()
    }

    override fun onSelected() {
        animate()
    }

    private fun animate() {
        view?.findViewById<HorizontalBarChart>(R.id.valueChart)?.apply {
            data = BarData(dataSet)
            highlightValues(null)
            //setFitBars(true)
            setDrawBarShadow(false)
            setDrawGridBackground(false)
            xAxis.isEnabled = false
            axisRight.isEnabled = false
            axisLeft.isEnabled = false
            legend.isEnabled = false
            description.isEnabled = false
            setTouchEnabled(false)
            animateXY(1000, 1000)
            //animateX(1000)
            invalidate()
        }
    }
}