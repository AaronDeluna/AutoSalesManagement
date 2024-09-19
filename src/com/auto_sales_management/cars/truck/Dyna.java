package com.auto_sales_management.cars.truck;

import com.auto_sales_management.component.*;
import com.auto_sales_management.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Dyna представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия розетки.
 */
public class Dyna extends Truck {
    private Socket socket;

    public Dyna(Color color, int maxSpeed, TransmissionType transmissionType,
                Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                Headlights headlights, BigDecimal price, Country country, int maxLoadCapacityKg) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country, maxLoadCapacityKg);
        this.socket = new Socket();
    }

    public void chargePhone() {
        if (socket != null) {
            System.out.println("Заряжаем телефон");
        } else {
            System.out.println("Нет розетки");
        }
    }
}
