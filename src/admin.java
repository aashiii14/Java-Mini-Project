import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class admin {
    Scanner scan = new Scanner(System.in);
    dbConnection db = new dbConnection();
    ResultSet rs = null;

    public void table1() throws SQLException {
        db.getConnection();
        int j = 1;
        do {
            System.out.println(
                    "Enter which function you would like to execute: \n1. Create \n2. Update \n3. Delete \n4. Read \n5.Exit ");
            int opt = Integer.parseInt(scan.nextLine());
            switch (opt) {
                case 1:
                    System.out.println("Enter the new hotel name: ");
                    String newhot = scan.nextLine();
                    System.out.println("Enter the City name: ");
                    String newcity = scan.nextLine();
                    System.out.println("Enter the Rating of the new hotel: ");
                    String newRat = scan.nextLine();
                    System.out.println("Enter the review counts of the new hotel: ");
                    String newrev = scan.nextLine();
                    db.insertInto("insert into ta_hotels_scraper values('" + newhot + "','" + newcity + "','" + newRat
                            + "','" + newrev + "');");
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 2:
                    System.out.println("Enter the hotel name you want to make changes in: ");
                    String hot = scan.nextLine();
                    System.out.println("Enter the city of the hotel: ");
                    String cit = scan.nextLine();
                    System.out.println("Enter the column name where the change needs to be updated: ");
                    String coln = scan.nextLine();
                    System.out.println("Enter the updated detail: ");
                    String updated = scan.nextLine();
                    db.update("update ta_hotels_scraper set " + coln + "='" + updated + "' where Hotelname like '%"
                            + hot + "%' and city_name = '" + cit + "';");
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 3:
                    System.out.println("Enter the hotel name you want to delete: ");
                    String hot1 = scan.nextLine();
                    System.out.println("Enter the city of the hotel: ");
                    String cit1 = scan.nextLine();
                    db.drop("delete from ta_hotels_scraper where Hotelname like '%" + hot1 + "%' and city_name = '"
                            + cit1 + "';");
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 4:
                    User use = new User();
                    System.out.println("Enter the City name: ");
                    String City = scan.nextLine();
                    use.hotel(City);
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 5:
                    j = 0;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        } while (j == 1);
    }

    public void table2() throws SQLException {

        db.getConnection();
        int j = 1;
        do {
            System.out.println(
                    "Enter which function you would like to execute: \n1. Create \n2. Update \n3. Delete \n.4. Read \n5.Exit ");
            int opt = Integer.parseInt(scan.nextLine());
            switch (opt) {
                case 1:
                    System.out.println("Enter the new place name: ");
                    String newplace = scan.nextLine();
                    System.out.println("Enter the City name: ");
                    String newcity = scan.nextLine();
                    System.out.println("Enter the Description of the new place: ");
                    String newdesc = scan.nextLine();
                    db.insertInto(
                            "insert into ta_places values('" + newcity + "','" + newplace + "','" + newdesc + "');");
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 2:
                    System.out.println("Enter the place name you want to make changes in: ");
                    String place = scan.nextLine();
                    System.out.println("Enter the updated detail: ");
                    String updated = scan.nextLine();
                    db.update(
                            "update ta_places set Description ='" + updated + "' where Place like '%" + place + "%'; ");
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 3:
                    System.out.println("Enter the place name you want to delete: ");
                    String plac = scan.nextLine();
                    db.drop("delete from ta_places where Place like '%" + plac + "%';");
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 4:
                    User use = new User();
                    System.out.println("Enter the City name: ");
                    String City = scan.nextLine();
                    use.p2v(City);
                    System.out.println("Do you wish to continue?[1]");
                    j = Integer.parseInt(scan.nextLine());
                    break;

                case 5:
                    j = 0;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        } while (j == 1);
    }

    public void Main() throws SQLException {
        System.out.println("Enter the table you want to operate on: \n1. Hotels table \n2. Places table");
        int ch = Integer.parseInt(scan.nextLine());
        int choice = 1;
        do {
            switch (ch) {
                case 1:
                    table1();
                    break;
                case 2:
                    table2();
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
            System.out.println("Enter 1 to continue and any other key to exit.");
            choice = Integer.parseInt(scan.nextLine());
        } while (choice == 1);
    }
}
