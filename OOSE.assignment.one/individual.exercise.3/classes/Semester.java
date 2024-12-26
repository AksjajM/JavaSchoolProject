package classes;

import handlingResultSet.PrintSemester;
import logger.LogFile;
import validation.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Semester {

    public static void getSemesterByName(String semesterName, Connection con) {
        String sqlQuery = "SELECT * FROM semester WHERE semesterName = ?";

        try {
            //Prepare the statement
            PreparedStatement statement = con.prepareStatement(sqlQuery);

            //Set values
            statement.setString(1, semesterName);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Print, execute or return result
            PrintSemester.printResultSetSemester(rs);

            LogFile.logInfo("Successfully retrieved information from database for semester with name: " + semesterName);

        } catch (SQLException e) {
            System.out.println("Something went wrong getting the information from the database, please check the logfiles!");

            LogFile.logError("Something went wrong with adding a result!\n" + e);
        }
    }

    public static void createSemester(int semesterId, String semesterName, Connection con) {
        String sqlSelectQuery = "SELECT * FROM semester WHERE semesterId = ? AND semesterName = ?";
        String sqlInsertQuery = "INSERT INTO semester VALUES (?, ?)";

        Validate.checkIntArgument(semesterId, con);
        Validate.checkStringArgument(semesterName, con);

        try {
            PreparedStatement selectStatement = con.prepareStatement(sqlSelectQuery);

            selectStatement.setInt(1, semesterId);
            selectStatement.setString(2, semesterName);

            ResultSet rs = selectStatement.executeQuery();

            if (!rs.next()) {
                PreparedStatement insertStatement = con.prepareStatement(sqlInsertQuery);

                insertStatement.setInt(1, semesterId);
                insertStatement.setString(2, semesterName);

                insertStatement.executeUpdate();

                System.out.println("Successfully added semester: " + semesterName);

                LogFile.logInfo("Successfully added semester with name: " + semesterName);
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong while adding the new semester, please check the logs");

            LogFile.logError("Something went wrong while adding the new semester with name: " + semesterName + "\n" + e);
        }
    }
}
