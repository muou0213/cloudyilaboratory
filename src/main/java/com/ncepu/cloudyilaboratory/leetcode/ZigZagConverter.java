package com.ncepu.cloudyilaboratory.leetcode;

/**
 * @author:huangyunyi
 **/
public class ZigZagConverter {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int level;
        for(int i = 0; i < chars.length; i += numRows * 2 -2) {
            sb.append(chars[i]);
        }

        level = 1;
        while(true) {
            int i = level;
            boolean even = true;
            if (level == numRows - 1) {
                break;
            }
            while(i < chars.length) {
                sb.append(chars[i]);
                if (even) {
                    i += (numRows - level - 1) * 2;
                    even = false;
                } else {
                    i += level * 2;
                    even = true;
                }
            }
            level = level + 1;
        }
        int i = level;
        while(i < chars.length) {
            sb.append(chars[i]);
            i += level * 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String paypalishiring3 = new ZigZagConverter().convert("PAYPALISHIRING", 3);
        System.out.println("PAHNAPLSIIGYIR".equals(paypalishiring3));

        String paypalishiring4 = new ZigZagConverter().convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring4);
        System.out.println("PINALSIGYAHRPI".equals(paypalishiring4));
    }
}
