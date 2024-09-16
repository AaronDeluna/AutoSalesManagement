package com.auto_sales_management;

import com.auto_sales_management.cars.CarPrice;
import com.auto_sales_management.cars.cabriolet.Solara;
import com.auto_sales_management.cars.passengercar.Camry;
import com.auto_sales_management.cars.truck.Dyna;
import com.auto_sales_management.cars.truck.Hiance;
import com.auto_sales_management.component.Color;
import com.auto_sales_management.exceptions.CarNotAvailableException;
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
        Customer customer2 = new Customer("Artur", new BigDecimal(20_000));
        Manager manager = new Manager(warehouse, customer1);
        Manager manager2 = new Manager(warehouse, customer2);

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

            System.out.println(manager.salleCar(customer1, assemblyLine).getGasTank());
            System.out.println(manager2.salleCar(customer2, assemblyLine).getGasTank());

        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }
    }
}
