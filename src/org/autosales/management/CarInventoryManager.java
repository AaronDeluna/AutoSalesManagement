package org.autosales.management;

import org.autosales.cars.models.Car;
import org.autosales.exception.WarehouseFullException;

import java.util.ArrayList;
import java.util.List;

public class CarInventoryManager<T extends Car> {
    private static final String WAREHOUSE_FULL_MESSAGE = "На складе не осталось места";
    private static final int CAR_QUANTITY_CHANGE = 1;
    private static final int INVALID_AVAILABLE_SEATS = 0;
    private int availableSeats = 100;
    private List<T> carsList = new ArrayList<>();

    /**
     * Добавляем Cars в список.
     *
     * @param car объект который, нужно добавить в список
     */
    public void addCar(T car) throws WarehouseFullException {
        if (availableSeats > INVALID_AVAILABLE_SEATS) {
            carsList.add(car);
            availableSeats--;
            car.setQuantity(car.getQuantity() + CAR_QUANTITY_CHANGE);
        } else {
            throw new WarehouseFullException(WAREHOUSE_FULL_MESSAGE);
        }
    }

    /**
     * Удалить Car.
     *
     * @param car передаем объект который, нужно удалить
     * @return после отработки вернет удаленный объект обратно
     */
    public T removeCar(T car) {
        int index = carsList.indexOf(car);
        availableSeats++;
        car.setQuantity(car.getQuantity() - CAR_QUANTITY_CHANGE);
        return carsList.remove(index);
    }

    public List<T> getCarsList() {
        return carsList;
    }
}
