package ru.progwards.java1.lessons.datetime;

import java.time.Duration;
import java.time.ZonedDateTime;

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
        switch (style) {
            case FULL:

                break;
            case LONG:

                break;
            case SHORT:

                break;

        }

    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setDuration(ZonedDateTime expiration) {

    }

    public void setDuration(int months, int days, int hours) {

    }

    public void setDuration(String strDuration, FormatStyle style) {

    }

    public boolean checkValid(ZonedDateTime dateTime) {
        return false;
    }

    public String toString() {
        return  "Insurance issued on is valid";
    }


}
