package com.autosalesmanagement.cars.truck;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;

import java.math.BigDecimal;

/**
 * Класс Dyna представляет конкретную модель грузовика.
 * Наследует от Truck и добавляет поддержку наличия розетки.
 */
public class Dyna extends Truck {
    private boolean hasSocket = true;

    public Dyna(Color color, int maxSpeed,
                TransmissionType transmissionType,
                Component component, BigDecimal price,
                Country country, int maxLoadCapacityKg) {
        super(color, maxSpeed, transmissionType, component, price, country, maxLoadCapacityKg);
    }

    public void chargePhone() {
        if (this.hasSocket) {
            System.out.println("Заряжаем телефон");
        } else {
            System.out.println("Нет розетки");
        }
    }
}
