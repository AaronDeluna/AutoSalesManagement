package com.autosalesmanagement.manufacturing;

import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;
import com.autosalesmanagement.enums.WheelDiameter;

import java.math.BigDecimal;

/**
 * Класс AssemblyLine представляет сборочный конвейер для автомобилей.
 */
public class AssemblyLine {
    private static final int CAMRY_MAX_SPEED = 200;

    private Country country;
    private ComponentFactory componentFactory;

    public AssemblyLine(Country country, ComponentFactory componentFactory) {
        this.country = country;
        this.componentFactory = componentFactory;
    }

    public Camry createCamry(Color color, int price) {
        return new Camry(color, CAMRY_MAX_SPEED, TransmissionType.AUTOMATIC,
                componentFactory.createAllComponents(WheelDiameter.DIAMETER_17_INCHES),
                price, this.country, true, true);
    }
}
