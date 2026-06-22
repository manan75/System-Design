package DesignPatterns.TestBuilder;

public class Ram implements Hardware{
    public String name;
    public float price;

    public Ram(String name, float price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
}
