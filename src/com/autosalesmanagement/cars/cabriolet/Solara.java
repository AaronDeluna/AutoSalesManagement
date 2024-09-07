package com.autosalesmanagement.cars.cabriolet;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Solara представляет конкретную модель кабриолета.
 * Наследует от Cabriolet и добавляет поддержку мини-холодильника.
 */
public class Solara extends Cabriolet {
    private boolean hasMiniFridge = true;

    public Solara(Color color, int maxSpeed, TransmissionType transmissionType,
                  Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                  Headlights headlights, BigDecimal price, Country country) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
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
