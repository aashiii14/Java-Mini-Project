import java.sql.SQLException;
import java.util.Scanner;

public class App {
    static Scanner scan = new Scanner(System.in);
    static dbConnection db = new dbConnection();
    static admin ad = new admin();
    static User u = new User();
    static login lg = new login();

    public static void main(String[] args) throws SQLException {
        System.out.println("Enter the choice: \n1. Login \n2. Register");
        int ch = Integer.parseInt(scan.nextLine());
        switch (ch) {
            case 1:
                lg.Login();
                break;
            case 2:
                lg.register();
                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}
