package com.credium.loans

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.credium.data.DollarUsaCurrency
import com.credium.data.Loan
import com.credium.data.LockedLoan
import com.credium.data.UnlockedLoan


class LoansViewModel : ViewModel() {

    // TODO: load from somewhere
    var loansLiveData = MutableLiveData<List<Loan>>()
    var loans: MutableList<Loan> = mutableListOf()
    var selectedLoan: Loan? = null

    fun loadLoans() {
        val newData = mutableListOf(
                UnlockedLoan(DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12, pendingAmount = 600, sellFor = 450),
                LockedLoan(DollarUsaCurrency, amount = 1500, amountPerMonth = 150, months = 10),
                LockedLoan(DollarUsaCurrency, amount = 2100, amountPerMonth = 300, months = 7)
        )
        loansLiveData.postValue(newData)
        loans = newData
    }
}
