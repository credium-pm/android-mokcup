package com.credium.net

import com.credium.data.DollarUsaCurrency
import com.credium.data.Loan
import com.credium.data.LockedLoan


object LoansService {

    private var lastId = 0

    fun fetchLoans(): List<Loan> = listOf(
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 1500, amountPerMonth = 150, months = 10),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 2100, amountPerMonth = 300, months = 7)
    )
}
