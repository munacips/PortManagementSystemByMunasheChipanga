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
            if(s.getID()==id){
                return true;
            }
        }
        return false;
    }
    public static boolean port_id_exist(int id){
        for(Port p:AllPorts){
            if(p.getID()==id){
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
                    System.out.print("Enter the ID of the port  : ");
                    int portID = scan.nextInt();
                    Port port;
                    if(port_id_exist(portID)){
                        for(Port p:AllPorts){
                            if(p.getID()==portID){
                                port = p;
                                System.out.print("Is it a refrigerated container(R), liquid container(L) or basic container(B) : ");
                                char type = scan.next().charAt(0);
                                switch (type){
                                    case 'R' -> {
                                        System.out.print("Enter the ID of the container : ");
                                        int id = scan.nextInt();
                                        if(container_id_exist(id)){
                                            System.out.println("ID already exists");
                                            System.out.println("-------------------------------------------------------------------------------------------");
                                        } else {
                                            AllContainers.add(new RefrigeratedContainer(id,weight,port));
                                            System.out.println("A refrigerated container has been created !");
                                            System.out.println("-------------------------------------------------------------------------------------------");
                                            created = true;
                                        }
                                    }
                                    case 'L' -> {
                                        System.out.print("Enter the ID of the container : ");
                                        int id = scan.nextInt();
                                        if(container_id_exist(id)){
                                            System.out.println("ID already exists");
                                            System.out.println("-------------------------------------------------------------------------------------------");
                                        } else {
                                            AllContainers.add(new LiquidContainer(id,weight,port));
                                            created = true;
                                            System.out.println("A liquid container has been created !");
                                            System.out.println("-------------------------------------------------------------------------------------------");
                                        }
                                    }
                                    case 'B' -> {
                                        System.out.print("Enter the ID of the container : ");
                                        int id = scan.nextInt();
                                        if(container_id_exist(id)){
                                            System.out.println("ID already exists");
                                            System.out.println("-------------------------------------------------------------------------------------------");
                                        } else {
                                            if(weight>5000){
                                                AllContainers.add(new HeavyContainer(id,weight,port));
                                                created = true;
                                                System.out.println("A heavy container has been created ! ");
                                                System.out.println("-------------------------------------------------------------------------------------------");
                                            } else {
                                                AllContainers.add(new BasicContainer(id,weight,port));
                                                created = true;
                                                System.out.println("A basic container has been created ! ");
                                                System.out.println("-------------------------------------------------------------------------------------------");
                                            }
                                        }
                                    }
                                    default -> throw new IllegalStateException("Unexpected value: " + type);
                                }
                                if(!created){
                                    System.out.println("Container not created, an error occurred !");
                                    System.out.println("-------------------------------------------------------------------------------------------");
                                }
                            }
                        }
                    }
                    if(!created){
                        System.out.println("Container not created, No port with that iD !");
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
                            if (port_id==p.getID()){
                                port = p;
                                break;
                            }
                        }
                        if(port==null){
                            System.out.println("No valid port was entered");
                            System.out.println("-------------------------------------------------------------------------------------------");
                            //RESTART
                        } else {
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
                            System.out.printf("The ship with id : %d has been created ! \n",id);
                            System.out.println("-------------------------------------------------------------------------------------------");
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter the x coordinate : ");
                    float x = scan.nextFloat();
                    System.out.print("Enter the y coordinate : ");
                    float y = scan.nextFloat();
                    int id = AllPorts.size()+1;
                    if(port_id_exist(id)){
                        System.out.println("ID already in use");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    } else {
                        AllPorts.add(new Port(x,y,id));
                        System.out.printf("Port with id : %d has been created ! \n",id);
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
                                if(s.getID()==ship_id){
                                    if(s.containers.contains(c)){
                                        System.out.print("Already in ");
                                        System.out.println();
                                    } else {
                                        int cont_weights = 0;
                                        for(Container con:s.containers){
                                            cont_weights += con.weight;
                                        }
                                        if(c.weight>(s.getMaxWeight() - cont_weights)){
                                            if(s.containers.size()>=s.getMaxWeight()){
                                                System.out.println("Maximum number of containers reached");
                                            }
                                        } else {
                                            if(s.getCurrentPort()==c.current_port){
                                                switch (c.getType()){
                                                    case 'H' -> {
                                                        if(s.maxHeaReached()){
                                                            System.out.println("The maximum number of heavy containers has been reached");
                                                        } else {
                                                            s.containers.add(c);
                                                            loaded = true;
                                                            System.out.printf("The ship with id: %d has been loaded with a container with id : %d! \n",s.getID(),c.getID());
                                                            System.out.println("-------------------------------------------------------------------------------------------");
                                                        }
                                                    }
                                                    case 'L' -> {
                                                        if(s.maxLiqReached()){
                                                            System.out.println("The maximum number of liquid containers has been reached");
                                                        } else {
                                                            s.containers.add(c);
                                                            loaded = true;
                                                            System.out.printf("The ship with id: %d has been loaded with a container with id : %d! \n",s.getID(),c.getID());
                                                            System.out.println("-------------------------------------------------------------------------------------------");
                                                        }
                                                    }
                                                    case 'R' -> {
                                                        if(s.maxRefReached()){
                                                            System.out.println("The maximum number of refrigerated containers has been reached");
                                                        } else {
                                                            s.containers.add(c);
                                                            loaded = true;
                                                            System.out.printf("The ship with id: %d has been loaded with a container with id : %d! \n",s.getID(),c.getID());
                                                            System.out.println("-------------------------------------------------------------------------------------------");
                                                        }
                                                    }
                                                    case 'B' -> {
                                                        if(s.maxContainers()){
                                                            System.out.println("The maximum number of refrigerated containers has been reached");
                                                        } else {
                                                            s.containers.add(c);
                                                            loaded = true;
                                                            System.out.printf("The ship with id: %d has been loaded with a container with id : %d! \n",s.getID(),c.getID());
                                                            System.out.println("-------------------------------------------------------------------------------------------");
                                                        }
                                                    }
                                                }
                                            } else {
                                                System.out.printf("The container is on port %d and the ship on port %d \n",c.current_port.getID(),s.getCurrentPort().getID());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(!loaded){
                        System.out.println("Not loaded! Invalid details");
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
                                if(s.getID()==ship_id){
                                    if(s.containers.contains(c)){
                                        s.containers.remove(c);
                                        unloaded = true;
                                        System.out.printf("The container with id : %d has been unloaded from the ship! \n",c.getID());
                                        System.out.println("-------------------------------------------------------------------------------------------");
                                    }else {
                                        System.out.println("That container is not in here ");
                                        System.out.println("-------------------------------------------------------------------------------------------");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Either the ship or container does not exist.");
                            System.out.println("-------------------------------------------------------------------------------------------");
                        }
                    }
                    if(!unloaded){
                        System.out.println("Ship not unloaded! Invalid details");
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
                        if(p.getID()==port_id){
                            for(Ship s:AllShips){
                                if(s.getID()==ship_id){
                                    if(s.getCurrentPort()==p){
                                        System.out.println("Ship is already in this port");
                                    } else {
                                        float distance = s.getCurrentPort().calculate_distance((float) p.getXCord(), (float) p.getYCord());
                                        float fuel_distance = (float) (s.getFuel_level()*s.getFuelConsumption());
                                        if(distance>fuel_distance){
                                            System.out.println("Not enough fuel");
                                        } else {
                                            Port departed_port = s.getCurrentPort();
                                            departed_port.outgoingShip(s);
                                            s.setCurrentPort(p);
                                            p.incomingShip(s);
                                            for(Container c:s.containers){
                                                c.current_port = s.getCurrentPort();
                                            }
                                            sailed = true;
                                            System.out.printf("The ship has sailed to the port with id : %d and has travelled a distance of %f \n",p.getID(),distance);
                                            System.out.println("-------------------------------------------------------------------------------------------");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if(!sailed){
                        System.out.println("Sail failed! Invalid details");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 7 -> {
                    boolean refueled = false;
                    System.out.print("Enter the id of the ship");
                    int ship_id = scan.nextInt();
                    for(Ship s:AllShips){
                        if(s.getID()==ship_id){
                            System.out.print("Enter the amount of fuel");
                            float fuel = scan.nextFloat();
                            if(fuel<(s.getFuelCapacity()-s.getFuel_level())){
                                s.reFuel(fuel);
                                refueled = true;
                                System.out.println("Ship refueled !");
                                System.out.println("-------------------------------------------------------------------------------------------");
                            }else{
                                System.out.print("Not enough space");
                            }
                        }
                    }
                    if (!refueled){
                        System.out.println("Refuel failed! Either the details you entered are not correct or they do not exist");
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                }
                case 8 -> quit = true;

            }
        }
    }
}
//Author : Munashe Chipanga