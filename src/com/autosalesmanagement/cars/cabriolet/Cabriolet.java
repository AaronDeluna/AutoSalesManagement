package com.autosalesmanagement.cars.cabriolet;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;
import com.autosalesmanagement.cars.Car;

/**
 * Абстрактный класс Cabriolet.
 * Расширяет Car и добавляет поддержку состояния крыши.
 */
public abstract class Cabriolet extends Car {
    protected boolean isRoofUp;

    public Cabriolet(String color, int maxSpeed,
                     TransmissionType transmissionType,
                     boolean isMoving, Component component,
                     Country country, boolean isRoofUp) {
        super(color, maxSpeed, transmissionType, isMoving, component, country);
        this.isRoofUp = isRoofUp;
    }

    public void openRoof() {
        System.out.println("Крыша открыта");
        this.isRoofUp = true;
    }

    public void closeRoof() {
        System.out.println("Крыша закрыта");
    }
}
