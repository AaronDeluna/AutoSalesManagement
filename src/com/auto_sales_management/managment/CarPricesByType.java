package com.auto_sales_management.managment;

import java.math.BigDecimal;

public enum CarPricesByType {
    CAMRY(BigDecimal.valueOf(5_000)),
    SOLARA(BigDecimal.valueOf(8_000)),
    HIACE(BigDecimal.valueOf(10_000)),
    DYNA(BigDecimal.valueOf(12_000));

    private final BigDecimal price;

    CarPricesByType(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
