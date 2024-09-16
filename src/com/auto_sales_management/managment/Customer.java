package com.auto_sales_management.managment;

import java.math.BigDecimal;

public class Customer {
    private String name;
    private BigDecimal budget;

    public Customer(String name, BigDecimal budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
