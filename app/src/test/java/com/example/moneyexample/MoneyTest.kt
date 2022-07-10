package com.example.moneyexample

import android.util.Log
import com.example.moneyexample.domain.vo.Currency
import com.example.moneyexample.domain.vo.Expression
import com.example.moneyexample.domain.vo.Money
import com.example.moneyexample.domain.vo.Sum
import com.example.moneyexample.domain.worker.Bank
import org.junit.Test
import org.junit.Assert.*

class MoneyTest {
    @Test
    fun ドルの乗算() {
        val five: Money = Money.ofDollar(5)
        assertEquals(five.times(2), Money.ofDollar(10))
        assertEquals(five.times(3), Money.ofDollar(15))
    }
    @Test
    fun フランの乗算() {
        val five: Money = Money.ofFranc(5)
        assertEquals(five.times(2), Money.ofFranc(10))
        assertEquals(five.times(3), Money.ofFranc(15))
    }
    @Test
    fun DollarとFrancの比較() {
        assertNotEquals(Money.ofDollar(5), Money.ofFranc(5))
    }
    @Test
    fun 通貨テスト() {
        assertEquals(Currency.USD, Money.ofDollar(1).currency)
        assertEquals(Currency.CHF, Money.ofFranc(1).currency)
    }
    @Test
    fun 加算テスト() {
        val five = Money.ofDollar(5)
        val result: Expression = five.plus(five)
        val sum: Sum = result as Sum
        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }
    @Test
    fun ReduceSumテスト() {
        val bank = Bank()
        val sum = Sum(Money.ofDollar(3), Money.ofDollar(4))
        val result = bank.reduce(sum, Currency.USD)
        assertEquals(Money.ofDollar(7), result)
    }
    @Test
    fun ReduceMoneyテスト() {
        val bank = Bank()
        val result = bank.reduce(Money.ofDollar(1), Currency.USD)
        assertEquals(Money.ofDollar(1), result)
    }
    @Test
    fun ReduceMoneyで別通貨に変換するテスト() {
        val bank = Bank()
        bank.addRate(Currency.CHF, Currency.USD, 2)
        val result = bank.reduce(Money.ofFranc(2), Currency.USD)
        assertEquals(Money.ofDollar(1), result)
    }
    @Test
    fun 複数通貨での加算テスト() {
        val bank = Bank()
        val fiveBucks: Expression = Money.ofDollar(5)
        val tenFrancs: Expression = Money.ofFranc(10)

        bank.addRate(Currency.CHF, Currency.USD, 2)
        val result = bank.reduce(fiveBucks.plus(tenFrancs), Currency.USD)
        assertEquals(Money.ofDollar(10), result)
    }
    @Test
    fun SumPlusMoneyのテスト() {
        val bank = Bank()
        val fiveBucks: Expression = Money.ofDollar(5)
        val tenFrancs: Expression = Money.ofFranc(10)

        bank.addRate(Currency.CHF, Currency.USD, 2)
        val sum: Expression = Sum(fiveBucks, tenFrancs).plus(fiveBucks)
        val result = bank.reduce(sum, Currency.USD)
        assertEquals(Money.ofDollar(15), result)
    }
    @Test
    fun SumのTimesのテスト() {
        val bank = Bank()
        val fiveBucks: Expression = Money.ofDollar(5)
        val tenFrancs: Expression = Money.ofFranc(10)

        bank.addRate(Currency.CHF, Currency.USD, 2)
        val sum: Expression = Sum(fiveBucks, tenFrancs).times(2)
        val result = bank.reduce(sum, Currency.USD)
        assertEquals(Money.ofDollar(20), result)
    }
    @Test
    fun 同じ通貨の加算がMoneyを返却する() {
        val sum: Expression = Money.ofDollar(1).plus(Money.ofDollar(1))
        assertTrue(sum is Money)
    }
}