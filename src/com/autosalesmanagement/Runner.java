package com.autosalesmanagement;

import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.component.*;
import com.autosalesmanagement.component.Color;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.component.TransmissionType;
import com.autosalesmanagement.component.WheelDiameter;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(true, WheelDiameter.DIAMETER_17_INCHES);
        }
        GasTank gasTank = new GasTank(10);
        Engine engine = new Engine(true);
        Electric electric = new Electric(true);
        Headlights headlights = new Headlights(true);
        Component component = new Component(wheels, gasTank, engine, electric, headlights);
        Camry camry = new Camry(Color.RED, 200,
                TransmissionType.AUTOMATIC, component,
                new BigDecimal(20_000), Country.JAPAN);
        camry.startMoving();
        camry.stopMoving();
        camry.turnOnHeadlights();
        camry.disableCruiseControl();
        camry.enableCruiseControl();
        camry.connectMusic();
    }
}
