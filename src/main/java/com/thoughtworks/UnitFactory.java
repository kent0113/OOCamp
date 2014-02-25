package com.thoughtworks;

/**
 * Created by twer on 12/21/13.
 */
public class UnitFactory {
    public static Units getInstance(Unit unit){
        Units units = null;
        try {
            units = (Units)Class.forName("com.thoughtworks.Unit"+ unit.toString()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return units;
    }
}
