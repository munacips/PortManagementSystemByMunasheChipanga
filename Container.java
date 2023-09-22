//Author : Munashe Chipanga
public abstract class Container {
    int ID;
    int weight;

    public Container(int id, int wei) {
        this.ID = id;
        this.weight = wei;
    }

    public abstract double consumption();

    public abstract boolean equals();

    abstract int getWeight();
    abstract int getID();
    abstract char getType();
}
