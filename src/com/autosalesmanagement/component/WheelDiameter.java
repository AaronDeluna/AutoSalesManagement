package com.autosalesmanagement.component;

public enum WheelDiameter {
    DIAMETER_15_INCHES(15),
    DIAMETER_16_INCHES(15),
    DIAMETER_17_INCHES(17),
    DIAMETER_18_INCHES(18),
    DIAMETER_19_INCHES(19),
    DIAMETER_20_INCHES(20);

    private int diameter;

    WheelDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }
}
