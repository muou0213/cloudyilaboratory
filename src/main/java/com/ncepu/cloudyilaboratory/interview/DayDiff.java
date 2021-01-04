package com.ncepu.cloudyilaboratory.interview;

public class DayDiff {
    public static void main(String[] args) {
        int result = DayDiff.getDifference(2020, 11, 05, 2020, 7, 04);

        System.out.println(result);
    }

    public static int getDifference(int y1, int m1, int d1,
                                    int y2, int m2, int d2) {

        int yearDiff = y1 - y2;
        int dayDiff = d1 - d2;

        int[] daysOfMonth = new int[] {31, 28, 31, 30, 31,
                30, 31, 31, 30, 31, 30, 31};

        int dayDiffInMonth = 0;

        if (m1 < m2) {
            for (int i = m1 - 1; i < m2 - 1; i++) {
                dayDiffInMonth += daysOfMonth[i];
            }
            dayDiffInMonth = 0 - dayDiffInMonth;
        } else if(m1 > m2) {
            for (int i = m2 - 1; i < m1 - 1; i++) {
                dayDiffInMonth += daysOfMonth[i];
            }
        }

        int result = (yearDiff) * 365 + dayDiffInMonth + dayDiff;
        return result;
    }
}
