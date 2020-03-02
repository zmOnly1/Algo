package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/9.
 */
public class RectCover {

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        System.out.println(rectCover.RectCover(3));
    }

    public int RectCover(int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        return RectCover1(cache, target);
    }

    public int RectCover1(Map<Integer, Integer> cache, int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        int result = RectCover1(cache, target - 1) + RectCover1(cache, target - 2);
        cache.put(target, result);
        return result;
    }

}
