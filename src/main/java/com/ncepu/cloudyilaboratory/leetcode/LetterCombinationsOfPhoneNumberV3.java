package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:huangyunyi
 **/
public class LetterCombinationsOfPhoneNumberV3 {
    private List<String> resultList =  null;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        resultList = new ArrayList<>();
        handleOneDigit("", 0, digits);
        return resultList;
    }

    private void handleOneDigit(String combinationResult,
                                int i,
                                String digits) {
        if (i == digits.length()) {
            resultList.add(combinationResult);
            return;
        }
        char c = digits.charAt(i);
        if (c == '0' || c == '1') {
            handleOneDigit(combinationResult, i + 1, digits);
            return;
        }

        if (c == '7') {
            for (int j = 0; j < 4; j++) {
                char t = (char) ('p' + j);
                handleOneDigit(combinationResult + t, i + 1, digits);
            }
        } else if (c == '8') {
            for (int j = 0; j < 3; j++) {
                char t = (char) ('t' + j);
                handleOneDigit(combinationResult + t,i + 1, digits);
            }
        } else if (c == '9') {
            for (int j = 0; j < 4; j++) {
                char t = (char) ('w' + j);
                handleOneDigit(combinationResult + t,i + 1, digits);
            }
        } else {
            for (int j = 0; j < 3; j++) {
                char t = (char) ((c - '2') * 3 + 'a' + j);
                handleOneDigit(combinationResult + t,i + 1, digits);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinationsOfPhoneNumberV3().letterCombinations("23");
        System.out.println(strings);
    }
}
