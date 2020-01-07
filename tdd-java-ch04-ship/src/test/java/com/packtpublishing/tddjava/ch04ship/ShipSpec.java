package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    private Ship ship;
    private Location initLocation;
    private Point initPoint;

    @BeforeMethod
    private void setUp() {
        initPoint = new Point(3, 4);
        initLocation = new Location(initPoint, Direction.EAST);
        ship = new Ship(initLocation);
    }

    public void should_start_point_and_direction_when_initialize_ship_given_point_and_direction() {
        assertEquals(ship.getLocation(), initLocation);
    }


    public void should_go_forward_when_action_forward_given_east_ship() {
        Point expectedPoint = new Point(initPoint.getX() + 1, initPoint.getY());
        ship.action(Command.Forward);

        assertEquals(ship.getLocation().getPoint(), expectedPoint);
    }

    public void should_go_back_when_action_back_given_east_ship() {
        Point expectPoint = new Point(initPoint.getX() - 1, initPoint.getY());
        ship.action(Command.Back);
        assertEquals(ship.getLocation().getPoint(), expectPoint);
    }
}
