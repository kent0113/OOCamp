package com.thoughtworks;

/**
 * Created by twer on 12/21/13.
 */
public class UnitM implements Units {
    @Override
    public double convertToM(double length) {
        return length;
    }

    @Override
    public double convertFrom(double value, Unit unit) {
        return 0;
    }
}
