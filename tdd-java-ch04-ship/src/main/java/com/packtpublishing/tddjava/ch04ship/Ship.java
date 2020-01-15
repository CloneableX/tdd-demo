package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    private void action(Command command, Point max) {
        if (command.equals(Command.Forward)) {
            location.forward(max);
        } else if (command.equals(Command.Back)) {
            location.backward(max);
        } else if (command.equals(Command.TurnLeft)) {
            location.turnLeft();
        } else if (command.equals(Command.TurnRight)) {
            location.turnRight();
        }
    }

    public void action(String commands) {
        action(commands, new Point(100, 100));
    }

    public void action(String commands, Point max) {
        char[] commandStrings = commands.toCharArray();
        for (char commandStr : commandStrings) {
            Command command = Command.transCommand(String.valueOf(commandStr));
            action(command, max);
        }
    }
}
