package ru.progwards.java1.lessons.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by Arseniy on 25.02.2020.
 */
public class Insurance {

    public static enum FormatStyle {SHORT, LONG, FULL}

    private ZonedDateTime start;
    private Duration duration;

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {
        DateTimeFormatter format;
        switch (style) {
            case LONG:
                format = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            case FULL:
                format = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                break;
            case SHORT:
                format = DateTimeFormatter.ISO_LOCAL_DATE;
                break;
            default:
                throw new IllegalStateException("Check FormatStyle enum class. Unexpected value: " + style);
        }
        LocalDate date = LocalDate.parse(strStart, format);
        this.start = date.atStartOfDay(ZoneId.systemDefault());
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {
        this.duration = Duration.between(this.start, expiration);
    }

    public void setDuration(int months, int days, int hours) {
        this.duration = Duration.between(this.start, this.start.plusMonths(months).plusDays(days).minusHours(hours));
    }

    public void setDuration(String strDuration, FormatStyle style) {
        switch (style) {
            case SHORT:
                this.duration = Duration.ofMillis(Integer.parseInt(strDuration));
                break;
            case LONG:
                LocalDateTime localDateTime = LocalDateTime.parse(strDuration, DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
                LocalDateTime localDateTimeZero = LocalDateTime.parse("0000-01-01T00:00:00");
                this.duration = Duration.between(localDateTimeZero, localDateTime);
                break;
            case FULL:
                this.duration = Duration.parse(strDuration);
                break;
        }
    }

    public boolean checkValid(ZonedDateTime dateTime) {
        if(this.duration == null) return true;
        if(dateTime.isAfter(start)) {
            if(dateTime.isBefore(start.plus(duration))){
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String validStr = " is not valid";
        if(checkValid(ZonedDateTime.now())) {
            validStr = " is valid";
        }
        return "Insurance issued on " + start + validStr;
    }


}
