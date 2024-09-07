package com.autosalesmanagement.component;

import com.autosalesmanagement.exceptions.StartCarException;

/**
 * Компоненты машины.
 */
public class Component {
    private Wheel[] wheels;
    private GasTank gasTank;
    private Engine engine;
    private Electric electric;
    private Headlights headlights;

    public Component(Wheel[] wheels, GasTank gasTank,
                     Engine engine, Electric electric,
                     Headlights headlights) {
        this.wheels = wheels;
        this.gasTank = gasTank;
        this.engine = engine;
        this.electric = electric;
        this.headlights = headlights;
    }




    public Wheel[] getWheels() {
        return wheels;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public GasTank getGasTank() {
        return gasTank;
    }

    public void setGasTank(GasTank gasTank) {
        this.gasTank = gasTank;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Electric getElectric() {
        return electric;
    }

    public void setElectric(Electric electric) {
        this.electric = electric;
    }

    public Headlights getHeadlights() {
        return headlights;
    }

    public void setHeadlights(boolean headlights) {
        this.headlights.setFunctional(headlights);
    }

}
