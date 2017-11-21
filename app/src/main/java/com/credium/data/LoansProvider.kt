package com.credium.data


object LoansProvider {

    private val loans = mutableListOf<Loan>()

    fun addLoans(loans: List<Loan>) {
        this.loans.addAll(loans)
    }

    fun getLoans(): List<Loan> = loans

    fun getLoan(id: Int): Loan? = loans.firstOrNull { it.id == id }

    fun deleteLoan(id: Int) {
        val newLoans = loans.filter { it.id != id }.toMutableList()
        loans.clear()
        loans.addAll(newLoans)
    }

    fun addLoan(loan: Loan) {
        loans.add(loan)
    }
}
