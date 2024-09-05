package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;

/**
 * Класс Dyna представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия розетки.
 */
public class Dyna extends Truck {
    private boolean hasSocket;

    public Dyna(Color color, int maxSpeed,
                TransmissionType transmissionType,
                boolean isMoving, Component component,
                Country country, int maxLoadCapacityKg, boolean hasSocket) {
        super(color, maxSpeed, transmissionType, isMoving, component, country, maxLoadCapacityKg);
        this.hasSocket = hasSocket;
    }

    public void chargePhone() {
        if (this.hasSocket) {
            System.out.println("Заряжаем телефон");
        } else {
            System.out.println("Нет розетки");
        }
    }
}
