package com.example.moneyexample.domain.vo

data class Dollar(
    val dollarAmount: Int,
) : Money(dollarAmount) {

    override fun times(multiplier: Int): Money {
        return Dollar(amount * multiplier)
    }
}