package com.autosalesmanagement.cars.passengercar;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;
import com.autosalesmanagement.cars.Car;

/**
 * Абстрактный класс PassengerCar.
 * Наследует от Car и добавляет поддержку круиз-контроля.
 */
public abstract class PassengerСar extends Car {
    protected boolean hasCruiseControl;

    public PassengerСar(String color, int maxSpeed,
                        TransmissionType transmissionType,
                        boolean isMoving, Component component,
                        Country country, boolean hasCruiseControl) {
        super(color, maxSpeed, transmissionType, isMoving, component, country);
        this.hasCruiseControl = hasCruiseControl;
    }

    public void disableCruiseControl() {
        System.out.println("Вы выключили круиз-контроль");
        this.hasCruiseControl = false;
    }

    public void enableCruiseControl() {
        System.out.println("Вы включили круиз-контроль");
        this.hasCruiseControl = true;
    }

    public boolean isHasCruiseControl() {
        return hasCruiseControl;
    }
}
