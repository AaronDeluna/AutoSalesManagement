package com.auto_sales_management.cars.passengercar;

import com.auto_sales_management.component.*;
import com.auto_sales_management.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Camry представляет конкретную модель пассажирского автомобиля.
 * Наследует от PassengerCar и добавляет поддержку USB-порта.
 */
public class Camry extends PassengerCar {
    private UsbPort usbPort;

    public Camry(Color color, int maxSpeed, TransmissionType transmissionType,
                 Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                 Headlights headlights, BigDecimal price, Country country) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
        this.usbPort = new UsbPort();
    }

    public void connectMusic() {
        if (usbPort != null) {
            System.out.println("Подключена музыка");
        } else {
            System.out.println("Нет Usb порта");
        }
    }

    public UsbPort getUsbPort() {
        return usbPort;
    }

    public void setUsbPort(UsbPort usbPort) {
        this.usbPort = usbPort;
    }
}
