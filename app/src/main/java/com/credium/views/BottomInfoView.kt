package com.credium.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.credium.R
import kotlinx.android.synthetic.main.view_bottom_info.view.*


class BottomInfoView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var title1: String = ""
        set(value) {
            title1Text.text = value
        }

    var title2: String = ""
        set(value) {
            title2Text.text = value
        }

    var title3: String = ""
        set(value) {
            title3Text.text = value
        }

    var value1: String = ""
        set(value) {
            value1Text.text = value
        }

    var value2: String = ""
        set(value) {
            value2Text.text = value
        }

    var value3: String = ""
        set(value) {
            value3Text.text = value
        }

    init {
        inflate(context, R.layout.view_bottom_info, this)
    }
}