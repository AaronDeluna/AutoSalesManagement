package com.auto_sales_management.managment;

import com.auto_sales_management.cars.Car;
import com.auto_sales_management.warehouse.CarType;

import java.math.BigDecimal;

public class Report {
    private String name;
    private BigDecimal sallePrise;
    private CarType salesCarType;
    private BigDecimal costPrice;

    public Report(String name, BigDecimal sallePrise, CarType salesCarType, BigDecimal costPrice) {
        this.name = name;
        this.sallePrise = sallePrise;
        this.salesCarType = salesCarType;
        this.costPrice = costPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSallePrise() {
        return sallePrise;
    }

    public void setSallePrise(BigDecimal sallePrise) {
        this.sallePrise = sallePrise;
    }

    public CarType getSalesCarType() {
        return salesCarType;
    }

    public void setSalesCarType(CarType salesCarType) {
        this.salesCarType = salesCarType;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}
