package com.credium.loandetails

import android.arch.lifecycle.ViewModel
import com.credium.data.Loan
import com.credium.data.LoansProvider


class LoanDetailsViewModel : ViewModel() {

    // TODO: use live data to notify updates

    var selectedLoan: Loan? = null

    fun loadLoan(id: Int): Loan? {
        selectedLoan = LoansProvider.getLoan(id)
        return selectedLoan
    }

    fun unlockSelected() {
        selectedLoan?.let { loan ->
            LoansProvider.getLoans()
                    .first { it.id == loan.id }
                    .apply { isLocked = false }
        }
    }
}
