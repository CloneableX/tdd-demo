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

    public void testTemplateMethod() {
        test.run(new TestResult());
        assertThat(test.log, is("setUp testMethod tearDown "));
    }

    public void testResult() {
        TestResult result = test.run(new TestResult());
        assertThat(result.summary(), is("1 run, 0 failed"));
    }

    public void testFailedResult() {
        test = new WasRun("testBrokenMethod");
        TestResult testResult = test.run(new TestResult());
        assertThat(testResult.summary(), is("1 run, 1 failed"));
    }

    public void testRunSuite() {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new WasRun("testBrokenMethod"));
        testSuite.add(new WasRun("testMethod"));
        TestResult testResult = testSuite.run();
        assertThat(testResult.summary(), is("2 run, 1 failed"));
    }

    public static void main(String[] args) {
        TestResult testResult = new TestResult();
        new TestCaseTest("testTemplateMethod").run(testResult);
        new TestCaseTest("testResult").run(testResult);
        new TestCaseTest("testFailedResult").run(testResult);
        new TestCaseTest("testRunSuite").run(testResult);
    }
}
