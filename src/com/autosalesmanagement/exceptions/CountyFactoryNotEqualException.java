package com.autosalesmanagement.exceptions;

import com.autosalesmanagement.manufacturing.Country;

public class CountyFactoryNotEqualException extends Exception {
    public CountyFactoryNotEqualException(Country factoryCountry, Country lineCountry) {
        super("Ошибка: не совпадают страны завод находится: " + factoryCountry + " Сборка: " + lineCountry);
    }
}
