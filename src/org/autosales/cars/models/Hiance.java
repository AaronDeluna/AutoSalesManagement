package org.autosales.cars.models;

import org.autosales.cars.component.Component;
import org.autosales.enums.GearboxType;

/**
 * грузовой фургон
 */
public class Hiance extends Car {
    private boolean hasSpareTire;
    private int loadCapacity;

    public Hiance(String color, int maxSpeed, GearboxType gearboxType,
                  boolean isInMotion, Component component,
                  String country, boolean hasSpareTire, int loadCapacity) {
        super(color, maxSpeed, gearboxType, isInMotion, component, country);
        this.hasSpareTire = hasSpareTire;
        this.loadCapacity = loadCapacity;
    }

    public boolean isHasSpareTire() {
        return hasSpareTire;
    }

    public void setHasSpareTire(boolean hasSpareTire) {
        this.hasSpareTire = hasSpareTire;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Hiance{" +
                "hasSpareTire=" + hasSpareTire +
                ", loadCapacity=" + loadCapacity +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", gearboxType=" + gearboxType +
                ", isInMotion=" + isInMotion +
                ", component=" + component +
                '}';
    }
}
