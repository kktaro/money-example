package com.example.moneyexample.domain.vo

interface Expression {
    fun reduce(to: Currency): Money
}