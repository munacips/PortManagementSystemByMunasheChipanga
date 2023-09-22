//Author : Munashe Chipanga

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Container> AllContainers = new ArrayList<>();
    public static List<Ship> AllShips = new ArrayList<>();
    public static List<Port> AllPorts = new ArrayList<>();

    public static boolean ship_id_exist(int id){
        for(Ship s:AllShips){
            if(s.id==id){
                return true;
            }
        }
        return false;
    }
    public static boolean port_id_exist(int id){
        for(Port p:AllPorts){
            if(p.port_id==id){
                return true;
            }
        }
        return false;
    }
    public static boolean container_id_exist(int id){
        for(Container c:AllContainers){
            if(c.getID()==id){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        boolean quit = false;
        while(!quit){
            System.out.println();
            System.out.println("Menu : Choose an option.");
            System.out.println("1 : Create a container");
            System.out.println("2 : Create a ship");
            System.out.println("3 : Create a port");
            System.out.println("4 : Load a container to a ship");
            System.out.println("5 : Unload a container from a ship");
            System.out.println("6 : Sail ship to another port");
            System.out.println("7 : Refuel ship");
            System.out.println("8 : Press 8 to quit");
            System.out.print("Input : ");

            Scanner scan = new Scanner(System.in);
            byte option = scan.nextByte();

            switch (option){
                case 1 -> {
                    boolean created = false;
                    System.out.print("Enter the weight of the container : ");
                    int weight = scan.nextInt();
                    if(weight<5000){
                        System.out.print("Enter the ID of the ship : ");
                        int id = scan.nextInt();
                        if(container_id_exist(id)){
                            System.out.println("ID already exists");
                            System.out.println("-------------------------------------------------------------------------------------------");
                        } else {
                            AllContainers.add(new BasicContainer(id,weight));
                            System.out.print("Created !");
                            System.out.println("-------------------------------------------------------------------------------------------");
                            created = true;
                        }
                    } else {
                        System.out.println("Is it a refrigerated container(R) or a liquid container(L) : ");
                        char type = scan.next().charAt(0);
                        if(type=='R'){
                            System.out.print("Enter the ID of the container : ");
                            int id = scan.nextInt();
                            AllContainers.add(new RefrigeratedContainer(id,weight));
                            System.out.print("Created !");
                            System.out.println("-------------------------------------------------------------------------------------------");
                            created = true;
                        } else if (type=='L') {
                            System.out.print("Enter the ID of the ship : ");
                            int id = scan.nextInt();
                            AllContainers.add(new LiquidContainer(id,weight));
                            System.out.print("Created !");
                            System.out.println("-------------------------------------------------------------------------------------------");
                            created = true;
                        }
                    }
                    if(!created){
                        System.out.print("Not created! Error occurred ");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 2 -> {
                    Port port = null;
                    System.out.print("Enter the id of the ship : ");
                    int id = scan.nextInt();
                    if(ship_id_exist(id)){
                        System.out.println("ID already exists");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    } else {
                        System.out.print("Enter the weight capacity of the ship : ");
                        int weight_capacity = scan.nextInt();
                        System.out.print("Enter the id of the port : ");
                        int port_id = scan.nextInt();
                        for(Port p:AllPorts){
                            if (port_id==p.port_id){
                                port = p;
                                break;
                            }
                        }
                        if(port==null){
                            System.out.print("No valid port was entered");
                            System.out.println("-------------------------------------------------------------------------------------------");
                            //RESTART
                        }
                        System.out.print("Enter the maximum number of containers in the ship : ");
                        int cont_num = scan.nextInt();
                        System.out.print("Enter the number of heavy containers in the ship : ");
                        int h_num = scan.nextInt();
                        System.out.print("Enter the number of refrigerated containers in the ship : ");
                        int r_num = scan.nextInt();
                        System.out.print("Enter the number of liquid containers in the ship : ");
                        int l_num = scan.nextInt();
                        System.out.print("Enter the fuel consumption of the ship : ");
                        double fuel_consumption = scan.nextDouble();

                        AllShips.add(new Ship(id,port,weight_capacity,cont_num,h_num,r_num,l_num,fuel_consumption));
                        System.out.print("Created !");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 3 -> {
                    System.out.print("Enter the x coordinate : ");
                    float x = scan.nextFloat();
                    System.out.print("Enter the y coordinate : ");
                    float y = scan.nextFloat();
                    System.out.print("Enter the port id : ");
                    int id = scan.nextInt();
                    if(port_id_exist(id)){
                        System.out.println("ID already in use");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    } else {
                        AllPorts.add(new Port(x,y,id));
                        System.out.print("Created !");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 4 -> {
                    boolean loaded = false;
                    System.out.print("Enter the id of the container : ");
                    int cont_id = scan.nextInt();
                    System.out.print("Enter the id of the Ship : ");
                    int ship_id = scan.nextInt();
                    for(Container c:AllContainers){
                        if(c.getID()==cont_id){
                            for(Ship s:AllShips){
                                if(s.id==ship_id){
                                    if(s.containers.contains(c)){
                                        System.out.print("Already in ");
                                    } else {
                                        int cont_weights = 0;
                                        for(Container con:s.containers){
                                            cont_weights += con.weight;
                                        }
                                        if(c.weight>(s.maxWeight - cont_weights)){
                                            if(s.containers.size()>=s.maxWeight){
                                                System.out.println("Maximum number of containers reached");
                                            }
                                        } else {
                                            //s.containers.add(c);
                                            switch (c.getType()){
                                                case 'H' -> {
                                                    if(s.maxHeaReached()){
                                                        System.out.println("The maximum number of heavy containers has been reached");
                                                    } else {
                                                        s.containers.add(c);
                                                    }
                                                }
                                                case 'L' -> {
                                                    if(s.maxLiqReached()){
                                                        System.out.println("The maximum number of liquid containers has been reached");
                                                    } else {
                                                        s.containers.add(c);
                                                    }
                                                }
                                                case 'R' -> {
                                                    if(s.maxRefReached()){
                                                        System.out.println("The maximum number of refrigerated containers has been reached");
                                                    } else {
                                                        s.containers.add(c);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    loaded = true;
                                    System.out.print("Loaded !");
                                    System.out.println("-------------------------------------------------------------------------------------------");
                                }
                            }
                        } else {
                            System.out.print("Either the ship or container does not exist.");
                            System.out.println("-------------------------------------------------------------------------------------------");
                        }
                    }
                    if(!loaded){
                        System.out.print("Not loaded! Invalid details");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 5 -> {
                    boolean unloaded = false;
                    System.out.print("Enter the id of the container : ");
                    int cont_id = scan.nextInt();
                    System.out.print("Enter the id of the Ship : ");
                    int ship_id = scan.nextInt();
                    for(Container c:AllContainers){
                        if(c.getID()==cont_id){
                            for(Ship s:AllShips){
                                if(s.id==ship_id){
                                    if(s.containers.contains(c)){
                                        s.containers.remove(c);
                                        unloaded = true;
                                        System.out.print("Unloaded !");
                                        System.out.println("-------------------------------------------------------------------------------------------");
                                    }else {
                                        System.out.print("The container is not in here ");
                                        System.out.println("-------------------------------------------------------------------------------------------");
                                    }
                                }
                            }
                        } else {
                            System.out.print("Either the ship or container does not exist.");
                            System.out.println("-------------------------------------------------------------------------------------------");
                        }
                    }
                    if(!unloaded){
                        System.out.print("Ship not unloaded! Invalid details");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 6 -> {
                    boolean sailed = false;
                    System.out.print("Enter the id of the port : ");
                    int port_id = scan.nextInt();
                    System.out.print("Enter the id of the Ship : ");
                    int ship_id = scan.nextInt();
                    for(Port p:AllPorts){
                        if(p.port_id==port_id){
                            for(Ship s:AllShips){
                                if(s.id==ship_id){
                                    float distance = s.currentPort.calculate_distance((float) p.x_cord, (float) p.y_cord);
                                    float fuel_distance = (float) (s.fuel_level*s.fuelConsumption);
                                    if(distance>fuel_distance){
                                        System.out.println("Not enough fuel");
                                    } else {
                                        s.currentPort = p;
                                        p.incomingShip(s);
                                        sailed = true;
                                        System.out.print("The ship has sailed to the port");
                                        System.out.println("-------------------------------------------------------------------------------------------");
                                    }
                                }
                            }
                        }
                    }
                    if(!sailed){
                        System.out.print("Sail failed! Invalid details");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 7 -> {
                    boolean refueled = false;
                    System.out.print("Enter the id of the ship");
                    int ship_id = scan.nextInt();
                    for(Ship s:AllShips){
                        if(s.id==ship_id){
                            System.out.print("Enter the amount of fuel");
                            float fuel = scan.nextFloat();
                            if(fuel>(s.fuelCapacity-s.fuel_level)){
                                s.reFuel(fuel);
                                refueled = true;
                                System.out.print("Ship refueled !");
                                System.out.println("-------------------------------------------------------------------------------------------");
                            }else{
                                System.out.print("Not enough space");
                            }
                        }
                    }
                    if (!refueled){
                        System.out.print("Refuel failed! Either the details you entered are not correct or they do not exist");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 8 -> quit = true;

            }
        }
    }
}
//Author : Munashe Chipanga
