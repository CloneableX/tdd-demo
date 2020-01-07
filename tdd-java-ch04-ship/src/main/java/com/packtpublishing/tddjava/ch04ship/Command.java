package com.packtpublishing.tddjava.ch04ship;

public enum Command {
    Forward("f", "forward"), Back("b", "back");

    private final String shortName;
    private final String name;

    Command(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }
}