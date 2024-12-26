package classes;

import handlingResultSet.PrintStudent;
import logger.LogFile;
import validation.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {

    public static void getStudentById(int studentId, Connection con) {
        String sqlQuery = "SELECT * FROM student WHERE studentId = ?";
        Validate.checkIntArgument(studentId, con);

        try {
            //Prepare the statement
            PreparedStatement statement = con.prepareStatement(sqlQuery);

            //Set values
            statement.setInt(1, studentId);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Print, execute or return result
            PrintStudent.printResultSetStudent(rs);

            LogFile.logInfo("Successfully retrieved information from database for student with id: " + studentId);

        } catch (SQLException e) {
            System.out.println("Something went wrong getting the information from the database, please check the logfiles!");

            LogFile.logError("Something went wrong getting the information for student with id: " + studentId + "\n" + e);
        }
    }

    public static void getStudentByName(String studentName, Connection con) {
        String sqlQuery = "SELECT * FROM student WHERE studentFirstName = ?";

        try {
            //Prepare the statement
            PreparedStatement statement = con.prepareStatement(sqlQuery);

            //Set values
            statement.setString(1, studentName);

            //Execute query
            ResultSet rs = statement.executeQuery();

            //Print, execute or return result
            PrintStudent.printResultSetStudent(rs);

            LogFile.logInfo("Successfully retrieved information from database for student with name: " + studentName);

        } catch (SQLException e) {
            System.out.println("Something went wrong getting the information from the database, please check the logfiles!");

            LogFile.logError("Something went wrong getting the information for student with name: " + studentName + "\n" + e);
        }
    }

    public static void createStudent(int studentId, String studentFirstName, String studentLastName, Connection con) {
        String sqlSelectQuery = "SELECT * FROM student WHERE studentId = ? AND studentFirstName = ? AND studentLastName = ?";
        String sqlInsertQuery = "INSERT INTO student VALUES (?, ?, ?)";

        Validate.checkIntArgument(studentId, con);
        Validate.checkStringArgument(studentFirstName, con);
        Validate.checkStringArgument(studentLastName, con);

        try {
            PreparedStatement selectStatement = con.prepareStatement(sqlSelectQuery);

            selectStatement.setInt(1, studentId);
            selectStatement.setString(2, studentFirstName);
            selectStatement.setString(3, studentLastName);

            ResultSet rs = selectStatement.executeQuery();

            if (!rs.next()) {
                //Prepare the statement
                PreparedStatement insertStatement = con.prepareStatement(sqlInsertQuery);

                //Set values
                insertStatement.setInt(1, studentId);
                insertStatement.setString(2, studentFirstName);
                insertStatement.setString(3, studentLastName);

                //Execute query
                insertStatement.executeUpdate();

                //Print, execute or return result
                System.out.println("Successfully added student " + studentFirstName + " " + studentLastName);

                LogFile.logInfo("Successfully created student with id: " + studentId + " and first name: " + studentFirstName);
            } else {
                System.out.println("A row in the database with the same information already exist, please check!");

                LogFile.logError("Double value found for student with id: " + studentId + " and first name: " + studentFirstName);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong while adding the student, please check the logs!");

            LogFile.logError("Something went wrong after inserting information for student with id: \" + studentId + \" and first name: \" + studentFirstName"
                    + "\n" + e);
        }
    }

    public static void updateFirstNameById(String studentFirstName, int studentId, Connection con) {
        String sqlSelectQuery = "SELECT * FROM student WHERE studentId = ?";
        String sqlUpdateQuery = "UPDATE student set studentFirstName = ? where studentId = ?";

        Validate.checkStringArgument(studentFirstName, con);
        Validate.checkIntArgument(studentId, con);

        try {
            PreparedStatement selectStatement = con.prepareStatement(sqlSelectQuery);

            selectStatement.setInt(1, studentId);

            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                //Prepare the statement
                PreparedStatement updateStatement = con.prepareStatement(sqlUpdateQuery);

                //Set values
                updateStatement.setString(1, studentFirstName);
                updateStatement.setInt(2, studentId);

                //Execute query
                updateStatement.executeUpdate();

                //Print, execute or return result
                System.out.println("Successfully updated student " + studentFirstName);

                LogFile.logInfo("Successfully updated information for student with id: " + studentId);
            } else {
                System.out.println("There is no student found with this id!");

                LogFile.logError("There is no student found with id: " + studentId);
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong updating the name of the student with id: " + studentId + "\nPlease check the logs!");

            LogFile.logError("Something went wrong updating the name of the student with id: " + studentId + "\n" + e);
        }
    }
}
