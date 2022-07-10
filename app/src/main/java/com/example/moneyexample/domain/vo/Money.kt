package com.example.moneyexample.domain.vo

import com.example.moneyexample.domain.worker.Bank

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

    fun plus(addend: Money): Money {
        return Money(amount + addend.amount, currency)
    }

    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun times(multiplier: Int): Expression {
        return Money(amount * multiplier, this.currency)
    }

    override fun reduce(bank: Bank, to: Currency): Money {
        return Money(amount / bank.getRate(currency, to), to)
    }
}