package com.credium.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.LinearLayout
import com.credium.R
import kotlinx.android.synthetic.main.view_chart_description.view.*


class ChartDescriptionView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_chart_description, this)
        val a = context.obtainStyledAttributes(attrs, R.styleable.ChartDescriptionView, defStyleAttr, 0)
        val radioImageResource = a.getResourceId(R.styleable.ChartDescriptionView_radioImage, 0)
        titleText.text = a.getString(R.styleable.ChartDescriptionView_title) ?: ""
        subTitleText.text = a.getString(R.styleable.ChartDescriptionView_subTitle) ?: ""
        a.recycle()
        radioImage.setImageDrawable(ContextCompat.getDrawable(context, radioImageResource))
    }
}
