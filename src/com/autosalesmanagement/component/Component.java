package com.autosalesmanagement.component;

import com.autosalesmanagement.exceptions.StartCarException;

public class Component {
    private Wheel[] wheels;
    private GasTank gasTank;
    private Engine engine;
    private Electric electric;
    private Headlights headlights;
    private int price;

    public Component(Wheel[] wheels, GasTank gasTank,
                     Engine engine, Electric electric,
                     Headlights headlights, int price) {
        this.wheels = wheels;
        this.gasTank = gasTank;
        this.engine = engine;
        this.electric = electric;
        this.headlights = headlights;
        this.price = price;
    }

    public boolean checkAllComponentsWorking() throws StartCarException {
        for (int i = 0; i < wheels.length; i++) {
            if (wheels[i] != null && !wheels[i].isPunctured()
                    && gasTank.getFuelAmount() > 0
                    && engine.isFunctional()
                    && electric.isFunctional()
                    && headlights.isFunctional()) {
                return true;
            }
        }
        throw new StartCarException("Ошибка: Компоненты машины не в порядке");
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
