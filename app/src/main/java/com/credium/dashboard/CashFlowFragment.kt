package com.credium.dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry


class CashFlowFragment : Fragment(), DashboardFragment.OnSelectListener {

    private lateinit var valueChartDataSet: BarDataSet
    private lateinit var forecastChartDataSet: BarDataSet

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_cash_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val valueChartEntries = listOf(BarEntry(1f, floatArrayOf(820f, 110f, 309f)))
        val valueChartColors = listOf(
                R.color.chartColorBlue,
                R.color.chartColorGray,
                R.color.chartColorGreen
        ).map { ResourcesCompat.getColor(resources, it, context!!.theme) }

        valueChartDataSet = BarDataSet(valueChartEntries, "").apply {
            this.colors = valueChartColors
            barBorderWidth = 0f
            formLineWidth = 1f
            //setDrawValues(false)
        }

        val forecastChartEntries = listOf(
                BarEntry(1f, floatArrayOf(83f, 100f)),
                BarEntry(2f, floatArrayOf(77f, 100f)),
                BarEntry(3f, floatArrayOf(71f, 100f)),
                BarEntry(4f, floatArrayOf(65f, 100f)),
                BarEntry(5f, floatArrayOf(53f, 100f)),
                BarEntry(6f, floatArrayOf(25f, 100f)),
                BarEntry(7f, floatArrayOf(3f, 100f))
        )
        val forecastChartColors = listOf(
                R.color.chartColorBlue,
                R.color.chartColorGreen
        ).map { ResourcesCompat.getColor(resources, it, context!!.theme) }

        forecastChartDataSet = BarDataSet(forecastChartEntries, "").apply {
            colors = forecastChartColors
            barBorderWidth = 0f
            formLineWidth = 1f
        }

        animate()
        animate2()
    }

    override fun onSelected() {
        animate()
        animate2()
    }

    private fun animate() {
        view?.findViewById<HorizontalBarChart>(R.id.valueChart)?.apply {
            data = BarData(valueChartDataSet)
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

    private fun animate2() {
        view?.findViewById<BarChart>(R.id.payoutForecast)?.apply {
            data = BarData(forecastChartDataSet)
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