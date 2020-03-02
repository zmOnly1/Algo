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
     * ���ӣ�https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8?answerType=1&f=discussion
     * ��Դ��ţ����
     *
     * ���һ��������Ϊ0����ô�������������һλ��1��������ǰ����������1����ôԭ�������������ұߵ�1�ͻ��Ϊ0��ԭ����1��������е�0������1(������ұߵ�1���滹��0�Ļ�)����������λ�������ܵ�Ӱ�졣
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
     * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
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
