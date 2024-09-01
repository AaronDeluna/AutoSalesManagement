package org.autosales.enums;

/**
 * Коробка передач
 */
public enum GearboxType {
    MANUAL("Механика"),
    AUTOMATIC("Автомат");

    private String name;

    GearboxType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


