package com.example.moneyexample.domain.vo

data class Franc(
    val francAmount: Int,
) : Money(francAmount) {

    override fun times(multiplier: Int): Money {
        return Franc(amount * multiplier)
    }
}