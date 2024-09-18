package com.auto_sales_management;

import com.auto_sales_management.cars.CarPrice;
import com.auto_sales_management.cars.cabriolet.Solara;
import com.auto_sales_management.cars.passengercar.Camry;
import com.auto_sales_management.cars.truck.Dyna;
import com.auto_sales_management.cars.truck.Hiance;
import com.auto_sales_management.component.Color;
import com.auto_sales_management.exceptions.CarPriceTooLowException;
import com.auto_sales_management.exceptions.CountyFactoryNotEqualException;
import com.auto_sales_management.managment.Customer;
import com.auto_sales_management.managment.Manager;
import com.auto_sales_management.manufacturing.AssemblyLine;
import com.auto_sales_management.manufacturing.ComponentFactory;
import com.auto_sales_management.manufacturing.Country;
import com.auto_sales_management.warehouse.CarType;
import com.auto_sales_management.warehouse.Warehouse;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        ComponentFactory componentFactory = new ComponentFactory(Country.JAPAN);
        Warehouse warehouse = new Warehouse();
        Customer customer1 = new Customer("Artur", new BigDecimal(11_000));
        Customer customer2 = new Customer("Mason", new BigDecimal(10_000));

        try {
            AssemblyLine assemblyLine = new AssemblyLine(Country.JAPAN, componentFactory);
            Camry camry = assemblyLine.createCamry(Color.BLACK, CarPrice.CAMRY.getPrice());
            Solara solara = assemblyLine.createSolara(Color.WHITE, CarPrice.SOLARA.getPrice());
            Hiance hiance = assemblyLine.createHiance(Color.BLACK, CarPrice.HIACE.getPrice());
            Dyna dyna = assemblyLine.createDyna(Color.BLACK, CarPrice.DYNA.getPrice());
            warehouse.addCar(CarType.CAMRY, camry);
            warehouse.addCar(CarType.SOLARA, solara);
            warehouse.addCar(CarType.HIANCE, hiance);
            warehouse.addCar(CarType.DYNA, dyna);


            Manager manager = new Manager(warehouse, assemblyLine);
            try {
                System.out.println(manager.sellCar(customer1));
            } catch (CarPriceTooLowException e) {
                System.out.println(e.getMessage());
            }

            try {
                System.out.println(manager.sellCar(customer2));
            } catch (CarPriceTooLowException e) {
                System.out.println(e.getMessage());
            }

            try {
                System.out.println(manager.sellCar(customer1));
            } catch (CarPriceTooLowException e) {
                System.out.println(e.getMessage());
            }
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }
    }
}
