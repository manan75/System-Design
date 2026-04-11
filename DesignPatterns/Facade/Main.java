package DesignPatterns.Facade;

public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();  // Client interacts only with Facade
    }
}
