package com.clo.xunit;

public class WasRun extends TestCase {
    public Integer wasRun;
    public String log;

    public WasRun(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        this.wasRun = null;
        log = "setUp ";
    }

    public void testMethod() {
        log = log + "testMethod ";
    }
}
