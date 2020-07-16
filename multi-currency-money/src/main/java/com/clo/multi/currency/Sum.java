package com.clo.multi.currency;

public class Sum implements Expression {
    public Expression aguend;
    public Expression addend;

    public Sum(Expression aguend, Expression addend) {
        this.aguend = aguend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to) {
        return (Money) aguend.reduce(bank, to).plus(addend.reduce(bank, to));
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(aguend.times(multiplier), addend.times(multiplier));
    }
}
