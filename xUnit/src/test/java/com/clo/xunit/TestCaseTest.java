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

    public void testRunTearDownWhenFailed() {
        test = new WasRun("testBrokenMethod");
        test.run(new TestResult());
        assertThat(test.log, is("setUp tearDown "));
    }

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite();
        testSuite.add(new TestCaseTest("testTemplateMethod"));
        testSuite.add(new TestCaseTest("testResult"));
        testSuite.add(new TestCaseTest("testFailedResult"));
        testSuite.add(new TestCaseTest("testRunSuite"));
        testSuite.add(new TestCaseTest("testRunTearDownWhenFailed"));
        testSuite.run();
    }
}
