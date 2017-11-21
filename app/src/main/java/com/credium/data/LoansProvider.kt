package com.credium.data


object LoansProvider {

    private val loans = mutableListOf<Loan>(
            LockedLoan(id = 1, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12).apply { isLocked = false },
            LockedLoan(id = 2, currency = DollarUsaCurrency, amount = 1500, amountPerMonth = 150, months = 10),
            LockedLoan(id = 3, currency = DollarUsaCurrency, amount = 2100, amountPerMonth = 300, months = 7)
    )

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
