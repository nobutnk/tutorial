package tutorial.web.el;

import static org.hamcrest.CoreMatchers.is;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

public class FunctionsTest {

    @Test
    public void expectedSameValueToJodaTimeWhenLocalDateTime() {
        
        LocalDateTime localDateTime = LocalDateTime.of(
                2016,
                5,
                10,
                23,
                40,
                59,
                999);
        
        DateTime jodaTime = Functions.toJodaDateTime(localDateTime);
        
        Assert.assertThat(jodaTime.getYear(), is(localDateTime.getYear()));
        Assert.assertThat(jodaTime.getMonthOfYear(), is(localDateTime.getMonthValue()));
        Assert.assertThat(jodaTime.getDayOfMonth(), is(localDateTime.getDayOfMonth()));
        Assert.assertThat(jodaTime.getHourOfDay(), is(localDateTime.getHour()));
        Assert.assertThat(jodaTime.getMinuteOfHour(), is(localDateTime.getMinute()));
        Assert.assertThat(jodaTime.getSecondOfMinute(), is(localDateTime.getSecond()));
    }
    
    @Test
    public void expectedSameValueToJodaTimeWhenLocalDate() {
        
        LocalDate localDate = LocalDate.of(
                2016,
                5,
                10);
        
        org.joda.time.LocalDate jodaTime = Functions.toJodaDate(localDate);
        
        Assert.assertThat(jodaTime.getYear(), is(localDate.getYear()));
        Assert.assertThat(jodaTime.getMonthOfYear(), is(localDate.getMonthValue()));
        Assert.assertThat(jodaTime.getDayOfMonth(), is(localDate.getDayOfMonth()));
    }
    
    @Test
    public void expectedSameValueToJodaTimeWhenLocalTime() {
        
        LocalTime localTime = LocalTime.of(
                0,
                17,
                59,
                999);
        
        org.joda.time.LocalTime jodaTime = Functions.toJodaTime(localTime);
        
        Assert.assertThat(jodaTime.getHourOfDay(), is(localTime.getHour()));
        Assert.assertThat(jodaTime.getMinuteOfHour(), is(localTime.getMinute()));
        Assert.assertThat(jodaTime.getSecondOfMinute(), is(localTime.getSecond()));
        Assert.assertThat(jodaTime.getMillisOfSecond(), is(localTime.getNano()/1000));
    }
}
