package com.thoughtworks;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by twer on 12/20/13.
 */
public class Length {
    private Unit unit;
    private double value;
    private Units units;

    public Length( double value,Unit unit) {
        this.unit = unit;
        this.value = value;
    }

    public boolean equalTo(Length length) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        if(this.unit == length.unit){
            if(this.value == length.value){
                return true;
            }
        }else{
//            units = UnitFactory.getInstance(unit).getClass().newInstance();
//            Method method = UnitFactory.getInstance(unit).getClass().getMethod("convertFrom" + unit, double.class, Unit.class);
            //Object newLength = (double)method.invoke(units, length.value, length.unit);
            //newLength
        }
        return false;
    }

    public Length plus(Length length){
        Length lengthNew = new Length(convertTo(this.unit),this.unit);
        return new Length( this.value + length.value ,this.unit);

    }

    public Length minus(Length length){
        length.convertTo(this.unit);
        return new Length(this.value - length.value, this.unit);
    }

    private double convertTo(Unit unit) {
        switch (unit){
            case CM:
                break;
            case M:
                break;
            case KM:
                break;
        }
        return 0;

    }
}
