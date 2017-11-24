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
            Note(loan = UnlockedLoan(id = 3112, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76), riskPercentage = 89, apr = 13, riskScore = RiskScore.NORMAL),
            Note(loan = UnlockedLoan(id = 3113, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77), riskPercentage = 78, apr = 13, riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 3114, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72), riskPercentage = 89, apr = 13, riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 3115, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89), riskPercentage = 89, apr = 13, riskScore = RiskScore.NORMAL),
            Note(loan = UnlockedLoan(id = 3116, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76), riskPercentage = 81, apr = 13, riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 3117, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71), riskPercentage = 89, apr = 13, riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 3118, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76), riskPercentage = 77, apr = 13, riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 3112, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76), riskPercentage = 89, apr = 13, riskScore = RiskScore.NORMAL),
            Note(loan = UnlockedLoan(id = 3113, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77), riskPercentage = 78, apr = 13, riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 3114, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72), riskPercentage = 89, apr = 13, riskScore = RiskScore.INCREASE),
            Note(loan = UnlockedLoan(id = 3115, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89), riskPercentage = 89, apr = 13, riskScore = RiskScore.NORMAL),
            Note(loan = UnlockedLoan(id = 3116, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76), riskPercentage = 81, apr = 13, riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 3117, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71), riskPercentage = 89, apr = 13, riskScore = RiskScore.DECREASE),
            Note(loan = UnlockedLoan(id = 3118, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76), riskPercentage = 77, apr = 13, riskScore = RiskScore.INCREASE)
    )

    fun fetchMarketNotes(): List<UnlockedLoan> = listOf(UnlockedLoan(id = 111, currency = DollarUsaCurrency, amount = 20_250, amountPerMonth = 2250, months = 8, sellFor = 4760, discount = 32, riskScore = 89),
            UnlockedLoan(id = 112, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76),
            UnlockedLoan(id = 113, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77),
            UnlockedLoan(id = 114, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72),
            UnlockedLoan(id = 115, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89),
            UnlockedLoan(id = 116, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76),
            UnlockedLoan(id = 117, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71),
            UnlockedLoan(id = 118, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76),
            UnlockedLoan(id = 119, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77),
            UnlockedLoan(id = 121, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72),
            UnlockedLoan(id = 122, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89),
            UnlockedLoan(id = 123, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76),
            UnlockedLoan(id = 124, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71),
            UnlockedLoan(id = 125, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76),
            UnlockedLoan(id = 126, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77),
            UnlockedLoan(id = 127, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72),
            UnlockedLoan(id = 128, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89),
            UnlockedLoan(id = 130, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76),
            UnlockedLoan(id = 131, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71),
            UnlockedLoan(id = 132, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76),
            UnlockedLoan(id = 133, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77),
            UnlockedLoan(id = 134, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72),
            UnlockedLoan(id = 135, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89),
            UnlockedLoan(id = 136, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76),
            UnlockedLoan(id = 137, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71),
            UnlockedLoan(id = 138, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76),
            UnlockedLoan(id = 139, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77),
            UnlockedLoan(id = 140, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72),
            UnlockedLoan(id = 141, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89),
            UnlockedLoan(id = 142, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76),
            UnlockedLoan(id = 143, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71)
    )

    fun fetchSellOrderNotes(): List<UnlockedLoan> = listOf(
            UnlockedLoan(id = 2137, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71, daysOnMarket = 7),
            UnlockedLoan(id = 2138, currency = DollarUsaCurrency, amount = 36_000, amountPerMonth = 30, months = 20, sellFor = 4125, discount = 25, riskScore = 76, daysOnMarket = 2),
            UnlockedLoan(id = 2139, currency = DollarUsaCurrency, amount = 12_250, amountPerMonth = 2500, months = 6, sellFor = 1920, discount = 40, riskScore = 77, daysOnMarket = 1),
            UnlockedLoan(id = 2140, currency = DollarUsaCurrency, amount = 15_000, amountPerMonth = 2500, months = 6, sellFor = 3000, discount = 25, riskScore = 72, daysOnMarket = 3),
            UnlockedLoan(id = 2141, currency = DollarUsaCurrency, amount = 18_000, amountPerMonth = 2250, months = 8, sellFor = 3840, discount = 36, riskScore = 89, daysOnMarket = 3),
            UnlockedLoan(id = 2142, currency = DollarUsaCurrency, amount = 17_550, amountPerMonth = 1350, months = 13, sellFor = 3775, discount = 50, riskScore = 76, daysOnMarket = 10),
            UnlockedLoan(id = 2143, currency = DollarUsaCurrency, amount = 76_800, amountPerMonth = 3200, months = 24, sellFor = 8000, discount = 20, riskScore = 71, daysOnMarket = 1)
    )

}
