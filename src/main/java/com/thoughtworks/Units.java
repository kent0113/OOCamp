package com.thoughtworks;

/**
 * Created by twer on 12/21/13.
 */
interface Units {
    public abstract double convertToM(double length);
    public abstract double convertFrom(double value, Unit unit);
}
