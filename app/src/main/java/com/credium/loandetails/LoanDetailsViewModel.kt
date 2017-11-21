package com.credium.loandetails

import android.arch.lifecycle.ViewModel
import com.credium.data.Loan
import com.credium.data.LoansProvider
import com.credium.data.UnlockedLoan


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

    fun sellNoteForSelected(pendingAmount: Int, sellFor: Int) {
        selectedLoan?.let { loan ->
            val unlockedLoan = UnlockedLoan(
                    loan.id,
                    loan.currency,
                    loan.amount,
                    loan.amountPerMonth,
                    loan.months,
                    pendingAmount,
                    sellFor
            )
            LoansProvider.deleteLoan(loan.id)
            LoansProvider.addLoan(unlockedLoan)
        }
    }
}
