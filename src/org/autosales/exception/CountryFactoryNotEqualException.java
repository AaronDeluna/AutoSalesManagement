package org.autosales.exception;

public class CountryFactoryNotEqualException extends Exception {
    public CountryFactoryNotEqualException() {
        super("Фабрика и конвейер не могут находиться в разных странах.");
    }
}
