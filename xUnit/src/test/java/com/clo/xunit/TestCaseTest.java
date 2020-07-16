package com.clo.xunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class TestCaseTest {
    @Test
    public void should_run_test_method() throws Exception {
        WasRun test = new WasRun("testMethod");
        assertThat(test.wasRun, nullValue());
        test.run();
        assertThat(test.wasRun, notNullValue());
    }
}
