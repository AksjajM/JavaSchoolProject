package handlingResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintSemester {
    public static void printResultSetSemester(ResultSet rs) {

        //Iterator iterates through the values until there is no value left
        try {
            while (rs.next()) {

                //Put the values from the table in variables
                int semesterId = rs.getInt("semesterId");
                String semesterName = rs.getString("semesterName");

                //Print the values
                System.out.println("Semester id: " + semesterId+ "\n"
                        + "Semester name: " + semesterName + "\n");
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when printing out the values " + e);
        }
    }
}
