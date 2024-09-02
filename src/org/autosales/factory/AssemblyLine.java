package org.autosales.factory;

import org.autosales.cars.models.Camry;
import org.autosales.cars.models.Dyna;
import org.autosales.cars.models.Hiance;
import org.autosales.cars.models.Solara;
import org.autosales.enums.GearboxType;
import org.autosales.exception.CountryFactoryNotEqualException;

/**
 * Конвеер автомобилей, собирает их.
 */
public class AssemblyLine {
    private static final boolean IS_IN_MOTION = false;
    /**
     * Данные для Camry.
     */
    private static final String CAMRY_COMPONENT_FACTORY_COUNTRY = "Япония";
    private static final String CAMRY_COUNTRY = "Япония";
    private static final String CAMRY_COLOR = "Красный";
    private static final int CAMRY_MAX_SPEED = 220;
    private static final boolean CAMRY_CRUISE_CONTROL = true;
    private static final boolean CAMRY_AVAILABILITY_USB = true;

    /**
     * Данные для Solar.
     */
    private static final String SOLAR_COMPONENT_FACTORY_COUNTRY = "Италия";
    private static final String SOLAR_COUNTRY = "Италия";
    private static final String SOLAR_COLOR = "Черный";
    private static final int SOLAR_MAX_SPEED = 180;
    private static final boolean SOLAR_ROOF_ENABLE = true;
    private static final boolean SOLAR_MINI_FRIDGE = true;

    /**
     * Данные для Hiance.
     */
    private static final String HIANCE_COMPONENT_FACTORY_COUNTRY = "Франция";
    private static final String HIANCE_COUNTRY = "Франция";
    private static final String HIANCE_COLOR = "Белый";
    private static final int HIANCE_MAX_SPEED = 140;
    private static final boolean HIANCE_SPARE_TIRE = true;
    private static final int HIANCE_LOAD_CAPACITY = 1000;

    /**
     * Данные для Dyna.
     */
    private static final String DYNA_COMPONENT_FACTORY_COUNTRY = "Россия";
    private static final String DYNA_COUNTRY = "Россия";
    private static final String DYNA_COLOR = "Серый";
    private static final int DYNA_MAX_SPEED = 90;
    private static final boolean DYNA_POWER_OUTLET = true;
    private static final int DYNA_LOAD_CAPACITY = 1280;

    private String country;

    public AssemblyLine(String country) {
        this.country = country;
    }

    public Camry createCamry() throws CountryFactoryNotEqualException {
        ComponentFactory componentFactory = new ComponentFactory(CAMRY_COMPONENT_FACTORY_COUNTRY);
        if (componentFactory.getCountry().equals(country)) {
            return new Camry(CAMRY_COLOR, CAMRY_MAX_SPEED, GearboxType.AUTOMATIC, IS_IN_MOTION,
                    componentFactory.createComponent(), CAMRY_COUNTRY, CAMRY_CRUISE_CONTROL, CAMRY_AVAILABILITY_USB);
        }
        throw new CountryFactoryNotEqualException();
    }


    public Solara createSolar() throws CountryFactoryNotEqualException {
        ComponentFactory componentFactory = new ComponentFactory(SOLAR_COMPONENT_FACTORY_COUNTRY);
        if (componentFactory.getCountry().equals(country)) {
            return new Solara(SOLAR_COLOR, SOLAR_MAX_SPEED, GearboxType.MANUAL, IS_IN_MOTION,
                    componentFactory.createComponent(), SOLAR_COUNTRY, SOLAR_ROOF_ENABLE, SOLAR_MINI_FRIDGE);
        }
        throw new CountryFactoryNotEqualException();
    }

    public Hiance createHiance() throws CountryFactoryNotEqualException {
        ComponentFactory componentFactory = new ComponentFactory(HIANCE_COMPONENT_FACTORY_COUNTRY);
        if (componentFactory.getCountry().equals(country)) {
            return new Hiance(HIANCE_COLOR, HIANCE_MAX_SPEED, GearboxType.MANUAL, IS_IN_MOTION,
                    componentFactory.createComponent(), HIANCE_COUNTRY, HIANCE_SPARE_TIRE, HIANCE_LOAD_CAPACITY);
        }
        throw new CountryFactoryNotEqualException();
    }


    public Dyna createDyna() throws CountryFactoryNotEqualException {
        ComponentFactory componentFactory = new ComponentFactory(DYNA_COMPONENT_FACTORY_COUNTRY);
        if (componentFactory.getCountry().equals(country)) {
            return new Dyna(DYNA_COLOR, DYNA_MAX_SPEED, GearboxType.MANUAL, IS_IN_MOTION,
                    componentFactory.createComponent(), DYNA_COUNTRY, DYNA_POWER_OUTLET, DYNA_LOAD_CAPACITY);
        }
        throw new CountryFactoryNotEqualException();
    }
}
