package Factory;
import java.util.*;
public class Main {
   public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    factory f = new factory();
    BuyerInventory buyer = new BuyerInventory();
    System.out.println("Welcom to Manan Retails!");
    int isBuying =1;
    while(isBuying==1){
        System.out.println("Do you wish to buy cars?: (Y/N)");
        String choice = scan.next();
        if (choice.equalsIgnoreCase("N")) { // equalsIgnoreCase for better comparison
            System.out.println("Thank you for you time!");
            break;
        }
        else{
            String carBought = f.buyMenu();


            switch(carBought){
                case "Audi": {
                    System.out.println("Congrats you bought an audi! The details of your purchase are: ");
        
                    Audi audi = f.getAudi();
                
                    audi.displayDetails();
                    break;
                }
                case "BMW":{
                    System.out.println("Congrats you bought a BMW! The details of your purchase are: ");
                    BMW bmw = f.getBmw();
                    
                    bmw.displayDetails();
                    break;
                }
                case "Ferrari": {
                    System.out.println("Congrats you bought an ferrari! The details of your purchase are: ");
                    Ferrari ferrari = f.getFerrari();
                    
                    ferrari.displayDetails();
                    break;
                }
                case "Porsche": {
                    System.out.println("Congrats you bought a porsche! The details of your purchase are: ");
                    Porsche porsche = f.getPorsche();
                    
                    porsche.displayDetails();
                    break;
                }
                default: {
                    System.out.println("Invalid car name input");
                }
                
            }
        }
    }
    
   


}
}