package com.autosalesmanagement.manufacturing;

import com.autosalesmanagement.cars.cabriolet.Solara;
import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.cars.truck.Dyna;
import com.autosalesmanagement.cars.truck.Hiance;
import com.autosalesmanagement.enums.Color;
import com.autosalesmanagement.enums.Country;
import com.autosalesmanagement.enums.TransmissionType;
import com.autosalesmanagement.enums.WheelDiameter;
import com.autosalesmanagement.exceptions.CountyFactoryNotEqualException;

import java.math.BigDecimal;

/**
 * Класс AssemblyLine представляет сборочный конвейер для автомобилей.
 */
public class AssemblyLine {
    private static final int CAMRY_MAX_SPEED = 240;
    private static final int SOLARA_MAX_SPEED = 200;
    private static final int HIANCE_MAX_SPEED = 180;
    private static final int DYNA_MAX_SPEED = 120;
    private static final int HIANCE_MAX_LOAD_CAPACITY_KG = 1500;
    private static final int DYNA_MAX_LOAD_CAPACITY_KG = 5000;
    private Country country;
    private ComponentFactory componentFactory;

    public AssemblyLine(Country country, ComponentFactory componentFactory) {
        this.country = country;
        this.componentFactory = componentFactory;
    }

    /**
     * Создает экземпляр Camry.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Camry.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Camry createCamry(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Camry(color, CAMRY_MAX_SPEED, TransmissionType.AUTOMATIC,
                    componentFactory.createAllComponents(WheelDiameter.DIAMETER_17_INCHES),
                    price, this.country);
        }
        throw new CountyFactoryNotEqualException(componentFactory.getCountry(), this.country);
    }

    /**
     * Создает экземпляр Solara.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Solara.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Solara createSolara(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Solara(color, SOLARA_MAX_SPEED, TransmissionType.ROBOT,
                    componentFactory.createAllComponents(WheelDiameter.DIAMETER_16_INCHES),
                    price, this.country);
        }
        throw new CountyFactoryNotEqualException(componentFactory.getCountry(), this.country);
    }

    /**
     * Создает экземпляр Hiance.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Hiance.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Hiance createHiance(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Hiance(color, HIANCE_MAX_SPEED, TransmissionType.MANUAL,
                    componentFactory.createAllComponents(WheelDiameter.DIAMETER_20_INCHES),
                    price, this.country, HIANCE_MAX_LOAD_CAPACITY_KG);
        }
        throw new CountyFactoryNotEqualException(componentFactory.getCountry(), this.country);
    }

    /**
     * Создает экземпляр Dyna.
     *
     * @param color цвет автомобиля.
     * @param price цена автомобиля.
     * @return объект Dyna.
     * @throws CountyFactoryNotEqualException если страна производителя компонентов не совпадает со страной сборки.
     */
    public Dyna createDyna(Color color, BigDecimal price) throws CountyFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Dyna(color, DYNA_MAX_SPEED, TransmissionType.MANUAL,
                    componentFactory.createAllComponents(WheelDiameter.DIAMETER_20_INCHES),
                    price, this.country, DYNA_MAX_LOAD_CAPACITY_KG);
        }
        throw new CountyFactoryNotEqualException(componentFactory.getCountry(), this.country);
    }
}
