package com.clo.xunit;

import java.lang.reflect.Method;

public class TestCase {
    protected String methodName;
    private TestResult testResult = new TestResult();

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void setUp() {}

    public void tearDown() {}

    public TestResult run() {
        testResult.testStarted();
        setUp();
        try {
            Method method = this.getClass().getMethod(methodName);
            method.invoke(this);
        } catch (Exception e) {
            testResult.testFailed();
        }
        tearDown();
        return testResult;
    }
}
