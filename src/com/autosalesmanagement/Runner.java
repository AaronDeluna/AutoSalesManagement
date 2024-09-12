package com.autosalesmanagement;

import com.autosalesmanagement.cars.cabriolet.Solara;
import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.cars.truck.Dyna;
import com.autosalesmanagement.cars.truck.Hiance;
import com.autosalesmanagement.component.Color;
import com.autosalesmanagement.exceptions.CountyFactoryNotEqualException;
import com.autosalesmanagement.manufacturing.AssemblyLine;
import com.autosalesmanagement.manufacturing.ComponentFactory;
import com.autosalesmanagement.manufacturing.Country;
import com.autosalesmanagement.warehouse.CarType;
import com.autosalesmanagement.warehouse.Warehouse;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        ComponentFactory componentFactory = new ComponentFactory(Country.JAPAN);
        AssemblyLine assemblyLine = new AssemblyLine(Country.JAPAN, componentFactory);
        Warehouse warehouse = new Warehouse();

        try {
            Camry camry = assemblyLine.createCamry(Color.BLACK, new BigDecimal(10_000));
            Solara solara = assemblyLine.createSolara(Color.WHITE, new BigDecimal(12_000));
            Hiance hiance = assemblyLine.createHiance(Color.BLACK, new BigDecimal(15_000));
            Dyna dyna = assemblyLine.createDyna(Color.BLACK, new BigDecimal(22_000));
            warehouse.addCar(CarType.CAMRY, camry);
            warehouse.addCar(CarType.SOLARA, solara);
            warehouse.addCar(CarType.HIANCE, hiance);
            warehouse.addCar(CarType.DYNA, dyna);


            System.out.println(warehouse.takeCar(CarType.DYNA, dyna, assemblyLine).getPrice());
            System.out.println(warehouse.takeCar(CarType.DYNA, dyna, assemblyLine).getPrice());
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }

    }
}
