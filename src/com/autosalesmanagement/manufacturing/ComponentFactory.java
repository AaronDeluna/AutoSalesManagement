package com.autosalesmanagement.manufacturing;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.component.WheelDiameter;

/**
 * Фабрика для создания компонентов автомобиля.
 */
public class ComponentFactory {
    private static final int WHEEL_COUNT = 4;
    private static final boolean IS_WORKS = true;
    private static final int FUEL_AMOUNT = 0;
    private static final boolean IS_PUNCTURED = false;
    private Country country;

    public ComponentFactory(Country country) {
        this.country = country;
    }

    public Component createAllComponents(WheelDiameter wheelDiameter) {
        Wheel[] wheels = new Wheel[WHEEL_COUNT];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel(IS_PUNCTURED, wheelDiameter);
        }
        GasTank gasTank = new GasTank(FUEL_AMOUNT);
        Engine engine = new Engine(IS_WORKS);
        Electric electric = new Electric(IS_WORKS);
        Headlights headlights = new Headlights(IS_WORKS);
        return new Component(wheels, gasTank, engine, electric, headlights);
    }

    public Wheel[] createWheels(WheelDiameter wheelDiameter) {
        Wheel[] wheels = new Wheel[WHEEL_COUNT];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel(IS_PUNCTURED, wheelDiameter);
        }
        return wheels;
    }

    public Wheel createWheel(WheelDiameter wheelDiameter) {
        return new Wheel(IS_PUNCTURED, wheelDiameter);
    }

    public GasTank createGasTank() {
        return new GasTank(0);
    }

    public Engine createEngine() {
        return new Engine(true);
    }

    public Electric createElectric() {
        return new Electric(true);
    }

    public Headlights createHeadlights() {
        return new Headlights(true);
    }

    public Country getCountry() {
        return country;
    }
}
