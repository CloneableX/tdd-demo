package com.packtpublishing.tddjava.ch04ship;

public class Ship {

    private Location location;

    public Ship(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public Location forward() {
        Direction direction = location.getDirection();
        Point point = location.getPoint();
        if (direction.equals(Direction.EAST)) {
            point.setX(point.getX() + 1);
        }

        location.setPoint(point);
        return location;
    }
}
