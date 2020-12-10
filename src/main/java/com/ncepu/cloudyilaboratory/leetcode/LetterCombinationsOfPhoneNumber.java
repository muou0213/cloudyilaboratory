package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author:huangyunyi
 **/
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<List<Character>> letterLists = new ArrayList<List<Character>>() {
            {
                add(Arrays.asList('a','b','c'));
                add(Lists.newArrayList('d','e','f'));
                add(Lists.newArrayList('g','h','i'));
                add(Lists.newArrayList('j','k','l'));
                add(Lists.newArrayList('m','n','o'));
                add(Lists.newArrayList('p','q','r','s'));
                add(Lists.newArrayList('t','u','v'));
                add(Lists.newArrayList('w','x','y','z'));
            }
        };
        List<String> resultList = new ArrayList<>();
        char[] result = new char[digits.length()];
        perDigit(digits, 0, result, letterLists, resultList);
        return resultList;
    }

    public void perDigit(String digits, int i, char[] result, List<List<Character>> letterLists, List<String> resultList) {
        if (i == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (char c : result) {
                if(c != Character.MIN_VALUE) {
                    sb.append(c);
                }
            }
            resultList.add(sb.toString());
            return;
        }
        int number = Character.getNumericValue(digits.charAt(i));
        if (number == 0 || number ==1) {
            perDigit(digits, i + 1 , result, letterLists, resultList);
            return;
        }
        List<Character> characters = letterLists.get(number - 2);
        for(Character c : characters) {
            result[i] = c;
            perDigit(digits, i + 1 , result, letterLists, resultList);
        }
    }
}
