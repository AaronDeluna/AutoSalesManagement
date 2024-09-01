package org.autosales.factory;

import org.autosales.cars.models.Camry;
import org.autosales.cars.models.Dyna;
import org.autosales.cars.models.Hiance;
import org.autosales.cars.models.Solara;
import org.autosales.enums.GearboxType;
import org.autosales.exception.CountryFactoryNotEqualException;

/**
 * Конвеер автомобилей, соберает их
 */
public class AssemblyLine {
    private String country;
    private ComponentFactory componentFactory;

    public AssemblyLine(String country) {
        this.country = country;
    }

    public AssemblyLine(String country, ComponentFactory componentFactory) {
        this.country = country;
        this.componentFactory = componentFactory;
    }

    public Camry createCamry() throws CountryFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Camry("Red", 220, GearboxType.AUTOMATIC, false,
                    componentFactory.createComponent(), "Германия", true, true);
        }
        throw new CountryFactoryNotEqualException();
    }


    public Solara createSolara() throws CountryFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Solara("Black", 180, GearboxType.MANUAL, false,
                    componentFactory.createComponent(), "Италия", true, true);
        }
        throw new CountryFactoryNotEqualException();
    }


    public Hiance createHiance() throws CountryFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Hiance("White", 140, GearboxType.MANUAL, false,
                    componentFactory.createComponent(), "Франция", true, 1000);
        }
        throw new CountryFactoryNotEqualException();
    }


    public Dyna createDyna() throws CountryFactoryNotEqualException {
        if (componentFactory.getCountry().equals(country)) {
            return new Dyna("White", 90, GearboxType.MANUAL, false,
                    componentFactory.createComponent(), "Россия", true, 40);
        }
        throw new CountryFactoryNotEqualException();
    }
}
