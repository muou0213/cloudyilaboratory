package com.ncepu.cloudyilaboratory.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetBeforeTime {

    public static void main(String[] args) {
      /*  Date date = new Date(114, 2, 18);

        System.out.println(date.toString());

        Calendar.getInstance();*/
        GetBeforeTime getBeforeTime = new GetBeforeTime();

        System.out.println("get before time by directly computing");
        getBeforeTime.getBeforeTime(3, "02:10", 2000);

        System.out.println("get before time by Calendar");
        getBeforeTime.getBeforeTimeWithDateTime(3, "02:10", 2000);
    }

    public void getBeforeTime(int dayOfWeek, String time, int beforeMinutes) {
        int beforeDay = beforeMinutes / (24 * 60);
        int beforeHour = (beforeMinutes - beforeDay * 24 * 60) / 60;
        int beforeMinute = beforeMinutes % 60;

        String[] timeSplits = time.split(":");
        int hour = Integer.valueOf(timeSplits[0]);
        int minute = Integer.valueOf(timeSplits[1]);

        int targetMinute = minute - beforeMinute;
        int targetHour = hour - beforeHour;
        int targetDayOfWeek = dayOfWeek - beforeDay;

        if (targetMinute < 0) {
            targetHour--;
            targetMinute += 60;
        }

        if (targetHour < 0) {
            targetDayOfWeek--;
            targetHour += 24;
        }

        while (targetDayOfWeek < 0) {
            targetDayOfWeek = targetDayOfWeek + 7;
        }

        System.out.println(targetDayOfWeek);
        System.out.println(targetHour + ":" + targetMinute);
    }

    public void getBeforeTimeWithDateTime(int dayOfWeek, String time, int beforeMinutes) {
        String[] timeSplits = time.split(":");
        int hour = Integer.valueOf(timeSplits[0]);
        int minute = Integer.valueOf(timeSplits[1]);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);

        cal.add(Calendar.MINUTE, 0 - beforeMinutes);

        int targetDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(targetDayOfWeek);
        System.out.println(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));
        Date date = new Date(cal.toInstant().toEpochMilli());
        DateFormat format = new SimpleDateFormat();
        System.out.println(format.format(date));
    }



}
