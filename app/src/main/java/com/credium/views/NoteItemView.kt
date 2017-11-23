package com.credium.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.credium.R
import com.credium.data.Loan
import com.credium.util.loanAmountText
import com.credium.util.loanMonthsLeftDescription
import com.credium.util.loanPerMonthDescription
import kotlinx.android.synthetic.main.view_note_item.view.*


class NoteItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var loan: Loan? = null
        set(value) {
            value?.let {
                amountText.text = context.loanAmountText(value)
                monthsLeftText.text = context.loanMonthsLeftDescription(value)
                amountPerMonthText.text = context.loanPerMonthDescription(value)
            }
        }

    var bottomValue1: String = ""
        set(value) {
            bottomInfoView.value1 = value
        }

    var bottomValue2: String = ""
        set(value) {
            bottomInfoView.value2 = value
        }

    var bottomValue3: String = ""
        set(value) {
            bottomInfoView.value3 = value
        }

    init {
        inflate(context, R.layout.view_note_item, this)
        val a = context.obtainStyledAttributes(attrs, R.styleable.NoteItemView, defStyleAttr, 0)
        bottomInfoView.title1 = a.getString(R.styleable.NoteItemView_bottomTitle1) ?: ""
        bottomInfoView.title2 = a.getString(R.styleable.NoteItemView_bottomTitle2) ?: ""
        bottomInfoView.title3 = a.getString(R.styleable.NoteItemView_bottomTitle3) ?: ""
        a.recycle()
    }
}