package com.auto_sales_management.manufacturing;

import com.auto_sales_management.cars.cabriolet.Solara;
import com.auto_sales_management.cars.passengercar.Camry;
import com.auto_sales_management.cars.truck.Dyna;
import com.auto_sales_management.cars.truck.Hiance;
import com.auto_sales_management.component.*;
import com.auto_sales_management.exceptions.CountyFactoryNotEqualException;

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

    public AssemblyLine(Country country, ComponentFactory componentFactory) throws CountyFactoryNotEqualException {
        this.country = country;
        if (!componentFactory.getCountry().equals(country)) {
            throw new CountyFactoryNotEqualException(componentFactory.getCountry(), country);
        }
        this.componentFactory = componentFactory;
    }

    /**
     * Создает экземпляр автомобиля Camry.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Camry.
     */
    public Camry createCamry(Color color, BigDecimal price) {
        Wheel[] wheels = componentFactory.createWheels(CAMRY_WHEELDIAMETER);
        GasTank gasTank = componentFactory.createGasTank();
        Engine engine = componentFactory.createEngine();
        Electric electric = componentFactory.createElectric();
        Headlights headlights = componentFactory.createHeadlights();
        return new Camry(color, CAMRY_MAX_SPEED, TransmissionType.AUTOMATIC, wheels,
                gasTank, engine, electric, headlights, price, country);
    }

    /**
     * Создает экземпляр автомобиля Solara.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Solara.
     */
    public Solara createSolara(Color color, BigDecimal price) {
        Wheel[] wheels = componentFactory.createWheels(SOLARA_WHEELDIAMETER);
        GasTank gasTank = componentFactory.createGasTank();
        Engine engine = componentFactory.createEngine();
        Electric electric = componentFactory.createElectric();
        Headlights headlights = componentFactory.createHeadlights();
        return new Solara(color, SOLARA_MAX_SPEED, TransmissionType.MANUAL, wheels,
                gasTank, engine, electric, headlights, price, country);
    }

    /**
     * Создает экземпляр автомобиля Hiance.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Hiance.
     */
    public Hiance createHiance(Color color, BigDecimal price) {
        Wheel[] wheels = componentFactory.createWheels(HIANCE_WHEELDIAMETER);
        Wheel wheel = componentFactory.createWheel(HIANCE_WHEELDIAMETER);
        GasTank gasTank = componentFactory.createGasTank();
        Engine engine = componentFactory.createEngine();
        Electric electric = componentFactory.createElectric();
        Headlights headlights = componentFactory.createHeadlights();
        return new Hiance(color, HIANCE_MAX_SPEED, TransmissionType.MANUAL, wheels, gasTank,
                engine, electric, headlights, price, country, HIANCE_MAX_LOAD_CAPACITY_KG, wheel);
    }

    /**
     * Создает экземпляр автомобиля Dyna.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Dyna.
     */
    public Dyna createDyna(Color color, BigDecimal price) {
        Wheel[] wheels = componentFactory.createWheels(DYNA_WHEELDIAMETER);
        GasTank gasTank = componentFactory.createGasTank();
        Engine engine = componentFactory.createEngine();
        Electric electric = componentFactory.createElectric();
        Headlights headlights = componentFactory.createHeadlights();
        return new Dyna(color, DYNA_MAX_SPEED, TransmissionType.MANUAL, wheels, gasTank,
                engine, electric, headlights, price, country, DYNA_MAX_LOAD_CAPACITY_KG);
    }
}
