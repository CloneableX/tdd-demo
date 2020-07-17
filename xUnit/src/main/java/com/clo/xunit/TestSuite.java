package com.clo.xunit;

import java.util.ArrayList;
import java.util.List;

public class TestSuite {
    private List<TestCase> testCases = new ArrayList<>();

    public TestResult run() {
        TestResult testResult = new TestResult();
        testCases.forEach(testCase -> testCase.run(testResult));
        return testResult;
    }

    public void add(TestCase testCase) {
        testCases.add(testCase);
    }
}
