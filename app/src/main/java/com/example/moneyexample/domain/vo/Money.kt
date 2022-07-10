package com.example.moneyexample.domain.vo

data class Money(
    val amount: Int,
    val currency: Currency,
) : Expression {
    companion object {
        fun ofDollar(amount: Int): Money {
            return Money(amount, Currency.USD)
        }
        fun ofFranc(amount: Int): Money {
            return Money(amount, Currency.CHF)
        }
    }

    fun plus(addend: Money): Sum {
        return Sum(this, addend)
    }

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, this.currency)
    }

    override fun reduce(to: Currency): Money {
        return this
    }
}