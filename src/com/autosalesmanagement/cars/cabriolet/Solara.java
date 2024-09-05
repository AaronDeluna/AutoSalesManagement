package com.autosalesmanagement.cars.cabriolet;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;

/**
 * Класс Solara представляет конкретную модель кабриолета.
 * Наследует от Cabriolet и добавляет поддержку мини-холодильника.
 */
public class Solara extends Cabriolet {
    private boolean hasMiniFridge;

    public Solara(Color color, int maxSpeed,
                  TransmissionType transmissionType,
                  boolean isMoving, Component component,
                  Country country, boolean isRoofUp, boolean hasMiniFridge) {
        super(color, maxSpeed, transmissionType, isMoving, component, country, isRoofUp);
        this.hasMiniFridge = hasMiniFridge;
    }

    public void coolDrink() {
        if (this.hasMiniFridge) {
            System.out.println("Напиток охлажден");
        } else {
            System.out.println("Нет холодильника");
        }
    }

    public boolean isHasMiniFridge() {
        return hasMiniFridge;
    }

    public void setHasMiniFridge(boolean hasMiniFridge) {
        this.hasMiniFridge = hasMiniFridge;
    }
}
