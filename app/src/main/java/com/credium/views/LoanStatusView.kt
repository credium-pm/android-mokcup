package com.credium.views

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.LinearLayout
import com.credium.R
import kotlinx.android.synthetic.main.view_loan_status.view.*


class LoanStatusView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_loan_status, this)
    }

    var isLocked: Boolean = true
        set(value) {
            // text
            val color = if (value) R.color.lockedColor else R.color.unlockedColor
            statusText.setTextColor(ContextCompat.getColor(context, color))
            statusText.text = context.getString(if (value) R.string.locked else R.string.unlocked)

            // locked icon
            val lockedDrawable = if (value)
                ContextCompat.getDrawable(context, R.drawable.ic_circle_locked)
            else
                ContextCompat.getDrawable(context, R.drawable.ic_circle_locked_inactive)
            lockedImage.setImageDrawable(lockedDrawable)

            // unlocked icon
            val unlockedDrawable = if (value)
                ContextCompat.getDrawable(context, R.drawable.ic_circle_unlocked_inactive)
            else
                ContextCompat.getDrawable(context, R.drawable.ic_circle_unlocked)
            unlockedImage.setImageDrawable(unlockedDrawable)
        }
}
