package com.example.moneyexample.domain.worker

import com.example.moneyexample.domain.vo.Currency
import com.example.moneyexample.domain.vo.Expression
import com.example.moneyexample.domain.vo.Money

class Bank {
    private val rates = mutableMapOf<Pair<Currency, Currency>, Int>()

    fun addRate(from: Currency, to: Currency, rate: Int) {
        rates[Pair(from, to)] = rate
    }

    fun reduce(source: Expression, to: Currency): Money {
        return source.reduce(this, to)
    }

    fun getRate(from: Currency, to: Currency): Int {
        return rates[Pair(from, to)] ?: 1
    }
}