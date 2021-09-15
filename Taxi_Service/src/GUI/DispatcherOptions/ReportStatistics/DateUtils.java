package GUI.DispatcherOptions.ReportStatistics;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");

    public static boolean isDateRangeValid(Date startDate, Date endDate) {
        if(startDate == null)
            return false;

        if(endDate == null)
            return false;

        if(!startDate.before(endDate))
            return false;

        return true;
    }

    public static String serializeLocalDateTime(LocalDateTime localDateTime) {
        if(localDateTime == null)
            return "-";

        return localDateTime.toString();
    }

    public static LocalDateTime deserializeLocalDateTime(String dateString) {
        if("-".equals(dateString))
            return null;

        return LocalDateTime.parse(dateString);
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        if(localDateTime == null)
            return "-";

        return localDateTime.format(formatter);
    }

    public static String formatDuration(Duration duration) {
        if(duration == null)
            return "-";

        long seconds = duration.getSeconds();
        long minutes = seconds / 60;

        seconds -= minutes * 60;

        long hours = minutes / 60;

        minutes -= hours * 60;

        return String.format("%d:%d:%d", hours, minutes, seconds);
    }

}
