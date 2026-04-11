package DesignPatterns.TestBuilder;

public class Main {
    public static void main(String[] args) {
        FoodItem order = new ItemBuilder("Pizza")
                             .makeSpicy()
                             .addCheese()
                             .build();

        System.out.println("Order: " + order);
    }
}
