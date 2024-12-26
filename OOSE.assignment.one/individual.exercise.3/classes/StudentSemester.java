package classes;

import logger.LogFile;
import validation.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentSemester {

    public static void addStudentToSemester(int studentId, int semesterId, Connection con) {
        String sqlInsertQuery = "INSERT INTO student_semester VALUES (null, ?, ?)";

        Validate.checkIntArgument(studentId, con);
        Validate.checkIntArgument(semesterId, con);

        try {
            //Prepare the statement
            PreparedStatement statement = con.prepareStatement(sqlInsertQuery);

            //Set values
            statement.setInt(1, studentId);
            statement.setInt(2, semesterId);

            //Execute query
            statement.executeUpdate();

            System.out.println("Student successfully added to the semester!");

            LogFile.logInfo("Successfully added student with student id: " + studentId + " to semester with id: " + semesterId);

        } catch (SQLException e) {
            System.out.println("Something went wrong adding student to semester!" + e);

            LogFile.logError("Something went wrong with adding student with student id: " + studentId + " to semester with id: " + semesterId + "\n" + e);
        }
    }

    public static void unsubscribeStudent(int studentId, int semesterId, Connection con) {
        String sqlDeleteQuery = "DELETE FROM student_semester WHERE studentId = ? AND semesterId = ?";
        String sqlSelectQuery = "SELECT * FROM student_semester WHERE studentId = ? AND semesterId = ?";
        Validate.checkIntArgument(studentId, con);
        Validate.checkIntArgument(semesterId, con);

        try {
            //Prepare the statement
            PreparedStatement selectStatement = con.prepareStatement(sqlSelectQuery);

            //Set values
            selectStatement.setInt(1, studentId);
            selectStatement.setInt(2, semesterId);

            //Execute query
            ResultSet rs = selectStatement.executeQuery();

            //Print, execute or return result

            if (rs.next()) {
                //DELETE if Exists
                //Prepare the statement
                PreparedStatement deleteStatement = con.prepareStatement(sqlDeleteQuery);

                //Set values
                deleteStatement.setInt(1, studentId);
                deleteStatement.setInt(2, semesterId);

                //Execute query
                deleteStatement.executeUpdate();
                System.out.println("Successfully unsubscribed student with student id: " + studentId + " from semester with semester id: " + semesterId);

                LogFile.logInfo("Successfully unsubscribed student with student id: " + studentId + " from semester with semester id: " + semesterId);
            } else {
                System.out.println("Combination of studentid: " + studentId + " and semester id: " + semesterId + " does not exist in this table");

                LogFile.logError("Combination of studentid: " + studentId + " and semester id: " + semesterId + " does not exist in this table");
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong when unsubscribing student, please check the logs!");

            LogFile.logError("Something went wrong while unsubscribing student id: " + studentId + " from semester id: " + semesterId + "\n" + e);
        }
    }
}
