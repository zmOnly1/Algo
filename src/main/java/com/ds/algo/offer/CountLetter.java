package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/12.
 */
public class CountLetter {

    public static void main(String[] args) {
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        CountLetter countLetter = new CountLetter();
        System.out.println(countLetter.FirstNotRepeatingChar("aac"));

    }

    /**
     * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,
     * ����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
     */
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0){
            return -1;
        }
        int size = ('z' - 'A') + 1;
        int[] letter = new int[size];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            letter[c - 'A']++;
        }
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0, len = letter.length; i < len; i++) {
            if (letter[i] == 1) {
                char c = (char) ('A' + i);
                int oneLetterIndex = str.indexOf(c);
                if (oneLetterIndex < minIndex) {
                    minIndex = oneLetterIndex;
                }
            }
        }
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

}
