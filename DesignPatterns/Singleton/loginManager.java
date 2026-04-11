import java.util.Scanner;


class loginManager {
    private static loginManager instance;
    private final String validUsername = "admin";
    private final String validPassword = "1234";

    private loginManager() {}   //so that no other class can instantiate 

    public static loginManager getInstance() {
        if (instance == null) {
            instance = new loginManager();
        }
        return instance;
    }

    public boolean authenticate(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
