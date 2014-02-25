package com.park;

import java.util.List;

public abstract class Stategy {
    public abstract ParkingLot getParkingLot(List<ParkingLot> parkingLotList);

    protected boolean hasAvailablePort(List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.hasAvailablePort()) {
                return true;
            }
        }
        return false;
    }

}
