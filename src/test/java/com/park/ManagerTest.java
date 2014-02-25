package com.park;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerTest {

    List<ParkingLot> parkingLotList;
    Manager manager;

    @Before
    public void setUp() throws Exception {
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList.add(new ParkingLot(3));

        manager = new Manager(parkingLotList,StategyEnum.NORMAL);
    }

    @Test
    public void should_park_success_when_port_is_available() throws Exception {
        Receipt receipt = manager.park(new Car());

        assertNotNull(receipt);
    }

    @Test
    public void should_get_car_by_receipt() throws Exception {
        Car car = new Car();
        Receipt receipt = manager.park(car);
        Car car1 = manager.getCar(receipt);
        assertSame(car, car1);
    }
}
