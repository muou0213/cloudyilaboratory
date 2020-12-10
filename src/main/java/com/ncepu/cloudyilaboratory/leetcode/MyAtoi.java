package com.ncepu.cloudyilaboratory.leetcode;

/**
 * @author:huangyunyi
 **/
public class MyAtoi {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        boolean minus = false;
        boolean started = false;
        int nextMax = Integer.MAX_VALUE / 10;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                if (started) {
                    break;
                }
                continue;
            }
            if (chars[i] == '+') {
                if(started) {
                    break;
                }
                started = true;
            }else if (chars[i] == '-') {
                if(started) {
                    break;
                }
                minus = true;
                started = true;
            } else if (Character.isDigit(chars[i])) {
                started = true;
                int num = (int)chars[i] - (int)('0');
                if (result > nextMax || (result == nextMax && num >= 8)) {
                    return minus == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 + num;
            } else {
                return minus == false ? result : 0 - result;
            }
        }
        return minus == false ? result : 0 - result;
    }

    public static void main(String[] args) {
        int i = new MyAtoi().myAtoi("2147483649");
        System.out.println(i);
    }
}
