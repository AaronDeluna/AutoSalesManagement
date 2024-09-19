package com.auto_sales_management.managment;

import com.auto_sales_management.warehouse.CarType;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private String name;
    private List<CarType> saleCars = new ArrayList<>();

    public void addSaleCars(String name, CarType carType) {
        this.name = name;
        saleCars.add(carType);
    }

    public List<CarType> getSaleCars() {
        return saleCars;
    }

    @Override
    public String toString() {
        return "Report{" +
                "name='" + name + '\'' +
                ", saleCars=" + saleCars +
                '}';
    }
}
