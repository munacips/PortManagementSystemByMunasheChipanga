//Author : Munashe Chipanga
import java.util.ArrayList;

public class Ship implements Iship {
    int id;
    int maxContainers;
    int maxHeavyContainers;
    int maxRefContainers;
    int maxLiqContainers;
    float fuel_level;
    Port currentPort;
    float maxWeight = 200000F;
    float fuelCapacity = 500000F;
    double fuelConsumption = 5.75F;
    ArrayList<Container> containers = new ArrayList<>();

    public Ship(int id, Port p,int totalWeightCapacity, int maxNumberOfAllContainers, int maxNumberOfAllHeavyContainers, int maxNumberOfRefrigeratedContainers, int maxNumberOfLiquidContainers, double fuelConsumptionPerKm){
        this.id = id;
        this.maxContainers = maxNumberOfAllContainers;
        this.maxHeavyContainers = maxNumberOfAllHeavyContainers;
        this.maxRefContainers = maxNumberOfRefrigeratedContainers;
        this.maxLiqContainers = maxNumberOfLiquidContainers;
        this.currentPort = p;
        this.maxWeight = totalWeightCapacity;
        this.fuelConsumption = fuelConsumptionPerKm;
    }

    public ArrayList<Container> getCurrentContainers(){
        return this.containers;
    }

    @Override
    public boolean sailTo(Port p) {
        if(p==this.currentPort){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reFuel(double newFuel) {
        this.fuel_level+= (float) newFuel;
    }

    @Override
    public boolean unLoad(Container cont) {
        return !containers.contains(cont);
    }

    @Override
    public boolean load(Container cont) {
        return containers.contains(cont);
    }
}
//Author : Munashe Chipanga
