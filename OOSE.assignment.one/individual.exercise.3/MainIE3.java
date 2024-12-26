import applicationMenu.*;
import com.mysql.cj.log.Log;
import logger.LogFile;

import java.util.Scanner;

public class MainIE3 {
    public static void main(String[] args) {

        LogFile.FileHandler();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            try {
                Thread.sleep(1000);
                System.out.println("""
                        Hey hard working teacher, please select one of the numbers to see further options of that subject:
                        1- Results
                        2- Semester
                        3- Student
                        4- Student semester
                        5- Study component
                        0- Exit
                        """);

                String input = scanner.nextLine();

                switch (input) {
                    case "0":
                        ExitMenu.menu();
                        break;
                    case "1":
                        ResultMenu.menu();
                        break;

                    case "2":
                        SemesterMenu.menu();
                        break;

                    case "3":
                        StudentMenu.menu();
                        break;

                    case "4":
                        StudentSemesterMenu.menu();
                        break;

                    case "5":
                        StudyComponentMenu.menu();
                        break;

                    default:
                        System.out.println("Invalid input, please follow the instructions!");
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
