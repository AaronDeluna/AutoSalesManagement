package com.autosalesmanagement.component;

public class Wheel {
    private boolean isPunctured;
    private int diameter;

    public Wheel(boolean isPunctured, int diameter) {
        this.isPunctured = isPunctured;
        this.diameter = diameter;
    }

    public boolean isPunctured() {
        return isPunctured;
    }

    public void setPunctured(boolean punctured) {
        isPunctured = punctured;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
