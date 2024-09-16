package com.auto_sales_management.cars;

import java.math.BigDecimal;

public enum CarPrice {
    CAMRY(BigDecimal.valueOf(10_000)),
    SOLARA(BigDecimal.valueOf(12_000)),
    HIACE(BigDecimal.valueOf(15_000)),
    DYNA(BigDecimal.valueOf(22_000));

    private final BigDecimal price;

    CarPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

