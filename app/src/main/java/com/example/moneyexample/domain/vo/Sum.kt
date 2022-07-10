package com.example.moneyexample.domain.vo

import com.example.moneyexample.domain.worker.Bank

data class Sum(
    val augend: Expression,
    val addend: Expression,
) : Expression {
    override fun plus(addend: Expression): Expression {
        return Sum(this, addend)
    }

    override fun times(multiplier: Int): Expression {
        return Sum(augend.times(multiplier), addend.times(multiplier))
    }

    override fun reduce(bank: Bank, to: Currency): Money {
        val amount = augend.reduce(bank, to).amount +
                addend.reduce(bank, to).amount
        return Money(amount, to)
    }
}