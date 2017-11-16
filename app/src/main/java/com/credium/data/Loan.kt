package com.credium.data


data class Loan(val currency: Currency, val amount: Int, val months: Int, var isLocked: Boolean) {

    val amountPerMonth: Int
        get() = amount / months
}
