package com.clo.multi.currency;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExpressionTest {
    @Test
    public void should_plus_different_currency() {
        Money fiveDollar = Money.dollar(5);
        Money tenFranc = Money.franc(10);
        Expression sum = fiveDollar.plus(tenFranc);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        assertThat(sum.reduce(bank, "USD"), is(Money.dollar(10)));
    }
}
