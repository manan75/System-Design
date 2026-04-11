package DesignPatterns.Decorater;

public class DecoratorExample {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        //adding new behaviours to the object 
        coffee = new AddOn(coffee, "Milk", 10); // Add Milk
        coffee = new AddOn(coffee, "Sugar", 5); // Add Sugar
        
        System.out.println(coffee.getDescription() + " | Cost: " + coffee.cost());
    }
}