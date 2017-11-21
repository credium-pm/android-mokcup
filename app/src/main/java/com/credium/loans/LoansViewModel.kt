package com.credium.loans

import android.arch.lifecycle.ViewModel
import com.credium.data.Loan
import com.credium.data.LoansProvider


class LoansViewModel : ViewModel() {

    var loans: List<Loan> = listOf()

    fun loadLoans(): List<Loan> {
        loans = LoansProvider.getLoans()
        return loans
    }
}
