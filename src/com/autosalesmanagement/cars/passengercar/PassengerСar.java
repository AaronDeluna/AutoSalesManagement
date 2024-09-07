package com.autosalesmanagement.cars.passengercar;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.cars.Car;

import java.math.BigDecimal;

/**
 * Абстрактный класс PassengerCar.
 * Наследует от Car и добавляет поддержку круиз-контроля.
 */
public abstract class PassengerСar extends Car {
    protected boolean hasCruiseControl = true;

    public PassengerСar(Color color, int maxSpeed, TransmissionType transmissionType,
                        Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                        Headlights headlights, BigDecimal price, Country country) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
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
        if (!this.hasCruiseControl) {
            System.out.println("Вы включили круиз-контроль");
            this.hasCruiseControl = true;
        } else {
            System.out.println("В машине нет круиз-контроля");
        }
    }

    public boolean isHasCruiseControl() {
        return hasCruiseControl;
    }

    public void setHasCruiseControl(boolean hasCruiseControl) {
        this.hasCruiseControl = hasCruiseControl;
    }
}
