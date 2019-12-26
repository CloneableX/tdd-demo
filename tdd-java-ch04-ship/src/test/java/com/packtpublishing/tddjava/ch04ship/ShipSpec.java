package com.packtpublishing.tddjava.ch04ship;

import org.testng.annotations.*;

import static org.testng.Assert.*;

@Test
public class ShipSpec {

    public void should_start_point_and_direction_when_initialize_ship_given_point_and_direction() {
        Location initLocation = new Location(new Point(0, 0), Direction.EAST);
        Ship ship = new Ship(initLocation);
        assertEquals(ship.getLocation(), initLocation);
    }
}
