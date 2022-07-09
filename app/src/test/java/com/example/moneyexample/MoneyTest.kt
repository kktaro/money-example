package com.example.moneyexample

import com.example.moneyexample.domain.vo.Currency
import com.example.moneyexample.domain.vo.Money
import org.junit.Test

class MoneyTest {
    @Test
    fun ドルの乗算() {
        val five: Money = Money.ofDollar(5)
        assert(five.times(2) == Money.ofDollar(10))
        assert(five.times(3) == Money.ofDollar(15))
    }
    @Test
    fun フランの乗算() {
        val five: Money = Money.ofFranc(5)
        assert(five.times(2) == Money.ofFranc(10))
        assert(five.times(3) == Money.ofFranc(15))
    }
    @Test
    fun DollarとFrancの比較() {
        assert(Money.ofDollar(5) != Money.ofFranc(5))
    }
    @Test
    fun 通貨テスト() {
        assert(Currency.USD == Money.ofDollar(1).currency)
        assert(Currency.CHF == Money.ofFranc(1).currency)
    }
}