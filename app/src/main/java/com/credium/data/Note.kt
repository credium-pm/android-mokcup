package com.credium.data

class Note(
        val loan: UnlockedLoan,
        val apr: Int,
        val riskPercentage: Int,
        val riskScore: RiskScore
)
