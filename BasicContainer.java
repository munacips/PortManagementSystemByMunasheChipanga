//Author : Munashe Chipanga
public class BasicContainer extends Container {
    private final float fuel_consumption = 2.50F;
    public BasicContainer(int id,int wei){
        super(id,wei);
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

}
