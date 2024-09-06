package com.autosalesmanagement.component;

public class Wheel {
    private boolean isPunctured;
    private WheelDiameter diameter;

    public Wheel(boolean isPunctured, WheelDiameter diameter) {
        this.isPunctured = isPunctured;
        this.diameter = diameter;
    }

    public boolean isPunctured() {
        return isPunctured;
    }

    public void setPunctured(boolean punctured) {
        isPunctured = punctured;
    }

    public WheelDiameter getDiameter() {
        return diameter;
    }

    public void setDiameter(WheelDiameter diameter) {
        this.diameter = diameter;
    }
}
