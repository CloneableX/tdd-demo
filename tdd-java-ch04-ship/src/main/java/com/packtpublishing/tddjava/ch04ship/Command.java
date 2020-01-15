package com.packtpublishing.tddjava.ch04ship;

import java.util.Arrays;

public enum Command {
    Forward("f", "forward"),
    Back("b", "back"),
    TurnLeft("l", "turn left"),
    TurnRight("r", "turn right");

    private final String shortName;
    private final String name;

    Command(String shortName, String name) {
        this.shortName = shortName;
        this.name = name;
    }

    public static Command transCommand(String commandStr) {
        Command[] values = Command.values();
        return Arrays.stream(values).filter((Command command) -> command.shortName.equals(commandStr)).findFirst().get();
    }

    public String getShortName() {
        return shortName;
    }
}
