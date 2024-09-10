package com.autosalesmanagement.warehouse;

import com.autosalesmanagement.cars.cabriolet.Cabriolet;
import com.autosalesmanagement.cars.passengercar.PassengerCar;
import com.autosalesmanagement.cars.truck.Truck;

import java.util.*;

public class Warehouse {
    private static final int MAX_CAR_COUNT = 1000;
    private static final String WAREHOUSE_FULL_MESSAGE = "Склад заполнен!";
    private int carCount = 0;

    private List<Cabriolet> cabrioletList = new ArrayList<>();
    private List<PassengerCar> passengerCarList = new ArrayList<>();
    private List<Truck> truckList = new ArrayList<>();

    public Cabriolet getCabriolet(Cabriolet cabriolet) {
        int index = cabrioletList.indexOf(cabriolet);
        if (index >= 0) {
            carCount--;
            return cabrioletList.remove(index);
        }
        return null; //Временная мера по идее должна вернуться машина но только собраная с завода
        // и с ценой на 10% больше чем если она уже бы имелась на складе
    }

    public void addCabriolet(Cabriolet cabriolet) {
        if (carCount < MAX_CAR_COUNT) {
            cabrioletList.add(cabriolet);
            carCount++;
        } else {
            System.out.println(WAREHOUSE_FULL_MESSAGE);
        }
    }

    public PassengerCar getPassengerCar(PassengerCar passengerCar) {
        int index = passengerCarList.indexOf(passengerCar);
        if (index >= 0) {
            carCount--;
            return passengerCarList.remove(index);
        }
        return null; //Временная мера по идее должна вернуться машина но только собраная с завода
        // и с ценой на 10% больше чем если она уже бы имелась на складе
    }

    public void addPassengerCar(PassengerCar passengerCar) {
        if (carCount < MAX_CAR_COUNT) {
            passengerCarList.add(passengerCar);
            carCount++;
        } else {
            System.out.println(WAREHOUSE_FULL_MESSAGE);
        }
    }

    public Truck getTruckList(Truck truck) {
        int index = truckList.indexOf(truck);
        if (index >= 0) {
            carCount--;
            return truckList.remove(index);
        }
        return null;
    }

    public void addTruckCar(Truck truck) {
        if (carCount < MAX_CAR_COUNT) {
            truckList.add(truck);
            carCount++;
        } else {
            System.out.println(WAREHOUSE_FULL_MESSAGE);
        }
    }

    public void showCarCountCabriolet() {
        System.out.println("Кабриолетов на складе: " + cabrioletList.size());
    }

    public void showCarCountPassengerCar() {
        System.out.println("Легковых машин на складе: " + passengerCarList.size());
    }

    public void showCarCountTruck() {
        System.out.println("Грузовых машин на складе: " + truckList.size());
    }
}
