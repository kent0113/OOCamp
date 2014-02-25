package com.park;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by twer on 12/24/13.
 */
public class ParkingLotTest {

    @Test
    public void should_return_remain_carport() throws Exception {
        ParkingLot parkingLot = new ParkingLot(10);

        assertTrue(parkingLot.hasAvailablePort());

    }

    @Test
    public void should_return_receipt(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        parkingLot.park(car);
        assertTrue(parkingLot.hasAvailablePort());
    }

    @Test
    public void should_not_return_receipt_when_exist(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        parkingLot.park(car);
        Receipt receipt = parkingLot.park(car);

        assertTrue(parkingLot.hasAvailablePort());
        assertNull(receipt);
    }

    @Test
    public void should_return_diff_ticket(){
        ParkingLot parkingLot = new ParkingLot(10);
        Car car1 = new Car();
        Car car2 = new Car();
        Receipt receipt1 = parkingLot.park(car1);
        Receipt receipt2 = parkingLot.park(car2);

        assertTrue(parkingLot.hasAvailablePort());
        assertFalse(receipt1.equals(receipt2));
    }

    @Test
    public void should_get_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car();
        Receipt receipt = parkingLot.park(car);
        Car car1 = parkingLot.getCar(receipt);
        assertEquals(car,car1);
    }
}
