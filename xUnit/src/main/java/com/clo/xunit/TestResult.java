package com.clo.xunit;

public class TestResult {
    private Integer runCounter = 0;
    private Integer failedCounter = 0;

    public String summary() {
        return runCounter + " run, " + failedCounter + " failed";
    }

    public void increaseRunCounter() {
        runCounter++;
    }
}
