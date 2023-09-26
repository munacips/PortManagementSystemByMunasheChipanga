//Author : Munashe Chipanga
public class RefrigeratedContainer extends HeavyContainer {

    char type = 'R';
    public RefrigeratedContainer(int id, int wei, Port port){

        super(id,wei,port);
        super.setFuel_consumption(5.0F);
    }
}
