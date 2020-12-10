package com.ncepu.cloudyilaboratory.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
    private int wordLength;
    private Set<Integer>[] intSetArray;

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new LinkedList<>();
        if (s == null
                || s.length() == 0
                || words == null
                || words.length ==0) {
            return result;
        }
        intSetArray = new Set[words.length];

        wordLength = words[0].length();
        for (int i =0; i< words.length;i++) {
            Set<Integer> positions = new HashSet<>();
            int index = 0;
            int count = 0;
            while(true) {
                index = s.indexOf(words[i], count);
                if (index != -1) {
                    count++;
                    positions.add(index);
                } else {
                    break;
                }
            }
            intSetArray[i] = positions;
        }

        Set<Integer> alreadyHandled = new HashSet<>();
        for (int i = 0; i < intSetArray.length; i++) {
            Iterator<Integer> iterator = intSetArray[i].iterator();
            while (iterator.hasNext()) {
                Integer position = iterator.next();
                if (alreadyHandled.contains(position)) {
                    break;
                } else {
                    alreadyHandled.add(position);
                }
                if (isSubString(position + wordLength, i)) {
                    result.add(position);
                }
            }
        }

        return result;
    }

    private boolean isSubString(int needPosition, int index) {
        List<Integer> indexList = new LinkedList<>();

        for (int i = 0; i < intSetArray.length; i++) {
            if (i != index) {
                indexList.add(i);
            }
        }

        while (!indexList.isEmpty()) {
            Iterator<Integer> iterator = indexList.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                Integer arrayIndex = iterator.next();
                if (intSetArray[arrayIndex].contains(needPosition)) {
                    iterator.remove();
                    needPosition += wordLength;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }

        return indexList.isEmpty();
    }

    public static void main(String[] args) {
        String s = "ababababab";
        String[] words = new String[]{"ababa","babab"};
        List<Integer> positions = new SubstringWithConcatenationOfAllWords().findSubstring(s, words);
        positions.forEach(a -> System.out.println(a + ","));
    }
}
