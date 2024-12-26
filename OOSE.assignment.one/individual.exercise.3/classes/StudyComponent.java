package classes;

import handlingResultSet.PrintStudyComponent;
import logger.LogFile;
import validation.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Variables
public class StudyComponent {

    public static void getStudyComponent(String studyComponentName, Connection con) {
        String sqlQuery = "SELECT * FROM study_component WHERE studyComponentName = ?";

        try {
            //Prepare the statement
            PreparedStatement statement = con.prepareStatement(sqlQuery);

            //Set values
            statement.setString(1, studyComponentName);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Print, execute or return result
            PrintStudyComponent.printResultSetStudyComponent(rs);

            System.out.println("Successfully retrieved information from database for study component with name: " + studyComponentName);

            LogFile.logInfo("Successfully retrieved information from database for study component with name: " + studyComponentName);

        } catch (SQLException e) {
            System.out.println("Something went wrong when looking for the semester, please check the logs!");

            LogFile.logError("Something went wrong getting information from the database for the study component with name: " + studyComponentName + "\n" + e);
        }
    }

    public static void createStudyComponent(int studyComponentId, String studyComponentName, int semesterId, Connection con) {
        String sqlSelectQuery = "SELECT * FROM study_component WHERE studyComponentId = ? AND studyComponentName = ? AND semesterId = ?";
        String sqlInsertQuery = "INSERT INTO study_component VALUES (?, ?, ?)";

        Validate.checkIntArgument(studyComponentId, con);
        Validate.checkStringArgument(studyComponentName, con);
        Validate.checkIntArgument(semesterId, con);

        try {
            PreparedStatement selectStatement = con.prepareStatement(sqlSelectQuery);

            selectStatement.setInt(1, studyComponentId);
            selectStatement.setString(2, studyComponentName);
            selectStatement.setInt(3, semesterId);

            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                //Prepare the statement
                PreparedStatement insertStatement = con.prepareStatement(sqlInsertQuery);

                //Set values
                insertStatement.setInt(1, studyComponentId);
                insertStatement.setString(2, studyComponentName);
                insertStatement.setInt(3, semesterId);

                //Execute query
                insertStatement.executeUpdate();
                System.out.println("Successfully added study component!");

                LogFile.logInfo("Successfully added study component with id: " + studyComponentId + " and name: " + studyComponentName);
            } else {
                System.out.println("Double value found for study component with id: " + studyComponentId + " and name: " + studyComponentName);

                LogFile.logError("Double value found for study component with id: " + studyComponentId + " and name: " + studyComponentName);
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong while adding the study component, please check the logs");

            LogFile.logError("Something went wrong with adding study component with id: " + studyComponentId + " and name: " + studyComponentName + "\n" + e);
        }
    }
}
