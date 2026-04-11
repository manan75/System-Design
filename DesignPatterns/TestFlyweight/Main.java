package DesignPatterns.TestFlyweight;

public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Graphic cloud1 = factory.getCloud();
        Graphic cloud2 = factory.getCloud();

        cloud1.draw(1, 2);
        cloud2.draw(4, 8);

        Graphic tree1 = factory.getTree();
        Graphic tree2 = factory.getTree();

        tree1.draw(5, 5);
        tree2 .draw(8, 12);
    }
}
