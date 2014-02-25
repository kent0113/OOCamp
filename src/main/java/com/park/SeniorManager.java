package com.park;

import java.util.ArrayList;
import java.util.List;

public class SeniorManager extends Manager {

    List<Manager> managerList = new ArrayList<Manager>();

    public SeniorManager(List<ParkingLot> parkingLotList, List<Manager> managerList) {
        this.parkingLotList = parkingLotList;
        this.managerList = managerList;
        this.stategy = StategyFactory.getStategy(StategyEnum.NORMAL);
    }

    public SeniorManager(List<ParkingLot> parkingLotList) {
        this(parkingLotList, new ArrayList<Manager>());
    }

    @Override
    public Receipt park(Car car) {
        Receipt receipt = null;

        for (Manager manager : managerList) {
            receipt = manager.park(car);
            if (receipt != null) {
                receipt.setManager(manager);
                break;
            }
        }

        if(receipt==null){
            receipt = super.park(car);
        }

        return receipt;

    }

    @Override
    public Car getCar(Receipt receipt) {
        if (receipt.getManager() != null) {
            return receipt.getManager().getCar(receipt);
        } else {
            return super.getCar(receipt);
        }
    }
}
