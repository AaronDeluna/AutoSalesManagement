package com.auto_sales_management.managment;

import com.auto_sales_management.cars.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cashier {
    List<BigDecimal> incomeList = new ArrayList<>();

    /**
     * Обрабатывает заказ автомобиля и записывает доход от продажи в список доходов.
     *
     * @param car объект класса {@link Car}, представляющий проданный автомобиль.
     */
    public void processOrderAndRecordIncome(Car car) {
        incomeList.add(car.getPrice());
    }

    public List<BigDecimal> getIncomeList() {
        return incomeList;
    }
}
