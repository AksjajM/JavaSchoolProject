package validation;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validate {
    public static void checkIntArgument(Integer i, Connection con) {
        if (con == null) {
            throw new NullPointerException("You do not have a valid database connection!");
        }

        if (i == null) {
            throw new NullPointerException("ID is null");
        }

        if (i < 0) {
            throw new IllegalArgumentException("ID is out of range! Try entering a value above 0.");
        }
    }

    public static void checkStringArgument(String s, Connection con) {
        if (con == null) {
            throw new NullPointerException("You do not have a valid database connection!");
        }

        if (s == null || s.isEmpty()) {
            throw new NullPointerException("Arguments are null or empty");
        }

        if (s.matches("[a-zA-Z]")) {
            throw new IllegalArgumentException("Only fill in letters!");
        }
    }

    public static void checkDateArgument(String date, Connection con) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        if (con == null) {
            throw new NullPointerException("You do not have a valid database connection!");
        }

        try {
            sdf.parse(date);
        } catch (ParseException e) {
            System.out.println("Something went wrong filling in the date, please keep the following format in mind: yyyy-mm-dd\n" + e);
        }
    }

    public static void checkDoubleArgument(Double num, Connection con) {

        if (con == null) {
            throw new NullPointerException("You do not have a valid database connection!");
        }

        String text = Double.toString(Math.abs(num));
        int integerPlaces = text.indexOf('.');
        int decimalPlaces = text.length() - integerPlaces - 1;

        if (decimalPlaces != 1 || num > 10.0 || num < 0.1) {
            throw new IllegalArgumentException("The double value must have exactly one digit after the decimal point, " +
                    "must not be greater than 10.0, " +
                    "and must not be less than 0.1!");
        }
    }
}