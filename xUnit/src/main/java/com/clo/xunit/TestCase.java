package com.clo.xunit;

import java.lang.reflect.Method;

public class TestCase {
    protected String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void setUp() {
    }

    public void tearDown() {
    }

    public TestResult run(TestResult testResult) {
        testResult.testStarted();
        setUp();
        try {
            Method method = this.getClass().getMethod(methodName);

            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
            testResult.testFailed();
        }
        tearDown();
        return testResult;
    }
}
