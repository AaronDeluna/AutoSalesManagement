package org.autosales.cars.models;

import org.autosales.cars.component.Component;
import org.autosales.enums.GearboxType;

/**
 * Кабриолет.
 */
public class Solara extends Car {
    private boolean isRoofOpenable;
    private boolean hasMiniFridge;

    public Solara(String color, int maxSpeed, GearboxType gearboxType,
                  boolean isInMotion, Component component,
                  String country, boolean isRoofOpenable, boolean hasMiniFridge) {
        super(color, maxSpeed, gearboxType, isInMotion, component, country);
        this.isRoofOpenable = isRoofOpenable;
        this.hasMiniFridge = hasMiniFridge;
    }

    public void coolTheDrink() {
        if (this.hasMiniFridge) {
            System.out.println("Охлаждаем напиток");
        }
    }

    public boolean isRoofOpenable() {
        return isRoofOpenable;
    }

    public void setRoofOpenable(boolean roofOpenable) {
        isRoofOpenable = roofOpenable;
    }

    public boolean isHasMiniFridge() {
        return hasMiniFridge;
    }

    public void setHasMiniFridge(boolean hasMiniFridge) {
        this.hasMiniFridge = hasMiniFridge;
    }

    @Override
    public String toString() {
        return "Solara{" +
                "isRoofOpenable=" + isRoofOpenable +
                ", hasMiniFridge=" + hasMiniFridge +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", gearboxType=" + gearboxType +
                ", isInMotion=" + isInMotion +
                ", component=" + component +
                '}';
    }
}
