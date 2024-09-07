package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Dyna представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия розетки.
 */
public class Dyna extends Truck {
    private boolean hasSocket = true;

    public Dyna(Color color, int maxSpeed, TransmissionType transmissionType,
                Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                Headlights headlights, BigDecimal price, Country country, int maxLoadCapacityKg) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country, maxLoadCapacityKg);
    }

    public void chargePhone() {
        if (this.hasSocket) {
            System.out.println("Заряжаем телефон");
        } else {
            System.out.println("Нет розетки");
        }
    }
}
