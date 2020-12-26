package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/3/8.
 */
public class SingleNumber2 {

    public static void main(String[] args) {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        //int[] array = {1, 3, 7, 3, 7, 7, 3};
        int[] array = {2, 2, 3, 2};
        System.out.println(singleNumber2.singleNumber(array));
    }

    /**
     * 现在有一个整数类型的数组，数组中只有一个元素只出现一次，其余元素都出现三次。你需要找出只出现一次的元素
     * 链接：https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a?f=discussion
     * 来源：牛客网
     */
    public int singleNumber(int[] A) {
        int ones = 0;//记录只出现过1次的bits
        int twos = 0;//记录只出现过2次的bits
        int threes;
        for (int t : A) {
            twos |= ones & t;//要在更新ones前面更新twos
            ones ^= t;
            threes = ones & twos;//ones和twos中都为1即出现了3次
            ones &= ~threes;//抹去出现了3次的bits
            twos &= ~threes;
        }
        return ones;
    }

}
