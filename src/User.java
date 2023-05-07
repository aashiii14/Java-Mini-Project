import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {
    Scanner scan = new Scanner(System.in);
    dbConnection db = new dbConnection();
    ResultSet rs = null;
    int choice = 1;
    int i, x = 1;

    public void hotel(String City) throws SQLException {
        do {
            rs = db.select("select * from ta_hotels_scraper where city_name = '" + City + "';");
            while (rs.next()) {
                System.out.println(rs.getString("Hotelname"));
            }
            System.out.println("Which hotel would you like to checkout");
            String hotel = scan.nextLine();
            rs = db.select("select * from ta_hotels_scraper where city_name = '" + City
                    + "' and Hotelname like '%" + hotel + "%';");
            while (rs.next()) {
                System.out
                        .println("Hotel Name: " + rs.getString(1) + "\nHotel Rating: " + rs.getString(3)
                                + "\nTotal Reviews: " + rs.getString(4));
            }
            System.out.println("Would you like to check another hotel?[1]");
            i = Integer.parseInt(scan.nextLine());
        } while (i == 1);
    }

    public void p2v(String City) throws SQLException {
        do {
            rs = db.select("select * from ta_places where City like '%" + City + "%';");
            while (rs.next()) {
                System.out.println(rs.getString("Place"));
            }
            System.out.println("Which place would you like to checkout");
            String place1 = scan.nextLine();
            rs = db.select("select * from ta_places where City like '%" + City + "%' and Place like '%"
                    + place1 + "%';");
            while (rs.next()) {
                System.out.println(
                        "Place Name: " + rs.getString(2) + "\nPlace Description: " + rs.getString(3));
            }
            System.out.println("Would you like to check another place?[1]");
            i = Integer.parseInt(scan.nextLine());
        } while (i == 1);
    }

    public void search() throws SQLException {
        db.getConnection();
        int ch = 0;
        do {
            System.out.println("Enter the City name: ");
            String City = scan.nextLine();
            do {
                System.out.println("Enter which list you want \n1. Hotels \n2. Places to Visit \n3. Exit");
                ch = Integer.parseInt(scan.nextLine());
                switch (ch) {
                    case 1:
                        hotel(City);
                        System.out.println("To go back press 1 or press any key to exit");
                        x = Integer.parseInt(scan.nextLine());
                        break;
                    case 2:
                        p2v(City);
                        System.out.println("To go back press 1 or press any key to exit");
                        x = Integer.parseInt(scan.nextLine());

                        break;
                    case 3:
                        break;

                    default:
                        System.out.println("Incorrect option");
                }

            } while (x == 1 && ch != 3);
            if (ch != 3) {
                System.out.println("To continue press 1 else press any other key.");
                choice = Integer.parseInt(scan.nextLine());
            }
        } while (choice == 1 && ch != 3);
    }

}
