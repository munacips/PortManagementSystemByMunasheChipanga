//Author : Munashe Chipanga
import java.util.ArrayList;

public class Port implements IPort {
    private double x_cord;
    private double y_cord;
    private int port_id;
    ArrayList<Ship> history = new ArrayList<>();
    ArrayList<Ship> current = new ArrayList<>();

    public Port(double xcod,double ycod,int portid){
        this.x_cord = xcod;
        this.y_cord = ycod;
        this.port_id = portid;
    }

    @Override
    public float calculate_distance(float x,float y) {
        float x_diff = (float) (this.x_cord - x);
        float y_diff = (float) (this.y_cord - y);
        return (float) Math.pow((x_diff*x_diff + y_diff*y_diff),0.5);
    }

    @Override
    public void outgoingShip(Ship s) {
        history.add(s);
    }

    @Override
    public int getID() {
        return this.port_id;
    }

    @Override
    public double getXCord() {
        return this.x_cord;
    }

    @Override
    public double getYCord() {
        return this.y_cord;
    }

    @Override
    public void incomingShip(Ship s) {
        current.add(s);
    }
}
//Author : Munashe Chipanga