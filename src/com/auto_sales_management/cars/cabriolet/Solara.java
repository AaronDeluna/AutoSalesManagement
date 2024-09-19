package com.auto_sales_management.cars.cabriolet;

import com.auto_sales_management.component.*;
import com.auto_sales_management.manufacturing.Country;

import java.math.BigDecimal;

/**
 * Класс Solara представляет конкретную модель кабриолета.
 * Наследует от Cabriolet и добавляет поддержку мини-холодильника.
 */
public class Solara extends Cabriolet {
    private MiniFridge miniFridge;

    public Solara(Color color, int maxSpeed, TransmissionType transmissionType,
                  Wheel[] wheels, GasTank gasTank, Engine engine, Electric electric,
                  Headlights headlights, BigDecimal price, Country country) {
        super(color, maxSpeed, transmissionType, wheels, gasTank, engine, electric, headlights, price, country);
        this.miniFridge = new MiniFridge();
    }

    public void coolDrink() {
        if (miniFridge != null) {
            System.out.println("Напиток охлажден");
        } else {
            System.out.println("Нет холодильника");
        }
    }

    public MiniFridge getMiniFridge() {
        return miniFridge;
    }

    public void setMiniFridge(MiniFridge miniFridge) {
        this.miniFridge = miniFridge;
    }
}
