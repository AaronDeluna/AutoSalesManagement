package com.autosalesmanagement;

import com.autosalesmanagement.cars.passengercar.Camry;
import com.autosalesmanagement.component.Color;
import com.autosalesmanagement.exceptions.CountyFactoryNotEqualException;
import com.autosalesmanagement.manufacturing.AssemblyLine;
import com.autosalesmanagement.manufacturing.ComponentFactory;
import com.autosalesmanagement.manufacturing.Country;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        ComponentFactory componentFactory = new ComponentFactory(Country.JAPAN);
        AssemblyLine assemblyLine = new AssemblyLine(Country.JAPAN, componentFactory);

        try {
            Camry camry = assemblyLine.createCamry(Color.RED, new BigDecimal(20000));
            camry.startMoving();
            camry.stopMoving();
            camry.turnOnHeadlights();
            camry.disableCruiseControl();
            camry.enableCruiseControl();
            camry.connectMusic();
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }
    }
}
