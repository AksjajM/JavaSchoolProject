package handlingResultSet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintStudyComponent {
    public static void printResultSetStudyComponent(ResultSet rs) {

        //Iterator iterates through the values until there is no value left
        try {
            while (rs.next()) {

                //Put the values from the table in variables
                int studyComponentId = rs.getInt("studyComponentId");
                String studyComponentName = rs.getString("studyComponentName");
                int semesterId = rs.getInt("semesterId");

                //Print the values
                System.out.println("Study component id: " + studyComponentId + "\n"
                        + "Study component name: " + studyComponentName + "\n"
                        + "Semester id: " + semesterId);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when printing out the values " + e);
        }
    }
}
