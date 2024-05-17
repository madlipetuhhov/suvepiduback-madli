package ee.valiit.suvepiduback.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
public class LocalTimeConverter {

    public static LocalTime stringToLocalTime(String timeString) {
        // Split the time string into hours and minutes 10:00
        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        // Adjust hours if it's past midnight
        if (hours == 24) {
            hours = 0;
        }

        // Create a LocalDateTime object with the given hours and minutes
        LocalDateTime localDateTime = LocalDateTime.of(1, 1, 1, hours, minutes);

        // Convert to Estonia timezone (UTC+3)
        return localDateTime.atZone(ZoneId.of("Europe/Tallinn")).withZoneSameInstant(ZoneId.of("UTC+3")).toLocalTime();
    }
}
