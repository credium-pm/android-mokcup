package com.credium.data

sealed class Currency(val symbol: String, label: String)

object DollarUsaCurrency : Currency("$", "USD")
