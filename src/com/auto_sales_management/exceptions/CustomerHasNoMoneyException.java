package com.auto_sales_management.exceptions;

public class CustomerHasNoMoneyException extends Exception {
    public CustomerHasNoMoneyException(String message) {
        super(message);
    }
}
