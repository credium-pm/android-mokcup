package com.credium.loans

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.credium.data.Loan


class LoansViewModel : ViewModel() {

    // TODO: load from somewhere
    var loansLiveData = MutableLiveData<List<Loan>>()
    var loans: MutableList<Loan> = mutableListOf()

    fun loadLoans() {
        val newLoans = LoansProvider.fetchLoans()
        loansLiveData.postValue(newLoans)
        loans = newLoans
    }
}
