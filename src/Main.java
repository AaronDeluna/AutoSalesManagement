import org.autosales.cars.models.Car;
import org.autosales.exception.CountryFactoryNotEqualException;
import org.autosales.exception.WarehouseFullException;
import org.autosales.factory.AssemblyLine;
import org.autosales.factory.ComponentFactory;
import org.autosales.management.CarInventoryManager;

public class Main {
    public static void main(String[] args) {
        ComponentFactory componentFactory = new ComponentFactory("Япония");
        AssemblyLine assemblyLine = new AssemblyLine("Япония");
        try {
            Car camry = assemblyLine.createCamry();
            Car dyna = assemblyLine.createDyna();
            CarInventoryManager<Car> carInventoryManager = new CarInventoryManager<>();
            carInventoryManager.addCar(camry);
            carInventoryManager.addCar(dyna);
            System.out.println(carInventoryManager.getCarsList().toString());
        } catch (CountryFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        } catch (WarehouseFullException e) {
            throw new RuntimeException(e);
        }
    }
}