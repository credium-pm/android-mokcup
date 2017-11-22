package com.credium.dashboard

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.res.ResourcesCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.credium.R
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_loans_dashboard.*


class LoansDashboardFragment : Fragment(), DashboardFragment.OnSelectListener {

    private lateinit var pieDataSet: PieDataSet
    private lateinit var styledString: SpannableString

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_loans_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleColor = ResourcesCompat.getColor(resources, R.color.darkGrayColor, context!!.theme)
        styledString = SpannableString("Loans\n23").apply {
            setSpan(ForegroundColorSpan(titleColor), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(1.5f), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(StyleSpan(Typeface.BOLD), 5, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(3f), 5, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        val colors = listOf(
                R.color.chartColorRed,
                R.color.chartColorBlue,
                R.color.chartColorGreen,
                R.color.chartColorGray
        ).map { ResourcesCompat.getColor(resources, it, context!!.theme) }

        val entries = listOf(12f, 6f, 3f, 2f).map { PieEntry(it) }
        pieDataSet = PieDataSet(entries, "").apply {
            sliceSpace = 0f
            valueLineWidth = 10f
            formLineWidth = 50f
            setDrawIcons(false)
            setDrawValues(false)
            this.colors = colors
        }
    }

    override fun onSelected() {
        pieChart.apply {
            data = PieData(pieDataSet)
            highlightValues(null)
            legend.isEnabled = false
            description.isEnabled = false
            setTouchEnabled(false)
            holeRadius = 60f
            centerText = styledString
            animateXY(1000, 1000)
            invalidate()
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser)
            pieChart.invalidate()
    }
}