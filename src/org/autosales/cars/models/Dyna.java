package org.autosales.cars.models;

import org.autosales.cars.component.Component;
import org.autosales.enums.GearboxType;

/**
 * грузовой фургон
 */
public class Dyna extends Car {
    private boolean hasPowerOutlet;
    private int loadCapacity;

    public Dyna(String color, int maxSpeed, GearboxType gearboxType,
                boolean isInMotion, Component component,
                String country, boolean hasPowerOutlet, int loadCapacity) {
        super(color, maxSpeed, gearboxType, isInMotion, component, country);
        this.hasPowerOutlet = hasPowerOutlet;
        this.loadCapacity = loadCapacity;
    }

    public void chargePhone() {
        if (this.hasPowerOutlet) {
            System.out.println("Заряжаем телефон");
        } else {
            System.out.println("Зарядки для телефона нет");
        }
    }

    public boolean isHasPowerOutlet() {
        return hasPowerOutlet;
    }

    public void setHasPowerOutlet(boolean hasPowerOutlet) {
        this.hasPowerOutlet = hasPowerOutlet;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Dyna{" +
                "hasPowerOutlet=" + hasPowerOutlet +
                ", loadCapacity=" + loadCapacity +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", gearboxType=" + gearboxType +
                ", isInMotion=" + isInMotion +
                ", component=" + component +
                '}';
    }
}
