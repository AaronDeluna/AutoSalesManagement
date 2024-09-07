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

    /**
     * Проверяет исправность всех компонентов автомобиля.
     *
     * @return true, если все компоненты исправны.
     * @throws StartCarException если один или несколько компонентов не работают.
     */
    public boolean checkAllComponentsWorking() throws StartCarException {
        for (Wheel wheel : wheels) {
            if (wheel == null || wheel.isPunctured()) {
                throw new StartCarException("Ошибка: Одно или несколько колес не в порядке");
            }
        }

        if (gasTank.getFuelAmount() <= 0) {
            throw new StartCarException("Ошибка: Недостаточно топлива");
        }
        if (!engine.isFunctional()) {
            throw new StartCarException("Ошибка: Двигатель не работает");
        }
        if (!electric.isFunctional()) {
            throw new StartCarException("Ошибка: Электрика не работает");
        }
        if (!headlights.isFunctional()) {
            throw new StartCarException("Ошибка: Фары не работают");
        }

        return true;
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
