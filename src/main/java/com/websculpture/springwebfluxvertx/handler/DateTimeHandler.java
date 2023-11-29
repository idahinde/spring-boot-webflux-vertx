package com.websculpture.springwebfluxvertx.handler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Idris Ishaq
 * @Date: 09 Apr, 2023
 */

public class DateTimeHandler {

    private final static String TIME_FORMAT = "hh:mm:ss a";
    private final static String DATE_FORMAT = "yyyy-MM-dd";

    private static ZoneId getZoneId() {
        LocalDateTime utcTime = LocalDateTime.now(ZoneOffset.UTC);
        // Define the WAT timezone
        return ZoneId.of("Africa/Lagos");
    }

    public static String getDate() {
        LocalDate localDate = getLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    public static LocalDate getLocalDate() {
        return LocalDateTime.now(getZoneId()).toLocalDate();
    }

    public static String getTime() {
        LocalTime localTime = LocalTime.now(getZoneId());
        return localTime.format(DateTimeFormatter.ofPattern(TIME_FORMAT));
    }

    public static String dateTime() {
        return String.format("%s, %s", getDate(), getTime());
    }

    public static String dateTimeStamp() {
        LocalDateTime localDateTime = LocalDateTime.now(getZoneId());
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    }

    public static String dateTimeStampString() {
        LocalDateTime utcTime = LocalDateTime.now(ZoneOffset.UTC);
        // Define the WAT timezone
        ZoneId watZoneId = ZoneId.of("Africa/Lagos");
        // Convert the UTC time to WAT
        ZonedDateTime watTime = utcTime.atZone(ZoneOffset.UTC).withZoneSameInstant(watZoneId);
        return new StringBuilder().append(watTime.getYear()).append("-")
                .append(pad(watTime.getMonthValue())).append("-")
                .append(pad(watTime.getDayOfMonth())).append("T")
                .append(pad(watTime.getHour() - 1)).append(":")
                .append(pad(watTime.getMinute())).append(":")
                .append(pad(watTime.getSecond())).append(".")
                .append(String.format("%03d", watTime.getNano() / 1000000))
                .append("Z")
                .toString();
    }

    private static String pad(int value) {
        return String.format("%02d", value);
    }

}
