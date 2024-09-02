package org.autosales.factory;

import org.autosales.cars.component.Component;

/**
 * Фабрика для создания компонентов.
 */
public class ComponentFactory {
    private static final int NUMBER_OF_WHEELS = 4;
    private static final int CAPACITY = 40;
    private static final boolean ENGINE_OPERATIONAL = true;
    private static final boolean IS_ELECTRICS_FUNCTIONAL = true;
    private static final boolean IS_LIGHTS_FUNCTIONAL = true;
    private String country;

    public ComponentFactory(String country) {
        this.country = country;
    }

    /**
     * Создает и возвращает новый объект {@link Component}.
     *
     * @return новый объект {@link Component} с заданными характеристиками.
     */
    public Component createComponent() {
        return new Component(NUMBER_OF_WHEELS, CAPACITY, ENGINE_OPERATIONAL,
                IS_ELECTRICS_FUNCTIONAL, IS_LIGHTS_FUNCTIONAL);
    }

    public String getCountry() {
        return country;
    }
}
