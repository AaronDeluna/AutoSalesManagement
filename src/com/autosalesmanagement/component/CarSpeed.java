package com.autosalesmanagement.component;

public enum CarSpeed {
    CAMRY_MAX_SPEED(240),
    SOLARA_MAX_SPEED(200),
    HIANCE_MAX_SPEED(180),
    DYNA_MAX_SPEED(120),
    ;

    private int speed;

    CarSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}