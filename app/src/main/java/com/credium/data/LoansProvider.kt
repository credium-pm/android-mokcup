package com.credium.data

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData


object LoansProvider {

    private val loans = MutableLiveData<List<Loan>>()

    fun addLoans(loans: List<Loan>) {
        this.loans.value = loans
    }

    fun getLoans(): LiveData<List<Loan>> = loans

    fun getLoan(id: Int): Loan? = loans.value?.firstOrNull { it.id == id }
}
