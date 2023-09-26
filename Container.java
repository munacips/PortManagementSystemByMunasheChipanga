//Author : Munashe Chipanga
public abstract class Container {
    int ID;
    int weight;
    Port current_port;

    public Container(int id, int wei, Port port) {
        this.ID = id;
        this.weight = wei;
        this.current_port = port;
    }

    public abstract double consumption();

    public abstract boolean equals();

    abstract int getWeight();
    abstract int getID();
    abstract char getType();
    abstract Port getCurrent_port();
}
