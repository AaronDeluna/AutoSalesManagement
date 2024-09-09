package com.autosalesmanagement.manufacturing;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.component.WheelDiameter;

/**
 * Фабрика для создания компонентов автомобиля.
 */
public class ComponentFactory {
    private static final int WHEEL_COUNT = 4;
    private Country country;

    public ComponentFactory(Country country) {
        this.country = country;
    }

    public Wheel[] createWheels(WheelDiameter wheelDiameter) {
        Wheel[] wheels = new Wheel[WHEEL_COUNT];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel(wheelDiameter);
        }
        return wheels;
    }

    public Wheel createWheel(WheelDiameter wheelDiameter) {
        return new Wheel(wheelDiameter);
    }

    public GasTank createGasTank() {
        return new GasTank();
    }

    public Engine createEngine() {
        return new Engine();
    }

    public Electric createElectric() {
        return new Electric();
    }

    public Headlights createHeadlights() {
        return new Headlights();
    }

    public Country getCountry() {
        return country;
    }
}
