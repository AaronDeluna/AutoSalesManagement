package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Hiance представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия запасного колеса.
 */
public class Hiance extends Truck {
    private Wheel spareWheel; //Сделать класс

    public Hiance(Color color, int maxSpeed, TransmissionType transmissionType,
                  Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                  Headlights headlights, BigDecimal price, Country country,
                  int maxLoadCapacityKg, Wheel spareWheel) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric,
                headlights, price, country, maxLoadCapacityKg);
        this.spareWheel = spareWheel;
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(Wheel spareWheel) {
        this.spareWheel = spareWheel;
    }
}
