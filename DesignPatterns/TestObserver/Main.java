package DesignPatterns.TestObserver;

public class Main {
    public static void main(String[] args) {
        Subject s1 = new notif();
        s1.notifyObservers();
    }
    
}
