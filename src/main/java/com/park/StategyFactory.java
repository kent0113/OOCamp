package com.park;

public class StategyFactory {

    public static Stategy getStategy(StategyEnum stategyEnum){
        Stategy stategy = null;

        switch (stategyEnum){
            case NORMAL:
                stategy = new NormalStategy();
                break;
            case SMART:
                stategy = new SmartStategy();
                break;
            case SUPER:
                stategy = new SuperStategy();
                break;
            default:
                break;
        }
        return stategy;
    }
}
