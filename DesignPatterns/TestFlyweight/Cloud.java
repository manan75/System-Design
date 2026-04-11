package DesignPatterns.TestFlyweight;

public class Cloud implements Graphic{
    String type = "Cumulus";
    int x,y;

    public void draw(int x,int y){
        this.x =x;
        this.y=y;
        System.out.println("Cloud placed of type "+type+" at: "+ x+", "+ y);
    }
}
