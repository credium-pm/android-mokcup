package com.credium.loans

import android.arch.lifecycle.ViewModel
import com.credium.data.Loan
import com.credium.data.LoansProvider


class LoansViewModel : ViewModel() {

    val loansLiveData = LoansProvider.getLoans()
    var loans: List<Loan> = listOf()

    fun loadLoans() {
        loans = LoansProvider.getLoans().value ?: emptyList()
    }
}
