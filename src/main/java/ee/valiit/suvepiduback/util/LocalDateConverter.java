package ee.valiit.suvepiduback.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter {

    public static LocalDate stringToLocalDate(String dateString) {
        // Parse the dateString to a LocalDate object
        return LocalDate.parse(dateString);
    }

    public static String localDateToString(LocalDate date) {
        // Create a formatter for the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // Format the LocalDate object using the formatter
        return date.format(formatter);
    }

    public static String localDateToDateInputString(LocalDate date) {
        // Create a formatter for the desired date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // Format the LocalDate object using the formatter
        return date.format(formatter);
    }
}
