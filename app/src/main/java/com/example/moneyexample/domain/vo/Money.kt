package com.example.moneyexample.domain.vo

abstract class Money(
    val amount: Int,
) {
    companion object {
        fun dollar(amount: Int): Money {
            return Dollar(amount)
        }
        fun franc(amount: Int): Money {
            return Franc(amount)
        }
    }

    abstract fun times(multiplier: Int): Money
}