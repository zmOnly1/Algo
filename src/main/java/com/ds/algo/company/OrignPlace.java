package com.ds.algo.company;

import java.util.*;

/**
 * Created by zm on 2020/12/12.
 */
public class OrignPlace {

    private int MOD = 1_000_000_007;
    private Map<String, Integer> map = new HashMap<>();
    public int numWays(int steps, int arrLen) {
        return keepStep(steps, 0, arrLen);
    }

    private int keepStep(int steps, int pos, int length) {
        if (steps == 0) {
            return pos == 0 ? 1 : 0;
        }
        String key = steps + "," + pos;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int result = keepStep(steps - 1, pos, length);
        result%=MOD;

        if (0 <= (pos - 1)) {
            result += keepStep(steps - 1, pos - 1, length);
            result%=MOD;
        }

        if (pos + 1 < length) {
            result += keepStep(steps - 1, pos + 1, length);
            result%=MOD;
        }
        map.put(key, result);
        return result;
    }

}
