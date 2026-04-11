package DesignPatterns.TestObserver;

public class sms implements Observer {
    
    public void update(String message){
        System.out.println("notification recieved: "+ message);
    }
}
