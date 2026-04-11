package DesignPatterns.TestPrototype;

public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing Circle with radius: " + radius);
    }

    public Shape clone() {
        return new Circle(this.radius); //deep copy
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}


