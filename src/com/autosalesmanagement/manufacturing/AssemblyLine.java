package com.autosalesmanagement.manufacturing;

import com.autosalesmanagement.cars.cabriolet.Solara;
import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.cars.truck.Dyna;
import com.autosalesmanagement.cars.truck.Hiance;
import com.autosalesmanagement.component.*;
import com.autosalesmanagement.exceptions.CountyFactoryNotEqualException;

import java.math.BigDecimal;

/**
 * Класс AssemblyLine представляет сборочный конвейер для автомобилей.
 */
public class AssemblyLine {
    private static final WheelDiameter CAMRY_WHEELDIAMETER = WheelDiameter.DIAMETER_17_INCHES;
    private static final WheelDiameter SOLARA_WHEELDIAMETER = WheelDiameter.DIAMETER_16_INCHES;
    private static final WheelDiameter HIANCE_WHEELDIAMETER = WheelDiameter.DIAMETER_20_INCHES;
    private static final WheelDiameter DYNA_WHEELDIAMETER = WheelDiameter.DIAMETER_20_INCHES;
    private static final int CAMRY_MAX_SPEED = 240;
    private static final int SOLARA_MAX_SPEED = 200;
    private static final int HIANCE_MAX_SPEED = 180;
    private static final int DYNA_MAX_SPEED = 120;
    private static final int HIANCE_MAX_LOAD_CAPACITY_KG = 1500;
    private static final int DYNA_MAX_LOAD_CAPACITY_KG = 5000;
    private Country country;
    private ComponentFactory componentFactory;
    private GasTank gasTank;
    private Engine engine;
    private Electric electric;
    private Headlights headlights;

    public AssemblyLine(Country country, ComponentFactory componentFactory) {
        this.country = country;
        this.componentFactory = componentFactory;
        gasTank = componentFactory.createGasTank();
        engine = componentFactory.createEngine();
        electric = componentFactory.createElectric();
        headlights = componentFactory.createHeadlights();
    }

    /**
     * Создает экземпляр автомобиля Camry.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Camry.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Camry createCamry(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (!componentFactory.getCountry().equals(country)) {
            throw new CountyFactoryNotEqualException(componentFactory.getCountry(), country);
        }

        Wheel[] wheels = componentFactory.createWheels(CAMRY_WHEELDIAMETER);

        return new Camry(color, CAMRY_MAX_SPEED, TransmissionType.AUTOMATIC, wheels,
                gasTank, engine, electric, headlights, price, Country.JAPAN);
    }

    /**
     * Создает экземпляр автомобиля Solara.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Solara.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Solara createSolara(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (!componentFactory.getCountry().equals(country)) {
            throw new CountyFactoryNotEqualException(componentFactory.getCountry(), country);
        }

        Wheel[] wheels = componentFactory.createWheels(SOLARA_WHEELDIAMETER);

        return new Solara(color, SOLARA_MAX_SPEED, TransmissionType.MANUAL, wheels,
                gasTank, engine, electric, headlights, price, Country.AUSTRALIA);
    }

    /**
     * Создает экземпляр автомобиля Hiance.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Hiance.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Hiance createHiance(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (!componentFactory.getCountry().equals(country)) {
            throw new CountyFactoryNotEqualException(componentFactory.getCountry(), country);
        }

        Wheel[] wheels = componentFactory.createWheels(HIANCE_WHEELDIAMETER);
        Wheel wheel = componentFactory.createWheel(HIANCE_WHEELDIAMETER);

        return new Hiance(color, HIANCE_MAX_SPEED, TransmissionType.MANUAL, wheels, gasTank,
                engine, electric, headlights, price, Country.RUSSIA, HIANCE_MAX_LOAD_CAPACITY_KG, wheel);
    }

    /**
     * Создает экземпляр автомобиля Dyna.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Dyna.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Dyna createDyna(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (!componentFactory.getCountry().equals(country)) {
            throw new CountyFactoryNotEqualException(componentFactory.getCountry(), country);
        }

        Wheel[] wheels = componentFactory.createWheels(DYNA_WHEELDIAMETER);

        return new Dyna(color, DYNA_MAX_SPEED, TransmissionType.MANUAL, wheels, gasTank,
                engine, electric, headlights, price, Country.CHINA, DYNA_MAX_LOAD_CAPACITY_KG);
    }

}
