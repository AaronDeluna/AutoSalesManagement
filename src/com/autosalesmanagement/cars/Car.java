package com.autosalesmanagement.cars;

import com.autosalesmanagement.component.*;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.exceptions.StartCarException;

import java.math.BigDecimal;

/**
 * Абстрактный класс Car.
 * Описывает основные характеристики автомобиля.
 */
public abstract class Car {
    protected Color color;
    protected int maxSpeed;
    protected TransmissionType transmissionType;
    protected boolean isMoving;
    protected Wheel[] wheels;
    protected GasTank gasTank;
    protected Engine engine;
    protected Electric electric;
    protected Headlights headlights;
    protected BigDecimal price;
    protected Country country;

    /**
     * Конструктор для создания экземпляра автомобиля.
     *
     * @param color            Цвет автомобиля.
     * @param maxSpeed         Максимальная скорость автомобиля.
     * @param transmissionType Тип трансмиссии (автоматическая или механическая).
     * @param wheels           Массив колес автомобиля.
     * @param gasTank          Топливный бак автомобиля.
     * @param engine           Двигатель автомобиля.
     * @param electric         Электросистема автомобиля.
     * @param headlights       Фары автомобиля.
     * @param price            Цена автомобиля.
     * @param country          Страна-производитель автомобиля.
     */
    public Car(Color color, int maxSpeed, TransmissionType transmissionType,
               Wheel[] wheels, GasTank gasTank, Engine engine,
               Electric electric, Headlights headlights, BigDecimal price, Country country) {
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.transmissionType = transmissionType;
        this.wheels = wheels;
        this.gasTank = gasTank;
        this.engine = engine;
        this.electric = electric;
        this.headlights = headlights;
        this.price = price;
        this.country = country;
    }

    /**
     * Запускает движение автомобиля.
     * Если все компоненты автомобиля исправны, автомобиль начинает движение.
     * В случае неисправности компонента выбрасывается исключение StartCarException.
     */
    public void startMoving() {
        try {
            if (checkAllComponentsWorking()) {
                System.out.println("Машина поехала!");
                this.isMoving = true;
            }
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
            this.isMoving = false;
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
        headlights.setFunctional(true);
    }

    /**
     * Проверяет исправность всех компонентов автомобиля.
     *
     * @return true, если все компоненты исправны.
     * @throws StartCarException если один или несколько компонентов не работают.
     */
    private boolean checkAllComponentsWorking() throws StartCarException {
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

    public void setHeadlights(Headlights headlights) {
        this.headlights = headlights;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
