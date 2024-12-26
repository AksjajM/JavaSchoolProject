package applicationMenu;

import classes.StudentSemester;
import database.DbConnection;

import java.util.Scanner;

public class StudentSemesterMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                                
                Select one of the options below:
                                
                1- Add a student to a semester
                2- Unsubscribe a student of a semester
                                                
                Or press enter to go back to the menu""");

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> {
                System.out.println("The student semester id will be generated automatically, so check if you don't fill in double values!");
                System.out.println("Please enter the student id: ");
                int studentId = scanner.nextInt();

                System.out.println("Please enter the semester id: ");
                int semesterId = scanner.nextInt();

                StudentSemester.addStudentToSemester(studentId, semesterId, DbConnection.getDbConnection());

                System.out.println("\nPress enter to go back to the main menu.");
                scanner.nextLine();
                scanner.nextLine();
            }

            case "2" -> {
                System.out.println("Please enter the student id: ");
                int studentId = scanner.nextInt();

                System.out.println("Please enter the semester id: ");
                int semesterId = scanner.nextInt();

                StudentSemester.unsubscribeStudent(studentId, semesterId, DbConnection.getDbConnection());

                System.out.println("\nPress enter to go back to the main menu.");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
    }
}
