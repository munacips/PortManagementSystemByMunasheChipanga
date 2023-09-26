//Author : Munashe Chipanga
public class HeavyContainer extends Container{
    private double fuel_consumption = 3.0F;

    public HeavyContainer(int id, int wei, Port port) {
        super(id, wei, port);
    }

    @Override
    public double consumption() {
        return this.fuel_consumption;
    }

    @Override
    public boolean equals() {
        return false;
    }

    @Override
    int getWeight() {
        return this.weight;
    }

    @Override
    int getID() {
        return this.ID;
    }

    @Override
    char getType() {
        return 'H';
    }

    @Override
    Port getCurrent_port() {
        return this.current_port;
    }

    void setFuel_consumption(double fuel_consumption){
        this.fuel_consumption = fuel_consumption;
    }

}
