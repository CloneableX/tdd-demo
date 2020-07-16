package com.clo.xunit;

public class WasRun extends TestCase{
    public Integer wasRun;

    public WasRun(String methodName) {
        super(methodName);
        this.wasRun = null;
    }

    public void testMethod() {
        wasRun = 1;
    }
}
