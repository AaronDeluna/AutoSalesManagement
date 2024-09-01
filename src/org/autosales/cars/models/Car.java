package org.autosales.cars.models;

import org.autosales.cars.component.Component;
import org.autosales.enums.GearboxType;

public abstract class Car {
    protected String color;
    protected int maxSpeed;
    protected GearboxType gearboxType;
    protected boolean isInMotion;
    protected Component component;
    protected String country;

    public Car(String color, int maxSpeed, GearboxType gearboxType,
               boolean isInMotion, Component component, String country) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.gearboxType = gearboxType;
        this.isInMotion = isInMotion;
        this.component = component;
        this.country = country;
    }

    /**
     * Начать движение
     */
    public void startMoving() {
        if (component.getCapacity() > 0) {
            System.out.println("Машина начала движение");
            this.isInMotion = true;
        } else {
            throw new RuntimeException("Ошибка: машина не может ехать с пустым бензабаком");
        }
    }

    /**
     * Остановить движение
     */
    public void stopMoving() {
        System.out.println("Машина остановила движение");
        this.isInMotion = false;
    }

    /**
     * Включить лампы
     */
    public void headlightsOn() {
        System.out.println("Машина включила фары");
        component.setLightsFunctional(true);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public boolean isInMotion() {
        return isInMotion;
    }

    public void setInMotion(boolean inMotion) {
        isInMotion = inMotion;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", gearboxType=" + gearboxType +
                ", isInMotion=" + isInMotion +
                ", component=" + component +
                '}';
    }
}
