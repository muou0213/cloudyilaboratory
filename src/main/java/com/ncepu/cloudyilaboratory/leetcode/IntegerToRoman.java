package com.ncepu.cloudyilaboratory.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerToRoman {
    private Lock printCondition = new ReentrantLock();



    public String intToRoman(int num) {
        String[] strArray = new String[4];
        int i = num;
        int count = 1;
        do {
            int a = i % 10;
            switch(count) {
                case 1:
                    strArray[count - 1] = handleOne(a);
                    break;
                case 2:
                    strArray[count - 1] = handleTen(a);
                    break;
                case 3:
                    strArray[count - 1] = handleHandred(a);
                    break;
                case 4:
                    strArray[count - 1]  = handleThsoudand(a);
                    break;
            }
            count++;
            i = i / 10;
        } while(i != 0);

        StringBuilder sb = new StringBuilder();
        for(int j = 3;j >= 0;j--) {
            if (strArray[j] != null) {
                sb.append(strArray[j]);
            }
        }
        return sb.toString();
    }

    private String handleOne(int i) {
        switch(i) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
        }
        return "";
    }

    private String handleTen(int i) {
        switch(i) {
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
        }
        return "";
    }

    private String handleHandred(int i) {
        switch(i) {
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
        }
        return "";
    }

    private String handleThsoudand(int i) {
        switch(i) {
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
        }
        return "";
    }

    public static void main(String[] args) {
        int a = 27;
        System.out.println(new IntegerToRoman().intToRoman(a));
    }
}
