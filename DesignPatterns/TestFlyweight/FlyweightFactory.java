package DesignPatterns.TestFlyweight;

public class FlyweightFactory {
    
    public Graphic getTree(){
        return new Tree();
    }
    public Graphic getCloud(){
        return new Cloud();
    }
}
