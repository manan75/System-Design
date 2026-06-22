package DesignPatterns.TestBuilder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    
    public List<Hardware> parts = new ArrayList<Hardware>();

    public void addHardware(Hardware hardware){
        parts.add(hardware);
    }
    public float getBill(){
        float cost = 0.0f;
        for(Hardware hardware: parts){
            cost+= hardware.getPrice();
        }
        return cost;
    }

    public void display(){
        for(Hardware hardware: parts){
            System.out.println("Name: " + hardware.getName());
            System.out.println("Price: "+ hardware.getPrice());
        }
    }
}
