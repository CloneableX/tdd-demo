package com.clo.multi.currency;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class MoneyTest {
    @Test
    public void should_money_equals() {
        assertThat(Money.dollar(5), is(Money.dollar(5)));
        assertThat(Money.franc(5), is(Money.franc(5)));
    }

    @Test
    public void should_not_equal_when_compare_dollar_and_franc() {
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    public void should_calculate_multiply() {
        Expression dollar = Money.dollar(5);
        assertThat(dollar.times(2), is(Money.dollar(10)));
        assertThat(dollar.times(3), is(Money.dollar(15)));
    }

    @Test
    public void should_add_money() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced, is(Money.dollar(10)));
    }

    @Test
    @Ignore
    public void should_CHF_to_USD_rate_2() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        assertThat(Money.dollar(5).reduce(bank, "CHF"), is(Money.franc(10)));
        assertThat(Money.franc(10).reduce(bank, "USD"), is(Money.dollar(5)));
        assertThat(Money.dollar(10).reduce(bank, "USD"), is(Money.dollar(10)));
    }
}
