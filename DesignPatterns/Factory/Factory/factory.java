/*
 factory class is responsible for creating the objects of the different car brands.
  It has a method buyMenu() which takes the user input for the car details and returns the car brand chosen by the user.
   It also has methods getAudi(), getBmw(), getFerrari(), and getPorsche() which create and return the respective car objects based on the user input. 
 */

package Factory;

import java.util.Scanner;

public class factory {
    Scanner s = new Scanner(System.in);
    public String carName;
    public String carPaint;
    public String userCar;
    public String carType;
    public String carModel;
    public int modelNum;


     public String buyMenu(){
        System.out.println("Choose the car brand you wish to buy: ");
        System.out.println("1. Audi");
        System.out.println("2. Porsche");
        System.out.println("3. BMW");
        System.out.println("4. Ferrari");
        userCar = s.nextLine();

        System.out.println("Enter car name: ");
        carName = s.nextLine();
        System.out.println("Enter paint color: ");
        carPaint = s.nextLine();
        System.out.println("Enter car type: ");
        carType = s.nextLine();
        System.out.println("Enter model: ");
        carModel = s.nextLine();
        System.out.println("Enter model number: ");
        modelNum = s.nextInt();

        return userCar;

    }
    public Audi getAudi(){
        Audi audi = new Audi(carName, carPaint, carType, carModel, modelNum);
        return audi;
    }

    public BMW getBmw(){
        BMW bmw = new BMW(carName, carType, carPaint, carModel, modelNum);
        return bmw;
    }
    public Ferrari getFerrari(){
        Ferrari ferrari = new Ferrari(carName, carType, carPaint, carModel, modelNum);
        return ferrari;
    }
    public Porsche getPorsche(){
        Porsche porsche = new Porsche(carName, carType, carPaint, carModel, modelNum);
        return porsche;
    }

}
