package com.ncepu.cloudyilaboratory.leetcode;

/**
 * @author:huangyunyi
 **/
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }

        if (s.isEmpty() && p.length() == 1 && p.charAt(1) == '*') {
            return true;
        }
        if (s.isEmpty() || p.isEmpty()) {
            return false;
        }
        boolean isFirstMatch = (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');


        if (p.length() >= 2 && p.charAt(1) == '*') {
            if (!isFirstMatch) {
                return isMatch(s, p.substring(2));
            } else {
                return isMatch(s.substring(1), p) ||
                        isMatch(s, p.substring(2));
            }
        } else {
            return isFirstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "a*a"));
    }
}
