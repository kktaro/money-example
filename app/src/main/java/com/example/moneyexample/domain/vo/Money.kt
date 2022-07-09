package com.example.moneyexample.domain.vo

open class Money(
    private val amount: Int,
    val currency: Currency,
) {
    companion object {
        fun ofDollar(amount: Int): Money {
            return Dollar(amount)
        }
        fun ofFranc(amount: Int): Money {
            return Franc(amount)
        }
    }

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, this.currency)
    }
}