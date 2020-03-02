package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/14.
 */
public class NumberContinue {

    public static void main(String[] args) {
        NumberContinue numberContinue = new NumberContinue();
        System.out.println(numberContinue.FindContinuousSequence1(99));
    }


    /**
     * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> resp = new ArrayList<>();
        if (sum <= 0) {
            return resp;
        }
        int leftP = 1;
        int rightP = 2;
        int sumVal = leftP + rightP;

        while (sum > rightP) {
            if (sumVal < sum) {
                rightP++;
                sumVal += rightP;
            } else if (sumVal > sum) {
                sumVal -= leftP;
                leftP++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = leftP; i <= rightP; i++) {
                    list.add(i);
                }
                resp.add(list);

                rightP++;
                sumVal += rightP;
            }
        }

        return resp;

    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;

        while (low < high) {
            int testSum = (high - low + 1) * (low + high) / 2;
            if (testSum < sum) {
                high++;
            } else if (testSum > sum) {
                low++;
            } else {
                ArrayList<Integer> list = new ArrayList<>(high - low + 1);
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                high++;
            }
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int top = (int) (Math.sqrt(2 * sum + 1) + 1);
        for (int k = top - 1; k > 1; k--) {
            if (k % 2 == 1) {
                if (sum % k == 0) {
                    int start = sum / k - k / 2;
                    if (start > 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int i = 0; i < k; i++) {
                            list.add(start + i);
                        }
                        result.add(list);
                    }
                }
            } else {
                if (sum % k == k / 2) {
                    int start = sum / k - (k / 2 - 1);
                    if (start > 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        for (int i = 0; i < k; i++) {
                            list.add(start + i);
                        }
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

}
