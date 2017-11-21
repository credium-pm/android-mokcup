package com.credium.data


object LoansProvider {

    private val loans = mutableListOf<Loan>()

    fun addLoans(loans: List<Loan>) {
        this.loans.addAll(loans)
    }

    fun getLoans(): List<Loan> = loans

    fun getLoan(id: Int): Loan? = loans.firstOrNull { it.id == id }

    fun replaceLoan(id: Int, newLoan: Loan) {
        loans.forEachIndexed { index, loan ->
            if (loan.id == id)
                loans[index] = newLoan
        }
    }
}
