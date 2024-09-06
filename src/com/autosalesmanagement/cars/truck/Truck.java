package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.component.Color;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.component.TransmissionType;
import com.autosalesmanagement.cars.Car;

import java.math.BigDecimal;

/**
 * Абстрактный класс Truck.
 * Расширяет Car и добавляет поддержку грузоподъемности.
 */
public abstract class Truck extends Car {
    protected int maxLoadCapacityKg;

    public Truck(Color color, int maxSpeed,
                 TransmissionType transmissionType,
                 Component component, BigDecimal price, Country country, int maxLoadCapacityKg) {
        super(color, maxSpeed, transmissionType, component, price, country);
        this.maxLoadCapacityKg = maxLoadCapacityKg;
    }

    public int getMaxLoadCapacityKg() {
        return maxLoadCapacityKg;
    }

    public void setMaxLoadCapacityKg(int maxLoadCapacityKg) {
        this.maxLoadCapacityKg = maxLoadCapacityKg;
    }
}
