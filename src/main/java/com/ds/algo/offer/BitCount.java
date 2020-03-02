package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class BitCount {

    public static void main(String[] args) {
        BitCount bitCount = new BitCount();
        System.out.println(bitCount.NumberOf1(-1));
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = n >= 0 ? 0 : 1;
        int i = n >= 0 ? n : Integer.MAX_VALUE + n + 1;
        while (i > 0) {
            int bit = i % 2;
            if (bit == 1) {
                count++;
            }
            i = i / 2;
        }
        return count;
    }

}
