package DesignPatterns.TestObserver;

public class notif implements Subject {
    public String message = "I am sending a new parcel today";
    Observer ob1 = new sms();
    public void notifyObservers(){
       ob1.update(message);
    }
}
