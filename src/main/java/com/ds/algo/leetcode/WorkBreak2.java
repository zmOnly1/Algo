package com.ds.algo.leetcode;

import java.util.*;

/**
 * Created by zm on 2020/2/27.
 */
public class WorkBreak2 {

    public static void main(String[] args) {
        WorkBreak2 stringToSentence = new WorkBreak2();
        String s = "catsanddog";
        String dict = "cat,cats,and,sand,dog";
        Set<String> set = new HashSet<>(Arrays.asList(dict.split(",")));

        System.out.println(stringToSentence.wordBreak(s, set));
    }

    /**
     * Given a string s and a dictionary of words dict, add spaces in s to
     * construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences.
     * For example, given
     * s ="catsanddog",
     * dict =["cat", "cats", "and", "sand", "dog"].
     * A solution is["cats and dog", "cat sand dog"].
     */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        return wordBreak(s, dict.toArray(new String[0]), new HashMap<>());
    }

    private ArrayList<String> wordBreak(String s, String[] dict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        ArrayList<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        for (String s1 : dict) {
            if (s.startsWith(s1)) {
                for (String s2 : wordBreak(s.substring(s1.length()), dict, map)) {
                    result.add(s1 + (s2.isEmpty() ? "" : " " + s2));
                }
            }
        }
        map.put(s, result);
        return result;
    }


}
