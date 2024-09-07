package com.autosalesmanagement.cars.passengercar;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Camry представляет конкретную модель пассажирского автомобиля.
 * Наследует от PassengerCar и добавляет поддержку USB-порта.
 */
public class Camry extends PassengerСar {
    private boolean hasUsbPort = true;

    public Camry(Color color, int maxSpeed, TransmissionType transmissionType,
                 Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                 Headlights headlights, BigDecimal price, Country country) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
    }

    public void connectMusic() {
        if (this.hasUsbPort) {
            System.out.println("Подключена музыка");
        } else {
            System.out.println("Нет Usb порта");
        }
    }

    public boolean isHasUsbPort() {
        return hasUsbPort;
    }

    public void setHasUsbPort(boolean hasUsbPort) {
        this.hasUsbPort = hasUsbPort;
    }
}
