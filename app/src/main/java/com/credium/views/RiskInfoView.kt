package com.credium.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.FrameLayout
import com.credium.R
import com.credium.data.RiskScore
import kotlinx.android.synthetic.main.view_item_risk_score_info.view.*


class RiskInfoView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_item_risk_score_info, this)
    }

    var apr: Int = 0
        set(value) {
            val percentage = "$value%"
            monthPercentageText.text = percentage
        }

    var riskScorePercentage: Int = 0
        set(value) {
            val percentage = "$value%"
            riskScorePercentageText.text = percentage
        }

    var score: RiskScore = RiskScore.NORMAL
        set(value) {
            val imageResource = when (value) {
                RiskScore.INCREASE -> R.drawable.shape_score_increase
                RiskScore.NORMAL -> R.drawable.shape_score_normal
                RiskScore.DECREASE -> R.drawable.shape_score_decrease
            }
            val drawable = ContextCompat.getDrawable(scoreChangeIcon.context, imageResource)
            scoreChangeIcon.setImageDrawable(drawable)
        }
}