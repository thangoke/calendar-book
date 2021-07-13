package com.thangnv.booking.utils;

import com.thangnv.booking.controller.exception.DateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static Date string2Date(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new DateFormatException(String.format("Cannot parse [%s] with pattern [%s]", dateString, pattern));
        }
    }

    public static String date2String(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            throw new DateFormatException(String.format("Cannot format [%s] with pattern [%s]", date.toString(), pattern));
        }
    }
}
