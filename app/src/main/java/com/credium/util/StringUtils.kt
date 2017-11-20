package com.credium.util

import android.content.Context
import com.credium.R
import com.credium.data.Loan


fun <T : Context> T.loanAmountText(loan: Loan): String =
        getString(R.string.amount_and_currency_template, loan.amount.toString(), loan.currency.label)

fun <T : Context> T.loanPerMonthDescription(loan: Loan): String =
        getString(R.string.loan_subtitle1, loan.amountPerMonth.toString(), loan.currency.label)

fun <T : Context> T.loanMonthsLeftDescription(loan: Loan): String =
        resources.getQuantityString(R.plurals.loan_subtitle2, loan.months, loan.months)
