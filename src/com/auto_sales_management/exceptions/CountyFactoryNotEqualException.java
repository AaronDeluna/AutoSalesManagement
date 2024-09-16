package com.auto_sales_management.exceptions;

import com.auto_sales_management.manufacturing.Country;

public class CountyFactoryNotEqualException extends Exception {
    public CountyFactoryNotEqualException(Country factoryCountry, Country lineCountry) {
        super("Ошибка: не совпадают страны завод находится: " + factoryCountry + " Сборка: " + lineCountry);
    }
}
