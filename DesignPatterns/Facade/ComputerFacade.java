package DesignPatterns.Facade;

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("Starting Computer...");
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer started successfully!");
    }
}