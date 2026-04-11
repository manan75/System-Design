import java.util.ArrayList;
import java.util.List;
//an object of this is created in billbuilder and getBill and display methods are used
public class ShoppingBill {
    //we using refernce of our interface in arraylist
    
    public List<Item> items = new ArrayList<Item>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getBill(){
        float cost =0.0f;
        for(Item item: items){
            cost+=item.price();
        }
        return cost;

    }

    public void display(){
        for(Item item: items){
            System.out.println("Item: "+ item.name());
            System.out.println("Price: "+ item.price());
        }
    }
}
