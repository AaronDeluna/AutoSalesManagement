package com.autosalesmanagement.cars.cabriolet;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.component.Color;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.component.TransmissionType;
import com.autosalesmanagement.cars.Car;

import java.math.BigDecimal;

/**
 * Абстрактный класс Cabriolet.
 * Расширяет Car и добавляет поддержку состояния крыши.
 */
public abstract class Cabriolet extends Car {
    protected boolean isRoofUp;

    public Cabriolet(Color color, int maxSpeed,
                     TransmissionType transmissionType,
                     Component component, BigDecimal price,
                     Country country) {
        super(color, maxSpeed, transmissionType, component, price, country);
    }

    public void openRoof() {
        System.out.println("Крыша открыта");
        this.isRoofUp = true;
    }

    public void closeRoof() {
        System.out.println("Крыша закрыта");
    }
}
