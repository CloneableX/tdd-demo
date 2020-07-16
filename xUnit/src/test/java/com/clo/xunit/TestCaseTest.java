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

    public static void main(String[] args) throws Exception {
        new TestCaseTest("testTemplateMethod").run();
    }
}
