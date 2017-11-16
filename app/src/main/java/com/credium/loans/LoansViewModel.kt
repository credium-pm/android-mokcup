package com.credium.loans

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.credium.data.DollarUsaCurrency
import com.credium.data.Loan


class LoansViewModel : ViewModel() {

    // TODO: load from somewhere
    private val loans = listOf(
            Loan(DollarUsaCurrency, amount = 2000.0, months = 12, isLocked = false),
            Loan(DollarUsaCurrency, amount = 1000.0, months = 3, isLocked = true),
            Loan(DollarUsaCurrency, amount = 10000.0, months = 24, isLocked = true)
    )

    val loansLiveData = MutableLiveData<List<Loan>>()

    fun onReady() {
        loansLiveData.value = loans
    }
}