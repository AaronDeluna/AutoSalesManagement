package com.auto_sales_management.component;

public class Wheel {
    private boolean isPunctured = false;
    private WheelDiameter diameter;

    public Wheel(WheelDiameter diameter) {
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
