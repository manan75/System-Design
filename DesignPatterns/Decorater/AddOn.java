package DesignPatterns.Decorater;

class AddOn implements Coffee {
    private Coffee coffee;
    private String name;
    private double price;

    public AddOn(Coffee coffee, String name, double price) {
        this.coffee = coffee;
        this.name = name;
        this.price = price;
    }

    public String getDescription() { return coffee.getDescription() + " + " + name; }
    public double cost() { return coffee.cost() + price; }
}

