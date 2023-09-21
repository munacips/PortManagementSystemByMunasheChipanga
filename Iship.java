//Author : Munashe Chipanga
public interface Iship {
    boolean sailTo(Port p);
    void reFuel(double newFuel);
    boolean load(Container cont);
    boolean unLoad(Container cont);
}
