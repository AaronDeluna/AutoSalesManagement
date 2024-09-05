package com.autosalesmanagement.cars;

import com.autosalesmanagement.component.Component;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;
import com.autosalesmanagement.exceptions.StartCarException;

/**
 * Абстрактный класс Car.
 * Описывает основные характеристики автомобиля.
 */
public abstract class Car {
    protected Color color;
    protected int maxSpeed;
    protected TransmissionType transmissionType;
    protected boolean isMoving;
    protected Component component;
    protected Country country;

    /**
     * Конструктор автомобиля.
     *
     * @param color цвет автомобиля
     * @param maxSpeed максимальная скорость
     * @param transmissionType тип трансмиссии
     * @param isMoving состояние движения
     * @param component компонент автомобиля
     * @param country страна производства
     */
    public Car(Color color, int maxSpeed,
               TransmissionType transmissionType,
               boolean isMoving, Component component,
               Country country) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.isMoving = isMoving;
        this.component = component;
        this.country = country;
    }

    /**
     * Запускает движение автомобиля.
     * Если все компоненты автомобиля исправны, машина начинает двигаться.
     * В случае проблемы с компонентами выбрасывается исключение StartCarException.
     */
    public void startMoving() {
        try {
            if (component.checkAllComponentsWorking()) {
                System.out.println("Машина поехала!");
                this.isMoving = true;
            }
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Останавливает движение автомобиля.
     * Устанавливает флаг isMoving в false.
     */
    public void stopMoving() {
        System.out.println("Машина оатсановилась!");
        this.isMoving = false;
    }


    public void turnOnHeadlights() {
        System.out.println("Фары включены!");
        component.setHeadlights(true);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
