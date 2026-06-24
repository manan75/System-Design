package DesignPatterns.LLDpatterns.UNIXfileSystem;

import java.util.HashMap;
import java.util.Map;

public class Directory {
   private String name;
   private Directory parent;
   private Map<String, Directory> children;

    public Directory(String name, Directory parent){
        this.name = name;
        this.parent = parent;
        //better to instantiate in the constructor only
        this.children = new HashMap<>();
    }
    //getters

    public String getName(){
        return name;
    }
    public Directory getParent(){
        return parent;
    }
    public Map<String,Directory> getChildren(){
        return children;
    }
}

