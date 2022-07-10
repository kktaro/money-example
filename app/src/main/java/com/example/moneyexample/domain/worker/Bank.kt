package com.example.moneyexample.domain.worker

import com.example.moneyexample.domain.vo.Currency
import com.example.moneyexample.domain.vo.Expression
import com.example.moneyexample.domain.vo.Money

class Bank {
    fun reduce(source: Expression, to: Currency): Money {
        return source.reduce(to)
    }
}