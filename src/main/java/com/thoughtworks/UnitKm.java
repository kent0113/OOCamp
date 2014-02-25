package com.thoughtworks;

/**
 * Created by twer on 12/21/13.
 */
public class UnitKm implements Units {
    @Override
    public double convertToM(double length) {
        return length*1000;
    }

    @Override
    public double convertFrom(double value, Unit unit) {
        return 0;
    }
}
