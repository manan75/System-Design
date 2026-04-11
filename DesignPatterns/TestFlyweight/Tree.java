package DesignPatterns.TestFlyweight;

public class Tree implements Graphic {
    String type = "Oak";
    int x,y;
    public void draw(int x,int y){
        this.x = x;
        this.y =y;
        System.out.println("Drawing tree of type "+ type+ "at: "+ x + ", "+y);
    }
}
