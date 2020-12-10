package com.ncepu.cloudyilaboratory.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
执行用时：
267 ms
, 在所有 Java 提交中击败了
26.43%
的用户
内存消耗：
38.8 MB
, 在所有 Java 提交中击败了
96.53%
的用户
 */
public class SubstringWithConcatenationOfAllWordsV2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        Map<String, Integer> strCountMap = new HashMap<>();


        for(String str : words) {
            Integer count = strCountMap.get(str);
            if (count == null) {
                strCountMap.put(str, 1);
            } else {
                strCountMap.put(str, count + 1);
            }
        }

        // 判断s中以所有字符开头的子串是否满足条件
        int zeroCount = 0;
        // 先找0，0 + 1 * worldLength, 0 + 2 * worldLength开始的所有子串
        // 再找1，1 + 1 * worldLength, 1 + 2 * worldLength开始的所有子串
        // 以此类推
        //这里算法有问题，之前是i < s.length()
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> tempStrCountMap = new HashMap<>(strCountMap);
            // 第一次的代码这个之前掉了
            zeroCount = 0;
            // 尝试开始找以j、j + 1 * length、j + 2 * length 开始的子串
            for(int j = i; j + wordLength <= s.length();) {
                int k = j;
                // 找以j开始的子串的具体过程，判断是否所有的子串都符合
                while (k + wordLength <= s.length()) {
                    String substring = s.substring(k, k + wordLength);
                    // 这里第一次是Integer count = strCountMap.get(substring);
                    // 第二次改成这个
                    Integer count = tempStrCountMap.get(substring);
                    // 这个子串没有找到，所以直接从下一个子串开始
                    // 下一个子串就是 j = k + wordLength
                    if (count == null) {
                        j = k + wordLength;
                        zeroCount = 0;
                        tempStrCountMap = new HashMap<>(strCountMap);
                        break;
                        // 找到了，但是words中已经没有这个子串了，所以还是匹配不上
                        // 可以将j一直向前走，走到第一个
                    } else if (count == 0) {
                        int t = j;
                        while (t < k) {
                            String tempSubString = s.substring(t, t + wordLength);
                            if (tempSubString.equals(substring)) {
                                j = t + wordLength;
                                break;
                            } else {
                                Integer tempCount = tempStrCountMap.get(tempSubString);
                                tempStrCountMap.put(tempSubString, tempCount + 1);
                                if(tempCount == 0) {
                                    zeroCount--;
                                }
                            }
                            t = t + wordLength;
                        }
                        // 按道理讲t不可能等于k
                        // 如果之前没有遇到subString，tempStrCountMap中的count不会变成0
                        if (t == k) {
                            j = k + wordLength;
                            zeroCount = 0;
                            tempStrCountMap = new HashMap<>(strCountMap);
                            break;
                        }
                    } else {
                        if (count == 1) {
                            zeroCount++;
                        }
                        tempStrCountMap.put(substring, count - 1);
                        if (zeroCount == tempStrCountMap.size()) {
                            result.add(j);
                            String firstSubstring = s.substring(j, j + wordLength);
                            tempStrCountMap.put(firstSubstring, 1);
                            zeroCount--;
                            j = j + wordLength;
                            // 第二次编辑的时候这个位置被改成了break
                            // j = k + wordLength;
                            // break;
                        }
                    }
                    k += wordLength;
                }
                // 最开始的代码掉了一种case
                if (k + wordLength > s.length()) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
       /* String s = "ababababab";
        String[] words = new String[]{"ababa","babab"};*/
       /* String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};*/
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","word"};
        List<Integer> positions = new SubstringWithConcatenationOfAllWordsV2().findSubstring(s, words);
        positions.forEach(a -> System.out.print(a + ","));
    }
}
