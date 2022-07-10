package com.example.moneyexample.domain.vo

data class Sum(
    val augend: Money,
    val addend: Money,
) : Expression {
    override fun reduce(to: Currency): Money {
        val amount = augend.amount + addend.amount
        return Money(amount, to)
    }
}