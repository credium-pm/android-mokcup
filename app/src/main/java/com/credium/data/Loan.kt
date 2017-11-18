package com.credium.data


sealed class Loan(
        val currency: Currency,
        val amount: Int,
        val amountPerMonth: Int,
        val months: Int,
        var isLocked: Boolean) {
}

class LockedLoan(currency: Currency,
                 amount: Int,
                 amountPerMonth: Int,
                 months: Int
) : Loan(currency, amount, amountPerMonth, months, isLocked = true)

class UnlockedLoan(currency: Currency,
                   amount: Int,
                   amountPerMonth: Int,
                   months: Int,
                   val pendingAmount: Int,
                   val sellFor: Int
) : Loan(currency, amount, amountPerMonth, months, isLocked = false)
