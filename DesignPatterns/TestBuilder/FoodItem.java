package DesignPatterns.TestBuilder;

public class FoodItem {
    String type;
    boolean spicy;
    boolean extraCheese;

    public String toString() {
        return type + (spicy ? " (Spicy)" : "") + (extraCheese ? " + Cheese" : "");
    }
}
