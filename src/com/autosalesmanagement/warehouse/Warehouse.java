package com.autosalesmanagement.warehouse;

import com.autosalesmanagement.cars.Car;
import com.autosalesmanagement.exceptions.CountyFactoryNotEqualException;
import com.autosalesmanagement.manufacturing.AssemblyLine;

import java.math.BigDecimal;
import java.util.*;

public class Warehouse {
    private static final int MAX_CAR_COUNT = 1000;
    private static final String WAREHOUSE_FULL_MESSAGE = "Склад заполнен!";
    private static final double NEW_CAR_ASSEMBLY_COST_INCREASE_10_PERCENT = 1.1;
    private int carCount;

    private Map<CarType, ArrayList<Car>> carStorage = new HashMap<>();

    /**
     * Добавляет автомобиль в хранилище по указанному типу, если не превышен лимит.
     *
     * @param carType тип автомобиля для хранения
     * @param car автомобиль для добавления
     */
    public void addCar(CarType carType, Car car) {
        if (carCount < MAX_CAR_COUNT) {
            ArrayList<Car> carList = carStorage.computeIfAbsent(carType, k -> new ArrayList<>());
            carList.add(car);
            carCount++;
        } else {
            System.out.println(WAREHOUSE_FULL_MESSAGE);
        }
    }

    /**
     * Возвращает автомобиль указанного типа из хранилища или создает новый, если хранилище пустое.
     *
     * @param carType тип автомобиля для получения
     * @param car автомобиль для создания, если в хранилище нет доступных машин
     * @param assemblyLine сборочная линия для создания нового автомобиля
     * @return автомобиль из хранилища или новый автомобиль, созданный на сборочной линии
     * @throws RuntimeException если возникла ошибка при создании автомобиля (CountyFactoryNotEqualException)
     */
    public Car takeCar(CarType carType, Car car, AssemblyLine assemblyLine) {
        if (carStorage.containsKey(carType)) {
            ArrayList<Car> carsList = carStorage.get(carType);
            if (carsList != null && !carsList.isEmpty()) {
                return carsList.remove(carsList.size() - 1);
            }
        }

        try {
            return createNewCar(carType, car, assemblyLine);
        } catch (CountyFactoryNotEqualException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Создает новый автомобиль указанного типа на сборочной линии и добавляет его в хранилище.
     *
     * @param carType тип создаваемого автомобиля
     * @param car автомобиль с параметрами (цвет, цена) для создания нового автомобиля
     * @param assemblyLine сборочная линия, на которой создается автомобиль
     * @return новый автомобиль
     * @throws CountyFactoryNotEqualException если возникла ошибка при создании автомобиля
     * @throws IllegalStateException если передан неподдерживаемый тип автомобиля
     */
    public Car createNewCar(CarType carType, Car car, AssemblyLine assemblyLine) throws CountyFactoryNotEqualException {
        Car newCar;
        switch (carType) {
            case CAMRY -> {
                newCar = assemblyLine.createCamry(car.getColor(), addPercentageToNewCar(car.getPrice()));
                addCar(carType, newCar);
            }
            case SOLARA -> {
                newCar = assemblyLine.createSolara(car.getColor(), addPercentageToNewCar(car.getPrice()));
                addCar(carType, newCar);
            }
            case HIANCE -> {
                newCar = assemblyLine.createHiance(car.getColor(), addPercentageToNewCar(car.getPrice()));
                addCar(carType, newCar);
            }
            case DYNA -> {
                newCar = assemblyLine.createDyna(car.getColor(), addPercentageToNewCar(car.getPrice()));
                addCar(carType, newCar);
            }
            default -> throw new IllegalStateException("Unexpected value: " + carType);
        }
        return newCar;
    }

    /**
     * Увеличивает цену нового автомобиля на 10%.
     *
     * @param price исходная цена автомобиля
     * @return новая цена автомобиля с учетом увеличения на 10%
     */
    private BigDecimal addPercentageToNewCar(BigDecimal price) {
        return price.multiply(BigDecimal.valueOf(1.1));
    }
}