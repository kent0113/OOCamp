package com.thoughtworks;

/**
 * Created by twer on 12/21/13.
 */
public class UnitCm implements Units {

    double FromM = 0.01;
    double FromKM = 0.00001;
    @Override
    public double convertToM(double length) {
        return length/100.0;
    }

    @Override
    public double convertFrom(double value, Unit unit) {

        return 0;
    }
}
