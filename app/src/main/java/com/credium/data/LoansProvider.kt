package com.credium.data


object LoansProvider {

    private val loans = mutableListOf<Loan>()

    fun addLoans(loans: List<Loan>) {
        this.loans.addAll(loans)
    }

    fun getLoans(): List<Loan> = loans

    fun getLoan(id: Int): Loan? = loans.firstOrNull { it.id == id }
}
