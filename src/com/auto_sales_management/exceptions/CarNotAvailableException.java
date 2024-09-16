package com.auto_sales_management.exceptions;

public class CarNotAvailableException extends Exception {
    public CarNotAvailableException(String message) {
        super(message);
    }
}
