package com.credium.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.credium.R
import kotlinx.android.synthetic.main.view_discont_cash.view.*


class DiscountCashView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.view_discont_cash, this)
    }

    var discountText: String
        get() = discountTextView.text.toString()
        set(value) {
            discountTextView.text = value
        }

    var cashText: String
        get() = cashTextView.text.toString()
        set(value) {
            cashTextView.text = value
        }
}
