package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/19.
 */
public class CutNumber {

    public static void main(String[] args) {
        CutNumber cutNumber = new CutNumber();
        System.out.println(cutNumber.cutRope(20));
    }

    public int cutRope(int target) {
        if (target <= 0) {
            return 0;
        }
        int max = 0;
        int half = target / 2;
        if (half <= 1) {
            return target - half;
        } else {
            for (int m = 2; m <= half; m++) {
                int avgLen = target / m;
                int avgRemain = target % m;
                int ret = avgRemain == 0 ? (int) Math.pow(avgLen, m) :
                              (int) (Math.pow(avgLen, m - avgRemain) * Math.pow(avgLen + 1, avgRemain));
                if (ret > max) {
                    max = ret;
                }
            }
        }
        return max;
    }

}
