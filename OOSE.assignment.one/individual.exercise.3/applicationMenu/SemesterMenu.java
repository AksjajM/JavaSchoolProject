package applicationMenu;

import classes.Semester;
import database.DbConnection;

import java.util.Scanner;

public class SemesterMenu {

    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                
                1- Search for a semester by name
                2- Create a semester
                             
                Or press enter to go back to the menu""");

        String input = scanner.nextLine();

        if (input.equals("1")) {
            System.out.println("Please enter the name of the semester: ");
            String semesterName = scanner.nextLine();

            Semester.getSemesterByName(semesterName, DbConnection.getDbConnection());

        } else if (input.equals("2")) {
            System.out.println("Please enter the semester id: ");
            int semesterId = scanner.nextInt();
            System.out.println("Please enter the semester name: ");
            scanner.nextLine();
            String semesterName = scanner.nextLine();
            Semester.createSemester(semesterId, semesterName, DbConnection.getDbConnection());
        }
    }
}
