package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.component.Color;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.component.TransmissionType;

import java.math.BigDecimal;

/**
 * Класс Hiance представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия запасного колеса.
 */
public class Hiance extends Truck {
    private boolean hasSpareWheel = true; //Сделать класс

    public Hiance(Color color, int maxSpeed,
                  TransmissionType transmissionType,
                  Component component, BigDecimal price,
                  Country country, int maxLoadCapacityKg) {
        super(color, maxSpeed, transmissionType, component, price, country, maxLoadCapacityKg);
    }

    public boolean isHasSpareWheel() {
        return hasSpareWheel;
    }

    public void setHasSpareWheel(boolean hasSpareWheel) {
        this.hasSpareWheel = hasSpareWheel;
    }
}
