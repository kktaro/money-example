package com.example.moneyexample.domain.vo

data class Dollar(
    val dollarAmount: Int,
) : Money(dollarAmount, Currency.USD)