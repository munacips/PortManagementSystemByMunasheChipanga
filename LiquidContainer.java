//Author : Munashe Chipanga
public class LiquidContainer extends HeavyContainer{
    char type = 'L';
    public LiquidContainer(int id, int wei){
        super(id,wei);
        super.setFuel_consumption(4.0F);
    }
}
