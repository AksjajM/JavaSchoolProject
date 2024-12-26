package applicationMenu;

import classes.StudyComponent;
import database.DbConnection;

import java.util.Scanner;

public class StudyComponentMenu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                                
                Select one of the options below:
                                
                1- Search for a study component by name
                2- Create a study component
                                                
                Or press enter to go back to the menu""");

        String input = scanner.nextLine();

        switch (input) {
            case "1" -> {
                System.out.println("Please enter the name of the study component:");
                String studyComponentName = scanner.nextLine();

                StudyComponent.getStudyComponent(studyComponentName, DbConnection.getDbConnection());

                System.out.println("\nPress enter to go back to the main menu.");
                scanner.nextLine();
            }
            case "2" -> {
                System.out.println("Please enter the study component id: ");
                int studyComponentId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Please enter the study component name: ");
                String studyComponentName = scanner.nextLine();
                System.out.println("Please enter the semester id: ");
                int semesterId = scanner.nextInt();
                scanner.nextLine();

                StudyComponent.createStudyComponent(studyComponentId, studyComponentName, semesterId, DbConnection.getDbConnection());

                System.out.println("Press enter to go back to the main menu.");
                scanner.nextLine();
            }
        }
    }
}
