package com.credium.loandetails

import android.arch.lifecycle.ViewModel
import com.credium.data.Loan
import com.credium.data.LoansProvider


class LoanDetailsViewModel : ViewModel() {

    // TODO: use live data to notify updates

    fun loadLoan(id: Int): Loan? =
            LoansProvider.getLoan(id)
}
