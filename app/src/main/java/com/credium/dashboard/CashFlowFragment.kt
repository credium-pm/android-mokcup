package com.credium.dashboard

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_cash_flow.*


class CashFlowFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_cash_flow_static, container, false)

    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entries = listOf(
                BarEntry(1f, floatArrayOf(10f, 20f, 30f))
        )
        val dataSet = BarDataSet(entries, "").apply {
            colors = ColorTemplate.COLORFUL_COLORS.toList()
            barBorderWidth = 0f
            formLineWidth = 1f

        }

        valueChart.apply {
            data = BarData(dataSet)
            setFitBars(true)
            setDrawBarShadow(false)
            description.isEnabled = false
            setDrawGridBackground(false)
            //animateXY(1000, 100)
            invalidate()
        }

        */
        /*valueChart.apply {
            //isDrawBordersEnabled = false

            xAxis.isEnabled = false
            xAxis.setDrawGridLines(false)
            setDrawGridBackground(false)
            axisLeft.setDrawAxisLine(false)
            axisRight.setDrawAxisLine(false)
            axisLeft.setDrawGridLines(false)
            axisRight.setDrawGridLines(false)
            invalidate()
        }*//*

    }
*/
}