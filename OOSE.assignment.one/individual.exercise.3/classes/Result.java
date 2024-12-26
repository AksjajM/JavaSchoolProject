package classes;

import logger.LogFile;
import validation.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Result {

    public static void insertResult(String date, int studentId, int studyComponentId, double finalGrade, Connection con) {
        String sqlSelectQuery = "SELECT * FROM result WHERE resultDate = ? AND studentId = ? AND studyComponentId = ? AND finalGrade = ?";
        String sqlInsertQuery = "INSERT INTO result VALUES (?, ?, ?, ?)";

        Validate.checkDateArgument(date, con);
        Validate.checkIntArgument(studentId, con);
        Validate.checkIntArgument(studyComponentId, con);
        Validate.checkDoubleArgument(finalGrade, con);

        try {
            PreparedStatement sqlSelectStatement = con.prepareStatement(sqlSelectQuery);

            sqlSelectStatement.setString(1, date);
            sqlSelectStatement.setInt(2, studentId);
            sqlSelectStatement.setInt(3, studyComponentId);
            sqlSelectStatement.setDouble(4, finalGrade);

            ResultSet rs = sqlSelectStatement.executeQuery();

            if (!rs.next()) {
                //Prepare the statement
                PreparedStatement insertStatement = con.prepareStatement(sqlInsertQuery);

                //Set values
                insertStatement.setString(1, date);
                insertStatement.setInt(2, studentId);
                insertStatement.setInt(3, studyComponentId);
                insertStatement.setDouble(4, finalGrade);

                //Execute query
                insertStatement.executeUpdate();
                System.out.println("Successfully added result!");

                LogFile.logInfo("Successfully inserted result for student with id: " + studentId + " and result: " + finalGrade);

            } else {
                System.out.println("A line already exists in the database with these values, please check if you entered the correct data!");
                System.out.println("Returning back to main menu...");

                LogFile.logError("Double value when trying to insert a new result for student with id: " + studentId);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong adding a result! Please check the logs.");

            LogFile.logError("Something went wrong with adding a result!\n" + e);
        }
    }
}
