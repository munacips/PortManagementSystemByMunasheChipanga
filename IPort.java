public interface IPort {
    float calculate_distance(float x,float y);
    void incomingShip(Ship s);
    void outgoingShip(Ship s);
}