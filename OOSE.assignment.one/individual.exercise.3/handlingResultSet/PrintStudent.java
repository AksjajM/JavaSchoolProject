package handlingResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintStudent {
    public static void printResultSetStudent(ResultSet rs) {

        //Iterator iterates through the values until there is no value left
        try {
            while (rs.next()) {

                //Put the values from the table in variables
                int id = rs.getInt("studentId");
                String firstName = rs.getString("studentFirstName");
                String lastName = rs.getString("studentLastName");

                //Print the values
                System.out.println("Student id: " + id + "\n"
                        + "Student first name: " + firstName + "\n"
                        + "Student last name: " + lastName + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when printing out the values " + e);
        }

    }
}
