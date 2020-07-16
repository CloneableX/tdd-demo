package com.clo.xunit;

import java.lang.reflect.Method;

public class TestCase {
    protected String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void setUp() throws Exception {}

    public void run() throws Exception {
        setUp();
        Method method = this.getClass().getMethod(methodName);
        method.invoke(this);
    }
}
