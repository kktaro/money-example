package com.example.moneyexample.domain.vo

data class Franc(
    val francAmount: Int,
) : Money(francAmount, Currency.CHF)