package com.park;

import java.util.List;

public class NormalStategy extends Stategy{

    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {

        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.hasAvailablePort()) {
                return parkingLot;
            }
        }
        return null;
    }
}
