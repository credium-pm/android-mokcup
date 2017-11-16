package com.credium.data

sealed class Currency(val symbol: String, val label: String)

object DollarUsaCurrency : Currency("$", "USD")
