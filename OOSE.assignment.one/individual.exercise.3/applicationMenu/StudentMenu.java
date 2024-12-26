package applicationMenu;

import classes.Student;
import database.DbConnection;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentMenu {
    public static void menu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                
                Select one of the options below:
                
                1- Search for a student by id
                2- Search for a student by name
                3- Add a new student
                4- Update first name of a student
                                                
                Or press enter to go back to the menu""");

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> {
                System.out.println("Please enter the id of the student: ");
                int studentId = scanner.nextInt();

                Student.getStudentById(studentId, DbConnection.getDbConnection());
                System.out.println("Press enter to go back to the main menu.");
                scanner.nextLine();
                scanner.nextLine();

            }
            case "2" -> {
                System.out.println("Please enter the first name of the student: ");
                String studentName = scanner.nextLine();
                Student.getStudentByName(studentName, DbConnection.getDbConnection());
                System.out.println("Press enter to go back to the main menu.");
                scanner.nextLine();
            }
            case "3" -> {
                System.out.println("Please enter the id of the student: ");
                int studentId = scanner.nextInt();
                System.out.println("Please enter the first name of the student: ");
                scanner.nextLine();
                String studentFirstName = scanner.nextLine();
                System.out.println("Please enter the last name of the student: ");
                String studentLastName = scanner.nextLine();

                Student.createStudent(studentId, studentFirstName, studentLastName, DbConnection.getDbConnection());

                System.out.println("\nPress enter to go back to the main menu.");
                scanner.nextLine();
            }
            case "4" -> {
                System.out.println("Please enter the id of the student: ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter the new first name of the student: ");
                String studentFirstName = scanner.nextLine();


                Student.updateFirstNameById(studentFirstName, studentId, DbConnection.getDbConnection());

                System.out.println("\nPress enter to go back to the main menu.");
                scanner.nextLine();
            }
        }
    }
}
