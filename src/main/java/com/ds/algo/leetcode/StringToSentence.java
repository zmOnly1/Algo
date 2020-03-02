package com.ds.algo.leetcode;

import java.util.*;

/**
 * Created by zm on 2020/2/27.
 */
public class StringToSentence {

    public static void main(String[] args) {
        StringToSentence stringToSentence = new StringToSentence();
        String s = "catsanddog";
        String dict = "cat,cats,and,sand,dog";
        Set<String> set = new HashSet<>(Arrays.asList(dict.split(",")));

        System.out.println(stringToSentence.wordBreak(s, set));
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.trim().length() == 0 || dict.isEmpty()) {
            return result;
        }
        List<List<Integer>> indexList = new ArrayList<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            List<Integer> endIndex = new ArrayList<>();
            for (int j = i + 1; j <= len; j++) {
                String substring = s.substring(i, j);
                if (dict.contains(substring)) {
                    endIndex.add(j);
                }
            }
            indexList.add(endIndex);
        }
        StringBuilder builder = new StringBuilder();
        findAllString(result, builder, s, indexList, 0);
        return result;
    }

    private void findAllString(ArrayList<String> result, StringBuilder builder, String s, List<List<Integer>> indexList, int startIndex) {
        if (startIndex == s.length()) {
            result.add(builder.subSequence(0, builder.length() - 1).toString());
            return;
        }

        List<Integer> indexLink = indexList.get(startIndex);
        for (Integer endIndex : indexLink) {
            int length = builder.length();
            builder.append(s, startIndex, endIndex);
            builder.append(" ");
            findAllString(result, builder, s, indexList, endIndex);
            builder.delete(length, length + endIndex - startIndex + 1);
        }
    }

}
