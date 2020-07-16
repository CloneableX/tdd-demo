package com.clo.multi.currency;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PairTest {
    @Test
    public void should_pair_equals() {
        assertThat(new Pair("CHF", "USD"), is(new Pair("CHF", "USD")));
    }
}