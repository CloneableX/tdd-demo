package com.clo.xunit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class TestCaseTest extends TestCase {
    public TestCaseTest(String methodName) {
        super(methodName);
    }

    public void testRunning() throws Exception {
        WasRun test = new WasRun("testMethod");
        test.run();
        assertThat(test.wasRun, notNullValue());
    }
    
    public void testSetUp() throws Exception {
        WasRun test = new WasRun("testMethod");
        test.run();
        assertThat(test.wasSetUp, notNullValue());
    }

    public static void main(String[] args) throws Exception {
        new TestCaseTest("testRunning").run();
        new TestCaseTest("testSetUp").run();
    }
}
