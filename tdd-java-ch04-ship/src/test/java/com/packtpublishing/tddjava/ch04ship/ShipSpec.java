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


    public void should_x_plus_1_when_action_forward_given_east_ship() {
        Point expectedPoint = new Point(initPoint.getX() + 1, initPoint.getY());
        ship.action(Command.Forward);

        assertEquals(ship.getLocation().getPoint(), expectedPoint);
    }

    public void should_x_minus_1_when_action_back_given_east_ship() {
        Point expectPoint = new Point(initPoint.getX() - 1, initPoint.getY());
        ship.action(Command.Back);
        assertEquals(ship.getLocation().getPoint(), expectPoint);
    }

    public void should_direction_north_when_turn_left_given_east_ship() {
        ship.action(Command.TurnLeft);
        assertEquals(ship.getLocation().getDirection(), Direction.NORTH);
    }

    public void should_direction_south_when_turn_right_given_east_ship() {
        ship.action(Command.TurnRight);
        assertEquals(ship.getLocation().getDirection(), Direction.SOUTH);
    }
}
