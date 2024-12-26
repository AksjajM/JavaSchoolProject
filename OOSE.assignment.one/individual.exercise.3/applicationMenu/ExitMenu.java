package applicationMenu;

import database.DbConnection;

public class ExitMenu {
    public static void menu() {
        try {
            Thread.sleep(500);
            System.out.println("Shutting off...");
            Thread.sleep(3000);
            System.out.println("Have a nice day!");
            Thread.sleep(500);
            DbConnection.closeDbConnection(DbConnection.getDbConnection());
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
