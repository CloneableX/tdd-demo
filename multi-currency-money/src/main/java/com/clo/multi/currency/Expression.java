package com.clo.multi.currency;

public interface Expression {
    Money reduce(Bank bank, String to);

    Expression times(int multiplier);
}
