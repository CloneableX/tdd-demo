package com.clo.multi.currency;

public class Money implements Expression {
    public Integer amount;
    public String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return currency.equals(money.currency) && amount.equals(money.amount);
    }

    public Expression plus(Money addend) {
        if (currency.equals(addend.currency)) {
            return new Money(amount + addend.amount, currency);
        }
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
