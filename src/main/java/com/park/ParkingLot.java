package com.park;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private HashMap<Receipt,Car> carHashMap;

    public ParkingLot(int carPortNumNum) {
        this.capacity = carPortNumNum;
        carHashMap = new HashMap<Receipt, Car>();
    }

    public int getRemainParkingSpace() {
        return capacity - carHashMap.size();
    }

    public Receipt park(Car car) {
        if(!hasAvailablePort()) return null;
        if (checkCarExist(car)) return null;
        Receipt receipt = new Receipt();
        carHashMap.put(receipt,car);
        return  receipt;
    }

    public boolean hasAvailablePort() {
        return  (getRemainParkingSpace() > 0);
    }

    private boolean checkCarExist(Car car) {
        Iterator iterator = carHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Car val = (Car)entry.getValue();
            if(val.equals(car)){
                return true;
            }
        }
        return false;
    }

    public Car getCar(Receipt receipt) {
        return carHashMap.get(receipt);
    }

    public double getVacancyRate() {
        return ((double) getRemainParkingSpace())/ capacity;
    }
}
