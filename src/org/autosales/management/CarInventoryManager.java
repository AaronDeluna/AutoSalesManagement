package org.autosales.management;

import org.autosales.cars.models.Camry;
import org.autosales.cars.models.Dyna;
import org.autosales.cars.models.Hiance;
import org.autosales.cars.models.Solara;
import org.autosales.exception.WarehouseFullException;

import java.util.ArrayList;
import java.util.List;

/**
 * Менеджер по инвентаризации автомобилей
 */
public class CarInventoryManager {
    private int camryQuantity = 0;
    private int dynaQuantity = 0;
    private int hianceQuantity = 0;
    private int solaraQuantity = 0;
    private int availableSeats = 100;
    private List<Camry> camryList = new ArrayList<>();
    private List<Dyna> dynaList = new ArrayList<>();
    private List<Hiance> hianceList = new ArrayList<>();
    private List<Solara> solaraList = new ArrayList<>();

    private static final String WAREHOUSE_FULL_MESSAGE = "На складе не осталось места";

    /**
     * Добавляем Camry в список
     */
    public void addCamry(Camry camry) throws WarehouseFullException {
        if (availableSeats > 0) {
            camryList.add(camry);
            availableSeats--;
            camryQuantity++;
        } else {
            throw new WarehouseFullException(WAREHOUSE_FULL_MESSAGE);
        }
    }

    /**
     * Удалить Camry
     */
    public Camry removeCamry(Camry camry) {
        int index = camryList.indexOf(camry);
        availableSeats++;
        camryQuantity--;
        return camryList.remove(index);
    }

    /**
     * Добавляем Dyna в список
     */
    public void addDyna(Dyna dyna) throws WarehouseFullException {
        if (availableSeats > 0) {
            dynaList.add(dyna);
            availableSeats--;
            dynaQuantity++;
        } else {
            throw new WarehouseFullException(WAREHOUSE_FULL_MESSAGE);
        }
    }

    /**
     * Удалить Dyna
     */
    public Dyna removeDyna(Dyna dyna) {
        int index = dynaList.indexOf(dyna);
        availableSeats++;
        dynaQuantity--;
        return dynaList.remove(index);
    }

    /**
     * Добавляем Hiance в список
     */
    public void addHiance(Hiance hiance) throws WarehouseFullException {
        if (availableSeats > 0) {
            hianceList.add(hiance);
            availableSeats--;
            hianceQuantity++;
        } else {
            throw new WarehouseFullException(WAREHOUSE_FULL_MESSAGE);
        }
    }

    /**
     * Удалить Hiance
     */
    public Hiance removeHiance(Hiance hiance) {
        int index = hianceList.indexOf(hiance);
        availableSeats++;
        hianceQuantity--;
        return hianceList.remove(index);
    }

    /**
     * Добавляем Solara в список
     */
    public void addSolara(Solara solara) throws WarehouseFullException {
        if (availableSeats > 0) {
            solaraList.add(solara);
            availableSeats--;
            solaraQuantity++;
        } else {
            throw new WarehouseFullException(WAREHOUSE_FULL_MESSAGE);
        }
    }

    /**
     * Удалить Solara
     */
    public Solara removeSolara(Solara solara) {
        int index = solaraList.indexOf(solara);
        availableSeats++;
        solaraQuantity--;
        return solaraList.remove(index);
    }

    public int getCamryQuantity() {
        return camryQuantity;
    }

    public int getDynaQuantity() {
        return dynaQuantity;
    }

    public int getHianceQuantity() {
        return hianceQuantity;
    }

    public int getSolaraQuantity() {
        return solaraQuantity;
    }

}
