package DesignPatterns.TestPrototype;

public class Main {
    public static void main(String[] args) {
        Shape circle1 = new Circle(10);
        circle1.draw();

        Shape circle2 = circle1.clone(); // Cloning
        ((Circle) circle2).setRadius(20);
        circle2.draw(); // Modified copy

        circle1.draw(); // Original remains unchanged
    }
}
