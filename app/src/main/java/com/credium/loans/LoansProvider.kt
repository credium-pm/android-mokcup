package com.credium.loans

import com.credium.data.DollarUsaCurrency
import com.credium.data.Loan
import com.credium.data.LockedLoan


object LoansProvider {

    private val loans by lazy {
        mutableListOf<Loan>(
                LockedLoan(id = 1, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
                LockedLoan(id = 2, currency = DollarUsaCurrency, amount = 1500, amountPerMonth = 150, months = 10),
                LockedLoan(id = 3, currency = DollarUsaCurrency, amount = 2100, amountPerMonth = 300, months = 7)
        )
    }

    fun fetchLoans(): MutableList<Loan> = loans

    fun getLoan(id: Int): Loan? = loans.firstOrNull { it.id == id }
}
