package DesignPatterns.Composite;

public class Organs implements Component {
    public String name;

    Organs(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void showName(){
        
    }
}
