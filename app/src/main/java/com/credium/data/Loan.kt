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
                   var pendingAmount: Int = 0,
                   var sellFor: Int = 0,
                   var discount: Int = 0,
                   var riskScore: Int = 0
) : Loan(id, currency, amount, amountPerMonth, months, isLocked = false)
