package com.credium.net

import com.credium.data.*


object LoansService {

    private var lastId = 0

    fun fetchLoans(): List<Loan> = listOf(
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 1500, amountPerMonth = 150, months = 10),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 2100, amountPerMonth = 300, months = 7)
    )

    fun fetchPortfolioNotes() = listOf(
            Note(loan = UnlockedLoan(id = 11, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
                    riskPercentage = 89,
                    apr = 13,
                    riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 22, currency = DollarUsaCurrency, amount = 180, amountPerMonth = 30, months = 6),
                    riskPercentage = 67,
                    apr = 19,
                    riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 33, currency = DollarUsaCurrency, amount = 75, amountPerMonth = 15, months = 5),
                    riskPercentage = 73,
                    apr = 10,
                    riskScore = RiskScore.NORMAL),
            Note(loan = UnlockedLoan(id = 44, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
                    riskPercentage = 89,
                    apr = 13,
                    riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 55, currency = DollarUsaCurrency, amount = 180, amountPerMonth = 30, months = 6),
                    riskPercentage = 67,
                    apr = 19,
                    riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 66, currency = DollarUsaCurrency, amount = 75, amountPerMonth = 15, months = 5),
                    riskPercentage = 73,
                    apr = 10,
                    riskScore = RiskScore.NORMAL)
    )

    fun fetchMarketNotes(): List<UnlockedLoan> = listOf(
            UnlockedLoan(
                    id = 111,
                    currency = DollarUsaCurrency,
                    amount = 1000,
                    amountPerMonth = 50,
                    months = 20,
                    sellFor = 450,
                    discount = 25,
                    riskScore = 89
            ),
            UnlockedLoan(
                    id = 222,
                    currency = DollarUsaCurrency,
                    amount = 600,
                    amountPerMonth = 30,
                    months = 20,
                    sellFor = 450,
                    discount = 25,
                    riskScore = 76
            )
    )

    fun fetchSellOrderNotes(): List<UnlockedLoan> = listOf(
            UnlockedLoan(
                    id = 1111,
                    currency = DollarUsaCurrency,
                    amount = 1000,
                    amountPerMonth = 50,
                    months = 20,
                    sellFor = 450,
                    discount = 25,
                    riskScore = 89,
                    daysOnMarket = 1
            ),
            UnlockedLoan(
                    id = 2222,
                    currency = DollarUsaCurrency,
                    amount = 600,
                    amountPerMonth = 30,
                    months = 20,
                    sellFor = 450,
                    discount = 25,
                    riskScore = 76,
                    daysOnMarket = 1
            )
    )

}
