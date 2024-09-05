package com.autosalesmanagement.cars.passengercar;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;

/**
 * Класс Camry представляет конкретную модель пассажирского автомобиля.
 * Наследует от PassengerCar и добавляет поддержку USB-порта.
 */
public class Camry extends PassengerСar {
    private boolean hasUsbPort;

    public Camry(Color color, int maxSpeed,
                 TransmissionType transmissionType,
                 boolean isMoving, Component component,
                 Country country, boolean hasCruiseControl, boolean hasUsbPort) {
        super(color, maxSpeed, transmissionType, isMoving, component, country, hasCruiseControl);
        this.hasUsbPort = hasUsbPort;
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
