package com.auto_sales_management.cars.truck;

import com.auto_sales_management.component.*;
import com.auto_sales_management.manufacturing.Country;
import com.auto_sales_management.cars.Car;

import java.math.BigDecimal;

/**
 * Абстрактный класс Truck.
 * Расширяет Car и добавляет поддержку грузоподъемности.
 */
public abstract class Truck extends Car {
    protected int maxLoadCapacityKg;

    public Truck(Color color, int maxSpeed, TransmissionType transmissionType,
                 Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                 Headlights headlights, BigDecimal price, Country country, int maxLoadCapacityKg) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
        this.maxLoadCapacityKg = maxLoadCapacityKg;
    }

    public int getMaxLoadCapacityKg() {
        return maxLoadCapacityKg;
    }

    public void setMaxLoadCapacityKg(int maxLoadCapacityKg) {
        this.maxLoadCapacityKg = maxLoadCapacityKg;
    }
}
