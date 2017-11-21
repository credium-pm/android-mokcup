package com.credium.util

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.res.ResourcesCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import com.credium.R
import com.credium.data.Loan


fun <T : Context> T.loanAmountText(loan: Loan): String =
        getString(R.string.amount_and_currency_template, loan.amount.toString(), loan.currency.label)

fun <T : Context> T.loanPerMonthDescription(loan: Loan): String =
        getString(R.string.loan_subtitle1, loan.amountPerMonth.toString(), loan.currency.label)

fun <T : Context> T.loanMonthsLeftDescription(loan: Loan): String =
        resources.getQuantityString(R.plurals.loan_subtitle2, loan.months, loan.months)

fun <T : Context> T.getColoredString(text: String, subTextWithColor: Map<String, Int>): SpannableString {
    val colored = SpannableString(text)
    for ((subText, color) in subTextWithColor) {
        val start = text.indexOf(subText)
        val end = start + subText.length
        val resolvedColor = ResourcesCompat.getColor(resources, color, theme)
        colored.setSpan(ForegroundColorSpan(resolvedColor), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return colored
}

fun getBoldSpanString(text: String, vararg subTexts: String): SpannableString {
    val colored = SpannableString(text)
    for (subText in subTexts) {
        val start = text.indexOf(subText)
        val end = start + subText.length
        colored.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return colored
}
