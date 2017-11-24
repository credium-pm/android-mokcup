package com.credium.net

import com.credium.data.*


object LoansService {

    private var lastId = 0

    fun fetchLoans(): List<Loan> = listOf(
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 20_000, amountPerMonth = 1000, months = 12),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 1500, months = 10),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 20_700, amountPerMonth = 2300, months = 9),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 40_000, amountPerMonth = 2500, months = 16),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 14_400, amountPerMonth = 1500, months = 12),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 30_000, amountPerMonth = 3000, months = 10),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 20_000, amountPerMonth = 2000, months = 20),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 1500, months = 24),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 24_000, amountPerMonth = 1000, months = 24),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 10800, amountPerMonth = 1800, months = 6),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 4000, months = 9),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 120_000, amountPerMonth = 2000, months = 60),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 200_000, amountPerMonth = 6250, months = 32),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 23_400, amountPerMonth = 2600, months = 8),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 21_000, amountPerMonth = 3000, months = 7),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 40_000, amountPerMonth = 2500, months = 16),
            LockedLoan(id = ++lastId, currency = DollarUsaCurrency, amount = 25_200, amountPerMonth = 2100, months = 12)
    )

    fun fetchPortfolioNotes() = listOf(
            Note(loan = UnlockedLoan(id = 111, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
                    riskPercentage = 89,
                    apr = 13,
                    riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 222, currency = DollarUsaCurrency, amount = 180, amountPerMonth = 30, months = 6),
                    riskPercentage = 67,
                    apr = 19,
                    riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 333, currency = DollarUsaCurrency, amount = 75, amountPerMonth = 15, months = 5),
                    riskPercentage = 73,
                    apr = 10,
                    riskScore = RiskScore.NORMAL),
            Note(loan = UnlockedLoan(id = 444, currency = DollarUsaCurrency, amount = 1000, amountPerMonth = 50, months = 12),
                    riskPercentage = 89,
                    apr = 13,
                    riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 555, currency = DollarUsaCurrency, amount = 180, amountPerMonth = 30, months = 6),
                    riskPercentage = 67,
                    apr = 19,
                    riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 666, currency = DollarUsaCurrency, amount = 75, amountPerMonth = 15, months = 5),
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
