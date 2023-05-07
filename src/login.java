import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {
    ResultSet rs = null;
    dbConnection db = new dbConnection();
    Scanner scan = new Scanner(System.in);
    static admin ad = new admin();
    static User us = new User();

    public void Login() throws SQLException {
        System.out.println("Enter the login credentials: ");
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();
        db.getConnection();
        int flag = 0;
        rs = db.select("Select email, password from login;");
        while (rs.next()) {
            if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
                if (rs.getString(1).equals("Aashi") && rs.getString(2).equals("Aashi123")) {
                    System.out.println("Admin has logged in.");
                    ad.Main();
                    flag = 1;
                } else {
                    System.out.println("User has logged in.");
                    us.search();
                    flag = 1;
                }

            }
        }
        if (flag == 0) {
            System.out.println("Wrong Username or password!");
        }
    }

    public void register() throws SQLException {
        System.out.println("Enter a User ID: ");
        String id = scan.nextLine();
        System.out.println("Enter a username: ");
        String User = scan.nextLine();
        System.out.println("Enter the password: ");
        String pass = scan.nextLine();
        db.getConnection();
        int flag = 0;
        rs = db.select("select * from login;");
        while (rs.next()) {
            if (rs.getString(1).equals(id) || rs.getString(2).equals(User)) {
                System.out.println("The user already exists! \nThe User has been logged in!");
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            db.insertInto("insert into login values('" + id + "','" + User + "','" + pass + "');");
        }
        System.out.println("The newuser has been logged in!");
        us.search();
    }
}
