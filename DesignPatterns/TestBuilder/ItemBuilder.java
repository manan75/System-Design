package DesignPatterns.TestBuilder;

public class ItemBuilder {
    public FoodItem food;

    public ItemBuilder(String type){
        food = new FoodItem();
        food.type = type;
    }
    public ItemBuilder makeSpicy() {
        food.spicy = true;
        return this;
    }

    public ItemBuilder addCheese() {
        food.extraCheese = true;
        return this;
    }

    public FoodItem build() {
        return food;
    }
}
