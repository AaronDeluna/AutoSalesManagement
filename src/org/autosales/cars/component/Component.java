package org.autosales.cars.component;

/**
 * Компоненты машины
 */
public class Component {
    private int numberOfWheels;
    private int capacity;
    private boolean engineOperational;
    private boolean isElectricsFunctional;
    private boolean isLightsFunctional;

    public Component(int numberOfWheels, int capacity, boolean engineOperational,
                     boolean isElectricsFunctional, boolean areHeadlightsFunctional) {
        this.numberOfWheels = numberOfWheels;
        this.capacity = capacity;
        this.engineOperational = engineOperational;
        this.isElectricsFunctional = isElectricsFunctional;
        this.isLightsFunctional = areHeadlightsFunctional;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEngineOperational() {
        return engineOperational;
    }

    public void setEngineOperational(boolean engineOperational) {
        this.engineOperational = engineOperational;
    }

    public boolean isElectricsFunctional() {
        return isElectricsFunctional;
    }

    public void setElectricsFunctional(boolean electricsFunctional) {
        isElectricsFunctional = electricsFunctional;
    }

    public boolean isLightsFunctional() {
        return isLightsFunctional;
    }

    public void setLightsFunctional(boolean lightsFunctional) {
        isLightsFunctional = lightsFunctional;
    }

    @Override
    public String toString() {
        return "Component{" +
                "numberOfWheels=" + numberOfWheels +
                ", capacity=" + capacity +
                ", engineOperational=" + engineOperational +
                ", isElectricsFunctional=" + isElectricsFunctional +
                ", isLightsFunctional=" + isLightsFunctional +
                '}';
    }
}
