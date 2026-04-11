package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class OrganSystem implements Component{
        String name;
        List<Component> components = new ArrayList<>();
        
        OrganSystem(String name){
            this.name = name;
        }

        public void addOrgan(Component comp){
            components.add(comp);
        }

        public void showName(){
            System.out.println("The organs in the "+ name+ " are: ");
            for(Component c : components){
                System.out.println(c.getName());
            }
        }
        public String getName(){
            return name;
        }
}
