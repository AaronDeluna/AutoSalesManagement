package com.auto_sales_management.managment;

import com.auto_sales_management.cars.Car;
import com.auto_sales_management.cars.CarPrice;
import com.auto_sales_management.component.Color;
import com.auto_sales_management.exceptions.CarPriceTooLowException;
import com.auto_sales_management.manufacturing.AssemblyLine;
import com.auto_sales_management.warehouse.CarType;
import com.auto_sales_management.warehouse.Warehouse;

import java.math.BigDecimal;
import java.util.*;

public class Manager {
    private static final double NEW_CAR_ASSEMBLY_COST_INCREASE_10_PERCENT = 1.1;
    private Warehouse warehouse;
    private AssemblyLine assemblyLine;

    public Manager(Warehouse warehouse, AssemblyLine assemblyLine) {
        this.warehouse = warehouse;
        this.assemblyLine = assemblyLine;
    }

    /**
     * Продает машину клиенту, проверяя его бюджет и наличие машин на складе.
     *
     * @param customer     клиент, которому продается машина
     * @return объект Car, если машина доступна на складе или успешно создана
     */
    public Car sellCar(Customer customer) throws CarPriceTooLowException {
        return findAffordableCar(customer)
                .orElseThrow(() -> new CarPriceTooLowException("Нет машин по такому бюджету: " + customer.getBudget()));
    }

    /**
     * Находит первый автомобиль, который клиент может себе позволить.
     * Проверяет доступность автомобилей в порядке убывания цен.
     *
     * @param customer клиент, для которого выбирается автомобиль
     * @return Optional, содержащий первый доступный автомобиль, который клиент может себе позволить
     * @throws CarPriceTooLowException если клиент не может позволить себе ни один из доступных автомобилей
     */
    private Optional<Car> findAffordableCar(Customer customer) throws CarPriceTooLowException {
        List<CarPrice> carPriceList = Arrays.asList(CarPrice.values());
        List<CarType> carTypeList = Arrays.asList(CarType.values());
        Collections.reverse(carPriceList);
        Collections.reverse(carTypeList);
        for (int i = 0; i < carPriceList.size(); i++) {
            if (canAffordCar(customer, carPriceList.get(i).getPrice())) {
                return Optional.of(getCarFromWarehouseOrCreateNew(customer, carTypeList.get(i)));
            }
        }
        throw new CarPriceTooLowException("Нет машин по такому бюджету: " + customer.getBudget());
    }

    /**
     * Проверяет, может ли клиент позволить себе автомобиль по указанной цене.
     *
     * @param customer клиент, чей бюджет проверяется
     * @param carPrice цена автомобиля
     * @return true, если бюджет клиента равен или больше цены автомобиля, иначе false
     */
    private boolean canAffordCar(Customer customer, BigDecimal carPrice) {
        return customer.getBudget().compareTo(carPrice) >= 0;
    }

    /**
     * Возвращает автомобиль из склада или создает новый, если его нет на складе.
     * Проверяет, может ли клиент позволить себе автомобиль.
     *
     * @param customer клиент, проверяется его бюджет
     * @param carType тип автомобиля, который требуется
     * @return автомобиль из склада или вновь созданный автомобиль
     * @throws CarPriceTooLowException если клиент не может позволить себе новый автомобиль
     */
    private Car getCarFromWarehouseOrCreateNew(Customer customer, CarType carType) throws CarPriceTooLowException {
        Car car = Optional.ofNullable(warehouse.takeCar(carType))
                .orElseGet(() -> createNewCar(carType));
        if (canAffordCar(customer, car.getPrice())) {
            return car;
        }
        throw new CarPriceTooLowException("Ошибка: Не хватает денег на новую машину!"
                + " Цена машины с учетом сборки: " + car.getPrice() + ", Денег у вас: " + customer.getBudget());
    }

    /**
     * Создает новый автомобиль заданного типа с увеличенной на 10% ценой.
     *
     * @param carType тип автомобиля, который нужно создать
     * @return новый автомобиль соответствующего типа
     * @throws IllegalStateException если тип автомобиля не поддерживается
     */
    private Car createNewCar(CarType carType) {
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
