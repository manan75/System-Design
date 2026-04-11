package Factory;

import java.util.*;

import Factory.Ferrari;
import Factory.Porsche;
public class BuyerInventory {
    List<Cars> garage = new ArrayList<>();

    public void storeInGarage(Cars boughtCar){
            garage.add(boughtCar);
    }
    public void garageDetails(){
        for(Object obj : garage){
            if(obj instanceof Audi){
                ((Audi)obj).displayDetails(); 
            }
            else if(obj instanceof BMW){
                ((BMW)obj).displayDetails();
            }
            else if(obj instanceof Ferrari){
                ((Ferrari)obj).displayDetails();
            }
            else if(obj instanceof Porsche){
                ((Porsche)obj).displayDetails();
            }
        }
    }
}
