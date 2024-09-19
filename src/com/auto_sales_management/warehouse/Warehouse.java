package com.auto_sales_management.warehouse;

import com.auto_sales_management.cars.Car;
import com.auto_sales_management.exceptions.CarNotAvailableException;

import java.util.*;

public class Warehouse {
    private static final int MAX_CAR_COUNT = 1000;
    private static final String WAREHOUSE_FULL_MESSAGE = "Склад заполнен!";
    private int carCount;
    private Map<CarType, Integer> carTypeCount = new HashMap<>();
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
            carTypeCount.put(carType, carTypeCount.getOrDefault(carType, 0) + 1);
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
            if (!carsList.isEmpty() && carTypeCount.get(carType) >= 0) {
                carCount--;
                carTypeCount.put(carType, carTypeCount.get(carType) - 1);
                return carsList.remove(carsList.size() - 1);
            }
        }
        return null;
    }

    public int getCarTypeCount(CarType carType) throws CarNotAvailableException {
        if (carTypeCount.containsKey(carType)) {
            return carTypeCount.get(carType);
        }
        throw new CarNotAvailableException("Ошибка: нет информации по данному типу машины: " + carType);
    }
}