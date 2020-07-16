package com.clo.xunit;

public class WasRun extends TestCase {
    public String log;

    public WasRun(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        log = "setUp ";
    }

    public void testMethod() {
        log = log + "testMethod ";
    }

    @Override
    public void tearDown() {
        log = log + "tearDown ";
    }
}
