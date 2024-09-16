package com.auto_sales_management.managment;

import com.auto_sales_management.cars.Car;
import com.auto_sales_management.cars.CarPrice;
import com.auto_sales_management.component.Color;
import com.auto_sales_management.exceptions.CarNotAvailableException;
import com.auto_sales_management.manufacturing.AssemblyLine;
import com.auto_sales_management.warehouse.CarType;
import com.auto_sales_management.warehouse.Warehouse;

import java.math.BigDecimal;
public class Manager {
    private static final double NEW_CAR_ASSEMBLY_COST_INCREASE_10_PERCENT = 1.1;
    private Warehouse warehouse;
    private Customer customer;

    public Manager(Warehouse warehouse ,Customer customer) {
        this.warehouse = warehouse;
        this.customer = customer;
    }

    public Car salleCar(Customer customer, AssemblyLine assemblyLine) {
        BigDecimal customerBudget = customer.getBudget();

        if (customerBudget.compareTo(CarPrice.HIACE.getPrice()) >= 0) {
            return warehouse.takeCar(CarType.HIANCE);
        } else if (customerBudget.compareTo(CarPrice.SOLARA.getPrice()) >= 0) {
            return warehouse.takeCar(CarType.SOLARA);
        } else if (customerBudget.compareTo(CarPrice.CAMRY.getPrice()) >= 0) {
            return warehouse.takeCar(CarType.CAMRY);
        } else {
            // Если ни одна из выше перечисленных машин не подходит, то вернуть машину по умолчанию
            return warehouse.takeCar(CarType.DYNA);
        }
    }



    /**
     * Создает новый автомобиль указанного типа на сборочной линии и добавляет его в хранилище.
     *
     * @param carType      тип создаваемого автомобиля
     * @param assemblyLine сборочная линия, на которой создается автомобиль
     * @return новый автомобиль
     * @throws IllegalStateException если передан неподдерживаемый тип автомобиля
     */
    private Car createNewCar(CarType carType, AssemblyLine assemblyLine) {
        switch (carType) {
            case CAMRY -> {
                return assemblyLine.createCamry(Color.BLACK, addPercentageToNewCar(CarPrice.CAMRY.getPrice()));
            }
            case SOLARA -> {
                return assemblyLine.createSolara(Color.WHITE, addPercentageToNewCar(CarPrice.SOLARA.getPrice()));
            }
            case HIANCE -> {
                return assemblyLine.createHiance(Color.BLACK, addPercentageToNewCar(CarPrice.HIACE.getPrice()));
            }
            case DYNA -> {
                return assemblyLine.createDyna(Color.BLACK, addPercentageToNewCar(CarPrice.DYNA.getPrice()));
            }
            default -> throw new IllegalStateException("Unexpected value: " + carType);
        }
    }

    /**
     * Увеличивает цену нового автомобиля на 10%.
     *
     * @param price исходная цена автомобиля
     * @return новая цена автомобиля с учетом увеличения на 10%
     */
    private BigDecimal addPercentageToNewCar(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(NEW_CAR_ASSEMBLY_COST_INCREASE_10_PERCENT));
    }
}
