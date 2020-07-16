package com.clo.xunit;

public class WasRun extends TestCase {
    public Integer wasRun;
    protected Integer wasSetUp;

    public WasRun(String methodName) {
        super(methodName);
        this.wasRun = null;
    }

    @Override
    public void setUp() {
        wasSetUp = 1;
    }

    public void testMethod() {
        wasRun = 1;
    }
}
