package com.auto_sales_management.cars.cabriolet;

import com.auto_sales_management.component.*;
import com.auto_sales_management.manufacturing.Country;
import com.auto_sales_management.cars.Car;

import java.math.BigDecimal;

/**
 * Абстрактный класс Cabriolet.
 * Расширяет Car и добавляет поддержку состояния крыши.
 */
public abstract class Cabriolet extends Car {
    protected boolean isRoofUp;

    public Cabriolet(Color color, int maxSpeed, TransmissionType transmissionType,
                     Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                     Headlights headlights, BigDecimal price, Country country) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
    }

    public void openRoof() {
        System.out.println("Крыша открыта");
        this.isRoofUp = true;
    }

    public void closeRoof() {
        System.out.println("Крыша закрыта");
    }
}
