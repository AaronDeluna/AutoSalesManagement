package org.autosales.cars.models;

import org.autosales.cars.component.Component;
import org.autosales.enums.GearboxType;

/**
 * легковой авто
 */
public class Camry extends Car {
    private boolean isCruiseControl;
    private boolean isAvailabilityUSB;

    public Camry(String color, int maxSpeed, GearboxType gearboxType,
                 boolean isInMotion, Component component,
                 String country, boolean isCruiseControl, boolean isAvailabilityUSB) {
        super(color, maxSpeed, gearboxType, isInMotion, component, country);
        this.isCruiseControl = isCruiseControl;
        this.isAvailabilityUSB = isAvailabilityUSB;
    }

    /**
     * Возможность подключить музыку
     */
    public void connectMusic() {
        if (this.isAvailabilityUSB) {
            System.out.println("Подключаем музыку через USB");
        } else {
            System.out.println("У машины нет USB");
        }
    }

    /**
     * Возможность включить/выключить круиз-контроль
     */
    public void toggleCruiseControl() {
        if (this.isCruiseControl) {
            System.out.println("Вы выключили круиз-контроль");
            this.isCruiseControl = false;
        } else {
            System.out.println("Вы включили круиз контроль");
            this.isCruiseControl = true;
        }
    }

    public boolean isCruiseControl() {
        return isCruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        isCruiseControl = cruiseControl;
    }

    public boolean isAvailabilityUSB() {
        return isAvailabilityUSB;
    }

    public void setAvailabilityUSB(boolean availabilityUSB) {
        isAvailabilityUSB = availabilityUSB;
    }

    @Override
    public String toString() {
        return "Camry{" +
                "isCruiseControl=" + isCruiseControl +
                ", isAvailabilityUSB=" + isAvailabilityUSB +
                '}';
    }
}
