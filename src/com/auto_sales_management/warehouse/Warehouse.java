package com.auto_sales_management.warehouse;

import com.auto_sales_management.cars.Car;

import java.util.*;

public class Warehouse {
    private static final int MAX_CAR_COUNT = 1000;
    private static final String WAREHOUSE_FULL_MESSAGE = "Склад заполнен!";
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
     * Извлекает автомобиль указанного типа из хранилища.
     *
     * @param carType тип автомобиля для извлечения
     * @return автомобиль указанного типа
     * @return null если нет доступных автомобилей указанного типа
     */
    public Car takeCar(CarType carType) {
        if (carStorage.containsKey(carType)) {
            ArrayList<Car> carsList = carStorage.get(carType);
            if (!carsList.isEmpty()) {
                carCount--;
                return carsList.remove(carsList.size() - 1);
            }
        }
        return null;
    }
}