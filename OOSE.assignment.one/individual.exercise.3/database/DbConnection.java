package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static Connection getDbConnection() {
        //Create a Database object
        Connection con = null;

        //Credentials for making contact with the database
        String URL = "jdbc:mysql://localhost:3306/individual_exercise_3";

        String userName = "root";
        String password = "Hetistochniettegeloven.";

        //Try catch to catch the exception
        try {
            con = DriverManager.getConnection(URL, userName, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }

    public static void closeDbConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Database connection successfully closed");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
