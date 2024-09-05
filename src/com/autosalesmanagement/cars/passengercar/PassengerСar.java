package com.autosalesmanagement.cars.passengercar;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;
import com.autosalesmanagement.cars.Car;

/**
 * Абстрактный класс PassengerCar.
 * Наследует от Car и добавляет поддержку круиз-контроля.
 */
public abstract class PassengerСar extends Car {
    protected boolean hasCruiseControl;

    public PassengerСar(Color color, int maxSpeed,
                        TransmissionType transmissionType,
                        boolean isMoving, Component component,
                        Country country, boolean hasCruiseControl) {
        super(color, maxSpeed, transmissionType, isMoving, component, country);
        this.hasCruiseControl = hasCruiseControl;
    }

    public void disableCruiseControl() {
        if (this.hasCruiseControl) {
            System.out.println("Вы выключили круиз-контроль");
            this.hasCruiseControl = false;
        } else {
            System.out.println("В машине нет круиз-контроля");
        }
    }

    public void enableCruiseControl() {
        if (this.hasCruiseControl) {
            System.out.println("Вы включили круиз-контроль");
            this.hasCruiseControl = true;
        } else {
            System.out.println("В машине нет круиз-контроля");
        }
    }

    public boolean isHasCruiseControl() {
        return hasCruiseControl;
    }
}
