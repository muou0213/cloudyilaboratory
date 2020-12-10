package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:huangyunyi
 **/
public class LetterCombinationsOfPhoneNumberV2 {
    private char[] resultArray = null;
    private List<String> resultList =  null;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        resultArray = new char[digits.length()];
        resultList = new ArrayList<>();
        handleOneDigit(0, digits);
        return resultList;
    }

    private void handleOneDigit(int i,
                                String digits) {
        if (i == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : resultArray) {
                if(c != Character.MIN_VALUE) {
                    sb.append(c);
                }
            }
            resultList.add(sb.toString());
            return;
        }
        char c = digits.charAt(i);
        if (c == '0' || c == '1') {
            handleOneDigit(i + 1, digits);
            return;
        }

        if (c == '7') {
            for (int j = 0; j < 4; j++) {
                char t = (char) ('p' + j);
                resultArray[i] = t;
                handleOneDigit(i + 1, digits);
            }
        } else if (c == '8') {
            for (int j = 0; j < 3; j++) {
                char t = (char) ('t' + j);
                resultArray[i] = t;
                handleOneDigit(i + 1, digits);
            }
        } else if (c == '9') {
            for (int j = 0; j < 4; j++) {
                char t = (char) ('w' + j);
                resultArray[i] = t;
                handleOneDigit(i + 1, digits);
            }
        } else {
            for (int j = 0; j < 3; j++) {
                char t = (char) ((c - '2') * 3 + 'a' + j);
                resultArray[i] = t;
                handleOneDigit(i + 1, digits);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinationsOfPhoneNumberV2().letterCombinations("23");
        System.out.println(strings);
    }
}
