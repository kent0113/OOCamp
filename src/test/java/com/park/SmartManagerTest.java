package com.park;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class SmartManagerTest {

    List<ParkingLot> parkingLotList;
    Manager smartManager;

    @Before
    public void setUp() throws Exception {
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList.add(new ParkingLot(3));

        smartManager = new Manager(parkingLotList,StategyEnum.SMART);

    }

    @Test
    public void should_park_successfully_when_have_available_parking_port(){
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        smartManager = new Manager(parkingLotList,StategyEnum.SMART);

        Car car = new Car();
        Receipt receipt = smartManager.park(car);
        assertNotNull(receipt);
    }


    @Test
    public void should_park_in_the_most_avaiable_port_parking_lot_when_there_is_only_one_parking_lot(){
        parkingLotList = new ArrayList<ParkingLot>();
        ParkingLot mostAvailableSpaceParkingLot = new ParkingLot(3);
        parkingLotList.add(mostAvailableSpaceParkingLot);
        smartManager = new Manager(parkingLotList,StategyEnum.SMART);

        Car car = new Car();
        Receipt receipt = smartManager.park(car);
        Car car1 = mostAvailableSpaceParkingLot.getCar(receipt);
        assertSame(car,car1);
    }

    @Test
    public void should_park_the_car_in_the_most_available_port_parking_lot_when_there_are_two_parking_lot() throws Exception {
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        ParkingLot mostAvailableSpaceParkingLot = new ParkingLot(20);
        parkingLotList.add(mostAvailableSpaceParkingLot);
        smartManager = new Manager(parkingLotList,StategyEnum.SMART);

        Car car = new Car();
        Receipt receipt = smartManager.park(car);
        Car car1 = mostAvailableSpaceParkingLot.getCar(receipt);
        assertSame(car,car1);
    }


    @Test
    public void should_park_the_car_in_the_most_available_port_parking_lot_when_there_are_many_parking_lot() throws Exception {
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList.add(new ParkingLot(12));
        ParkingLot mostAvailableSpaceParkingLot = new ParkingLot(20);
        parkingLotList.add(mostAvailableSpaceParkingLot);
        parkingLotList.add(new ParkingLot(0));
        parkingLotList.add(new ParkingLot(5));
        smartManager = new Manager(parkingLotList,StategyEnum.SMART);

        Car car = new Car();
        Receipt receipt = smartManager.park(car);
        Car car1 = mostAvailableSpaceParkingLot.getCar(receipt);
        assertSame(car,car1);
    }

}
