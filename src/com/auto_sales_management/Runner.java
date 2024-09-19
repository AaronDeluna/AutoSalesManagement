package com.auto_sales_management;

import com.auto_sales_management.cars.CarPrice;
import com.auto_sales_management.cars.cabriolet.Solara;
import com.auto_sales_management.cars.passengercar.Camry;
import com.auto_sales_management.cars.truck.Dyna;
import com.auto_sales_management.cars.truck.Hiance;
import com.auto_sales_management.component.Color;
import com.auto_sales_management.exceptions.CarNotAvailableException;
import com.auto_sales_management.exceptions.CarPriceTooLowException;
import com.auto_sales_management.exceptions.CountyFactoryNotEqualException;
import com.auto_sales_management.managment.Cashier;
import com.auto_sales_management.managment.Customer;
import com.auto_sales_management.managment.Manager;
import com.auto_sales_management.managment.Report;
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

            Manager manager = new Manager("Олег", warehouse, assemblyLine);
            Cashier cashier = new Cashier();

            simulateCustomerArrival(cashier, manager);

            manager.generateReport();
            try {
                System.out.println(warehouse.getCarTypeCount(CarType.CAMRY));
            } catch (CarNotAvailableException e) {
                System.out.println(e.getMessage());
            }

        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Симулирует прибытие клиентов, обработку их заказов и запись доходов кассиром.
     *
     * @param cashier объект {@link Cashier}, отвечающий за обработку заказов.
     * @param manager объект {@link Manager}, отвечающий за продажу автомобилей клиентам.
     */
    private static void simulateCustomerArrival(Cashier cashier, Manager manager) {
        Customer[] customers = initCustomerArray();
        for (Customer customer : customers) {
            try {
                cashier.processOrderAndRecordIncome(manager.sellCar(customer));
            } catch (CarPriceTooLowException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Инициализирует массив клиентов с заданными именами и бюджетами.
     *
     * @return массив объектов {@link Customer}, каждый из которых имеет имя и бюджет.
     */
    private static Customer[] initCustomerArray() {
        return new Customer[] {
                new Customer("Artur", new BigDecimal(10_000)),
                new Customer("Mason", new BigDecimal(12_000)),
                new Customer("Anton", new BigDecimal(15_000)),
                new Customer("Gena", new BigDecimal(22_000)),
                new Customer("Mara", new BigDecimal(11_000)),
                new Customer("Mustafa", new BigDecimal(13_200)),
                new Customer("Ppd", new BigDecimal(8_000)),
                new Customer("Goga", new BigDecimal(30_000)),
        };
    }
}
