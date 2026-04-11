import java.util.Scanner;

public class SimpleLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loginManager loginManager1 = loginManager.getInstance(); // Singleton Instance

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (loginManager1.authenticate(username, password)) {
            System.out.println("Login successful! Welcome, " + username + ".");
        } else {
            System.out.println("Invalid username or password. Try again.");
        }

        scanner.close();
    }
}