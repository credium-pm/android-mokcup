package com.credium.data


data class Loan(
        val currency: Currency,
        val amount: Int,
        val amountPerMonth: Int,
        val months: Int,
        var isLocked: Boolean
)
