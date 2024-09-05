package com.autosalesmanagement;

import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.component.*;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;

public class Runner {
    public static void main(String[] args) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(true, 17);
        }
        GasTank gasTank = new GasTank(10);
        Engine engine = new Engine(true);
        Electric electric = new Electric(true);
        Headlights headlights = new Headlights(true);
        Component component = new Component(wheels, gasTank, engine, electric, headlights,20000);
        Camry camry = new Camry("Red", 200, TransmissionType.AUTOMATIC, false, component, Country.JAPAN, false, true);
        camry.startMoving();
        camry.stopMoving();
        camry.turnOnHeadlights();
        camry.disableCruiseControl();
        camry.enableCruiseControl();
        camry.connectMusic();
    }
}
