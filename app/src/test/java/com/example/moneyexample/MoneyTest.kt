package com.example.moneyexample

import com.example.moneyexample.domain.vo.Currency
import com.example.moneyexample.domain.vo.Expression
import com.example.moneyexample.domain.vo.Money
import com.example.moneyexample.domain.vo.Sum
import com.example.moneyexample.domain.worker.Bank
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
    @Test
    fun 加算テスト() {
        val five = Money.ofDollar(5)
        val result: Expression = five.plus(five)
        val sum: Sum = result as Sum
        assert(five == sum.augend)
        assert(five == sum.addend)
    }
    @Test
    fun ReduceSumテスト() {
        val bank = Bank()
        val sum = Sum(Money.ofDollar(3), Money.ofDollar(4))
        val result = bank.reduce(sum, Currency.USD)
        assert(Money.ofDollar(7) == result)
    }
    @Test
    fun ReduceMoneyテスト() {
        val bank = Bank()
        val result = bank.reduce(Money.ofDollar(1), Currency.USD)
        assert(Money.ofDollar(1) == result)
    }
}