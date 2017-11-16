package com.credium.loans

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.credium.data.DollarUsaCurrency
import com.credium.data.Loan


class LoansViewModel : ViewModel() {

    // TODO: load from somewhere
    private val loans = listOf(
            Loan(DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12, isLocked = false),
            Loan(DollarUsaCurrency, amount = 1500, amountPerMonth = 150, months = 10, isLocked = true),
            Loan(DollarUsaCurrency, amount = 2100, amountPerMonth = 300, months = 7, isLocked = true)
    )

    val loansLiveData = MutableLiveData<List<Loan>>()

    fun onReady() {
        loansLiveData.value = loans
    }
}