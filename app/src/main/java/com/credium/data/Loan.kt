package com.credium.data


sealed class Loan(
        val id: Int,
        val currency: Currency,
        val amount: Int,
        val amountPerMonth: Int,
        val months: Int,
        var isLocked: Boolean)

class LockedLoan(id: Int,
                 currency: Currency,
                 amount: Int,
                 amountPerMonth: Int,
                 months: Int
) : Loan(id, currency, amount, amountPerMonth, months, isLocked = true)

class UnlockedLoan(id: Int,
                   currency: Currency,
                   amount: Int,
                   amountPerMonth: Int,
                   months: Int,
                   val pendingAmount: Int,
                   val sellFor: Int
) : Loan(id, currency, amount, amountPerMonth, months, isLocked = false)
