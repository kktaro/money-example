package com.example.moneyexample

import com.example.moneyexample.domain.vo.Dollar
import com.example.moneyexample.domain.vo.Franc
import com.example.moneyexample.domain.vo.Money
import org.junit.Test

class MoneyTest {
    @Test
    fun ドルの乗算() {
        val five: Money = Money.dollar(5)
        assert(five.times(2) == Money.dollar(10))
        assert(five.times(3) == Money.dollar(15))
    }
    @Test
    fun フランの乗算() {
        val five: Money = Money.franc(5)
        assert(five.times(2) == Money.franc(10))
        assert(five.times(3) == Money.franc(15))
    }
    @Test
    fun DollarとFrancの比較() {
        assert(!Dollar(5).equals(Franc(5)))
    }
}