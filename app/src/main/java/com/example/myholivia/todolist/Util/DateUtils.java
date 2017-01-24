package com.example.myholivia.todolist.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by myholivia on 1/6/17.
 */

public class DateUtils {

    private static DateFormat dateFormat =
            new SimpleDateFormat("yyyy MM dd HH:mm", Locale.getDefault());

    private static DateFormat dateFormatDate =
            new SimpleDateFormat("EEE, MMM dd, yyyy", Locale.getDefault());

    private static DateFormat dateFormatTime =
            new SimpleDateFormat("HH:mm", Locale.getDefault());


    public static Date stringToDate(String string) {
        try {
            return dateFormat.parse(string);
        } catch (ParseException e) {
            return Calendar.getInstance().getTime();
        }
    }

    public static String dateToStringDate(Date date) {
        return dateFormatDate.format(date);
    }

    public static String dateToStringTime(Date date) {
        return dateFormatTime.format(date);
    }
}
