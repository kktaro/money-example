package com.example.moneyexample.domain.vo

data class Money(
    private val amount: Int,
    val currency: Currency,
) {
    companion object {
        fun ofDollar(amount: Int): Money {
            return Money(amount, Currency.USD)
        }
        fun ofFranc(amount: Int): Money {
            return Money(amount, Currency.CHF)
        }
    }

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, this.currency)
    }
}