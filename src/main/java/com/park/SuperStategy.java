package com.park;

import java.util.List;

public class SuperStategy extends Stategy{


    @Override
    public ParkingLot getParkingLot(List<ParkingLot> parkingLotList) {
        if (parkingLotList.size() == 0) {
            return null;
        }

        if(!hasAvailablePort(parkingLotList)) return null;

        ParkingLot parkingLotMost = parkingLotList.get(0);

        for (ParkingLot parkingLot : parkingLotList) {
            if (isBiggerThan(parkingLotMost, parkingLot)) {
                parkingLotMost = parkingLot;
            }
        }
        return parkingLotMost;
    }

    private boolean isBiggerThan(ParkingLot parkingLotMost, ParkingLot parkingLot) {
        if(parkingLot.getVacancyRate() == parkingLotMost.getVacancyRate()){
            return parkingLot.getRemainParkingSpace() > parkingLotMost.getRemainParkingSpace();
        }
        return parkingLot.getVacancyRate() > parkingLotMost.getVacancyRate();
    }
}
