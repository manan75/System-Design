import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        laptopFactory laptopFactory = new laptopFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Laptop Factory!");
        System.out.println("Choose the hardware type:");
        System.out.println("1. Asus");
        System.out.println("2. Lenovo");
        String hardwareChoice = scanner.nextLine();

        System.out.println("Choose your CPU type:");
        System.out.println("1. AMD");
        System.out.println("2. Intel");
        String cpuChoice = scanner.nextLine();

        System.out.println("Choose GPU type:");
        System.out.println("1. AMD");
        System.out.println("2. Nvidia");
        String gpuChoice = scanner.nextLine();

        laptopFactory.buildLaptop(hardwareChoice, cpuChoice, gpuChoice);

        scanner.close();
    }
}
