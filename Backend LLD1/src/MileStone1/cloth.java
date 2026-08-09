package MileStone1;

public class cloth  extends  Item{


    private String size;

    public  cloth(String id, String name, double price, int quantity, String size)
    {
        super(id, name , price, quantity);
        this.size = size;
    }

    public  String getSize(){
        return size;
    }
}
