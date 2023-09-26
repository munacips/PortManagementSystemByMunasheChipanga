//Author : Munashe Chipanga
public class BasicContainer extends Container {
    private final float fuel_consumption = 2.50F;
    char type = 'B';
    public BasicContainer(int id, int wei, Port port){
        super(id,wei,port);
    }

    @Override
    public double consumption() {
        return 0;
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
        return this.type;
    }

    @Override
    Port getCurrent_port() {
        return this.current_port;
    }
}
