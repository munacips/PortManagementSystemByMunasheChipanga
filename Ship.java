//Author : Munashe Chipanga
import java.util.ArrayList;

public class Ship implements Iship {
    private final int id;
    private final int maxContainers;
    private final int maxHeavyContainers;
    private final int maxRefContainers;
    private final int maxLiqContainers;
    private float fuel_level;
    private Port currentPort;
    private float maxWeight = 200000F; // questionable
    private final float fuelCapacity = 500000F;
    private double fuelConsumption = 5.75F;
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
        return p == this.currentPort;
    }

    @Override
    public void reFuel(double newFuel) {
        this.fuel_level += (float) newFuel;
    }

    @Override
    public boolean unLoad(Container cont) {
        return !containers.contains(cont);
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public int getMaxContainers() {
        return this.maxContainers;
    }

    @Override
    public int getMaxHeavyContainers() {
        return this.maxHeavyContainers;
    }

    @Override
    public int getMaxRefContainers() {
        return this.maxRefContainers;
    }

    @Override
    public int getLiqContainers() {
        return this.maxLiqContainers;
    }

    @Override
    public float getFuel_level() {
        return this.fuel_level;
    }

    @Override
    public Port getCurrentPort() {
        return this.currentPort;
    }

    @Override
    public float getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public float getFuelCapacity() {
        return this.fuelCapacity;
    }

    @Override
    public double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public void setCurrentPort(Port p) {
        this.currentPort = p;
    }

    @Override
    public boolean load(Container cont) {
        return containers.contains(cont);
    }

    public boolean maxRefReached(){
        int count = 0;
        for(Container c:this.containers){
            if(c.getType()=='R'){
                count+=1;
            }
        }
        return count >= this.maxRefContainers;
    }
    public boolean maxLiqReached(){
        int count = 0;
        for(Container c:this.containers){
            if(c.getType()=='L'){
                count+=1;
            }
        }
        return count >= this.maxLiqContainers;
    }
    public boolean maxHeaReached(){
        int count = 0;
        for(Container c:this.containers){
            if(c.getType()=='H'){
                count+=1;
            }
        }
        return count >= this.maxHeavyContainers;
    }
    public boolean maxContainers(){
        int count = 0;
        for(Container c:this.containers){
            if(c.getType()=='B'){
                count+=1;
            }
        }
        return  count >= this.maxContainers;
    }
}
//Author : Munashe Chipanga
