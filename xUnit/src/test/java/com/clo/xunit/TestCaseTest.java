package com.clo.xunit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestCaseTest extends TestCase {
    private WasRun test;

    public TestCaseTest(String methodName) {
        super(methodName);
    }

    @Override
    public void setUp() {
        test = new WasRun("testMethod");
    }

    public void testTemplateMethod() throws Exception {
        test.run();
        assertThat(test.log, is("setUp testMethod tearDown "));
    }

    public void testResult() throws Exception {
        TestResult result = test.run();
        assertThat(result.summary(), is("1 run, 0 failed"));
    }

    public void testFailedResult() throws Exception {
        test = new WasRun("testBrokenMethod");
        TestResult testResult = test.run();
        assertThat(testResult.summary(), is("1 run, 1 failed"));
    }

    public static void main(String[] args) throws Exception {
        new TestCaseTest("testTemplateMethod").run();
        new TestCaseTest("testResult").run();
        new TestCaseTest("testFailedResult").run();
    }
}
