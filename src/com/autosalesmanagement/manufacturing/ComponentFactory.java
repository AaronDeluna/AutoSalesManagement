package com.autosalesmanagement.manufacturing;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.WheelDiameter;

/**
 * Фабрика для создания компонентов автомобиля.
 */
public class ComponentFactory {
    private static final int WHEEL_COUNT = 4;
    private static final boolean IS_WORKS = true;
    private Country country;

    public Component createAllComponents(WheelDiameter wheelDiameter) {
        Wheel[] wheels = new Wheel[WHEEL_COUNT];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel(false, wheelDiameter);
        }
        GasTank gasTank = new GasTank(0);
        Engine engine = new Engine(IS_WORKS);
        Electric electric = new Electric(IS_WORKS);
        Headlights headlights = new Headlights(IS_WORKS);
        return new Component(wheels, gasTank, engine, electric, headlights);
    }
}
