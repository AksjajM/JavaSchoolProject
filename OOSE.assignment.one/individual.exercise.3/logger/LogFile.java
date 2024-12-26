package logger;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LogFile {

    private static final Logger logger = Logger.getLogger("Classname and method: " + LogFile.class.getName());

    public static void FileHandler() {
        try {
            String fileName = "logFile.txt";
            File logFile = new File(fileName);

            Handler consoleHandler = null;
            for (Handler handler : logger.getHandlers()) {
                if (handler instanceof ConsoleHandler) {
                    consoleHandler = handler;
                    break;
                }
            }
            if (consoleHandler != null) {
                logger.removeHandler(consoleHandler);
            }

            logger.setUseParentHandlers(false);

            if (logFile.exists()) {
                Handler fileHandler = new FileHandler(fileName, true);
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
            } else {
                Handler fileHandler = new FileHandler(fileName);
                fileHandler.setFormatter(new SimpleFormatter());
                logger.addHandler(fileHandler);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logError(String message) {
        logger.log(Level.SEVERE, message);
    }
}
