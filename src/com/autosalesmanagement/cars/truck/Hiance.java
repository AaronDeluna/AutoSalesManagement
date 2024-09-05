package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;

import java.math.BigDecimal;

/**
 * Класс Hiance представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия запасного колеса.
 */
public class Hiance extends Truck {
    private boolean hasSpareWheel;

    public Hiance(Color color, int maxSpeed,
                  TransmissionType transmissionType,
                  Component component, BigDecimal price,
                  Country country, int maxLoadCapacityKg, boolean hasSpareWheel) {
        super(color, maxSpeed, transmissionType, component, price, country, maxLoadCapacityKg);
        this.hasSpareWheel = hasSpareWheel;
    }

    public boolean isHasSpareWheel() {
        return hasSpareWheel;
    }

    public void setHasSpareWheel(boolean hasSpareWheel) {
        this.hasSpareWheel = hasSpareWheel;
    }
}
