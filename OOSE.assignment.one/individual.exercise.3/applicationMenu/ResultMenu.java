package applicationMenu;

import classes.Result;
import database.DbConnection;
import logger.LogFile;

import java.util.Scanner;
import java.util.logging.Logger;

public class ResultMenu {

    public static void menu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                            
                            Select one of the options below:
                            
                            1- Enter student results
                            
                            Or press enter to go back to the menu""");

        String input = scanner.nextLine();

        if (input.equals("1")){
            System.out.println("Please enter the following information:");
            System.out.println("Date yyyy-mm-dd: ");
            String date = scanner.nextLine();
            System.out.println("Student id: ");
            int studentId = scanner.nextInt();
            System.out.println("Study component id: ");
            int studyComponentId = scanner.nextInt();
            System.out.println("""
                    Please use a comma for decimal numbers and only one number after the comma e.g. 5,5 / 6,7
                    Final grade:""");
            double finalGrade = scanner.nextDouble();

            Result.insertResult(date, studentId, studyComponentId, finalGrade, DbConnection.getDbConnection());
        }
    }
}
