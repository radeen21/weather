package com.example.admin.weather.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarUtils {

    public static String getDayFromDateString(String stringDate)
    {
        String[] daysArray = new String[] {"Sunday","Monday","Tuesday","Wednesday"
                ,"Thursday","Friday","Saturday"};
        String day = "";

        int dayOfWeek =0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date date;
        try {
            date = formatter.parse(stringDate);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            dayOfWeek = c.get(Calendar.DAY_OF_WEEK)-1;
            if (dayOfWeek < 0) {
                dayOfWeek += 7;
            }
            day = daysArray[dayOfWeek];
        } catch (Exception e) {
            e.printStackTrace();
        }

        return day;
    }

}
