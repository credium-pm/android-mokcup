package com.credium.data


data class Loan(val currency: Currency, val amount: Double, val months: Int, var isLocked: Boolean) {

    val amountPerMonth: Double
        get() = amount / months
}
