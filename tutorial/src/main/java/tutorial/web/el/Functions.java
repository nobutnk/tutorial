package tutorial.web.el;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.joda.time.DateTime;

public class Functions {

    private Functions() {
        // do nothing.
    }
    
    public static DateTime toJodaDateTime(Object object) {
        
        if (object instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) object;
            return new DateTime(localDateTime.getYear(),
                    localDateTime.getMonthValue(),
                    localDateTime.getDayOfMonth(),
                    localDateTime.getHour(),
                    localDateTime.getMinute(),
                    localDateTime.getSecond(),
                    localDateTime.getNano()/1000000);
        } else if (object instanceof LocalDate) {
            LocalDate localDate = (LocalDate) object;
            return new DateTime(localDate.getYear(),
                    localDate.getMonthValue(),
                    localDate.getDayOfMonth(),
                    0,
                    0,
                    0,
                    0);
        } else if (object instanceof LocalTime) {
            LocalTime localTime = (LocalTime) object;
            LocalDateTime now = LocalDateTime.now();
            return new DateTime(now.getYear(),
                    now.getMonthValue(),
                    now.getDayOfMonth(),
                    localTime.getHour(),
                    localTime.getMinute(),
                    localTime.getSecond(),
                    localTime.getNano()/1000000);
        }
        
        return null;
    }
    
    public static org.joda.time.LocalDate toJodaDate(Object object) {
        if (object instanceof LocalDate) {
            LocalDate localDate = (LocalDate) object;
            return new org.joda.time.LocalDate(localDate.getYear(),
                    localDate.getMonthValue(),
                    localDate.getDayOfMonth());
        }
        
        return null;
    }
    
    public static org.joda.time.LocalTime toJodaTime(Object object) {
        if (object instanceof LocalTime) {
            LocalTime localTime = (LocalTime) object;
            return new org.joda.time.LocalTime(
                    localTime.getHour(),
                    localTime.getMinute(),
                    localTime.getSecond(),
                    localTime.getNano()/1000000);
        }
        
        return null;
    }
}
