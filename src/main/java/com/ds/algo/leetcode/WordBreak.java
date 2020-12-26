package com.ds.algo.leetcode;

import java.util.*;

/**
 * Created by zm on 2020/3/2.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {
        return wordBreak(s, dict, new HashMap<>());
    }

    private boolean wordBreak(String s, Set<String> dict, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if(s == null || s.isEmpty()){
            map.put(s, false);
            return false;
        }
        for (String s1 : dict) {
            boolean b = s.startsWith(s1) && wordBreak(s.substring(s1.length()), dict);
            if (b) {
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
