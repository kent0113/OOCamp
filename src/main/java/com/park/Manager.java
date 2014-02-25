package com.park;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    List<ParkingLot> parkingLotList = new ArrayList<ParkingLot>();
    HashMap<Receipt, ParkingLot> receiptParkingLotHashMap = new HashMap<Receipt, ParkingLot>();
    private Stategy stategy;

    private Manager(List<ParkingLot> parkingLotList, StategyEnum stategyEnum) {
        this.parkingLotList = parkingLotList;
        stategy = StategyFactory.getStategy(stategyEnum);
    }

    public Manager(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Receipt park(Car car){
        ParkingLot parkingLot = stategy.getParkingLot(parkingLotList);

        Receipt receipt = parkingLot.park(car);
        receiptParkingLotHashMap.put(receipt, parkingLot);
        return receipt;
    }


    public Car getCar(Receipt receipt) {
        ParkingLot parkingLot = receiptParkingLotHashMap.get(receipt);
        return parkingLot.getCar(receipt);
    }
}
