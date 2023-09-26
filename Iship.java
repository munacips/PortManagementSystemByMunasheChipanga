//Author : Munashe Chipanga
public interface Iship {
    boolean sailTo(Port p);
    void reFuel(double newFuel);
    boolean load(Container cont);
    boolean unLoad(Container cont);
    int getID();
    int getMaxContainers();
    int getMaxHeavyContainers();
    int getMaxRefContainers();
    int getLiqContainers();
    float getFuel_level();
    Port getCurrentPort();
    float getMaxWeight();
    float getFuelCapacity();
    double getFuelConsumption();
    void setCurrentPort(Port p);

}
