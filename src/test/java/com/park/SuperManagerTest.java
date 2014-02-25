package com.park;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SuperManagerTest {

    List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    Manager superManager = new Manager(parkingLotList,StategyEnum.SUPER);

    @Test
    public void should_park_in_the_most_avaiable_port_parking_lot_when_there_is_only_one_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(3);
        parkingLotList.add(parkingLot);


        Car carExpect = new Car();
        Receipt receipt = superManager.park(carExpect);
        Car carActual = parkingLot.getCar(receipt);
        assertSame(carExpect, carActual);
    }

    @Test
    public void should_park_the_car_in_the_most_available_port_rate_parking_lot() throws Exception {
        ParkingLot parkingLot = new ParkingLot(18);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        parkingLotList.add(parkingLot);

        ParkingLot mostSpaceRateParkingLot = new ParkingLot(10);
        mostSpaceRateParkingLot.park(new Car());
        parkingLotList.add(mostSpaceRateParkingLot);

        ParkingLot parkingLot2 = new ParkingLot(18);
        parkingLot2.park(new Car());
        parkingLot2.park(new Car());
        parkingLotList.add(parkingLot2);


        Car carExpect = new Car();
        Receipt receipt = superManager.park(carExpect);
        Car carActual = mostSpaceRateParkingLot.getCar(receipt);
        assertSame(carExpect, carActual);
    }

    @Test
    public void should_park_the_car_in_the_most_available_port_space_parking_lot_when_rate_is_same() throws Exception {
        ParkingLot parkingLot = new ParkingLot(4);
        parkingLot.park(new Car());
        parkingLotList.add(parkingLot);

        ParkingLot mostAvailableSpaceParkingLot = new ParkingLot(8);
        mostAvailableSpaceParkingLot.park(new Car());
        mostAvailableSpaceParkingLot.park(new Car());
        parkingLotList.add(mostAvailableSpaceParkingLot);

        ParkingLot parkingLot2 = new ParkingLot(4);
        parkingLot2.park(new Car());
        parkingLotList.add(parkingLot2);

        Car carExpect = new Car();
        Receipt receipt = superManager.park(carExpect);
        Car carActual = mostAvailableSpaceParkingLot.getCar(receipt);
        assertSame(carExpect, carActual);
    }

}
