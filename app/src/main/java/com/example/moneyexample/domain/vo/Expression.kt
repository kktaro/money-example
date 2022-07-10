package com.example.moneyexample.domain.vo

import com.example.moneyexample.domain.worker.Bank

interface Expression {
    fun plus(addend: Expression): Expression
    fun times(multiplier: Int): Expression
    fun reduce(bank: Bank, to: Currency): Money
}