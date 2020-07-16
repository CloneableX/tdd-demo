package com.clo.xunit;

import java.lang.reflect.Method;

public class TestCase {
    protected String methodName;

    public TestCase(String methodName) {
        this.methodName = methodName;
    }

    public void run() throws Exception {
        Method method = this.getClass().getMethod(methodName);
        method.invoke(this);
    }
}
