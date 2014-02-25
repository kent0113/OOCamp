package com.park;

import java.util.List;

public class SmartStategy extends Stategy{

    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {

        if (parkingLotList.size() == 0) {
            return null;
        }

        if(!hasAvailablePort(parkingLotList)) return null;

        ParkingLot parkingLotMost = parkingLotList.get(0);

        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getRemainParkingSpace() > parkingLotMost.getRemainParkingSpace()) {
                parkingLotMost = parkingLot;
            }
        }
        return parkingLotMost;
    }
}
