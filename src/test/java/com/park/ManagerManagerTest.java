package com.park;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ManagerManagerTest {

    List<ParkingLot> parkingLotList;
    SeniorManager seniorManager;
    List<Manager> managerList;



    @Test
    public void should_park_by_ownself() throws Exception {
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList.add(new ParkingLot(3));

        managerList = new ArrayList<Manager>();

        seniorManager = new SeniorManager(parkingLotList);

        Car expectCar = new Car();
        Receipt receipt = seniorManager.park(expectCar);
        Car actualCar = seniorManager.getCar(receipt);
        assertSame(expectCar,actualCar);
    }


    @Test
    public void should_assign_manager_to_park_car() throws Exception {
        parkingLotList = new ArrayList<ParkingLot>();
        parkingLotList.add(new ParkingLot(10));
        parkingLotList.add(new ParkingLot(3));


        managerList = new ArrayList<Manager>();
        Manager manager = new Manager(parkingLotList, StategyEnum.SMART);
        managerList.add(manager);

        seniorManager = new SeniorManager(new ArrayList<ParkingLot>(),managerList);

        Car expectCar = new Car();
        Receipt receipt = seniorManager.park(expectCar);
        Car actualCar = seniorManager.getCar(receipt);
        assertSame(expectCar,actualCar);

    }
}
