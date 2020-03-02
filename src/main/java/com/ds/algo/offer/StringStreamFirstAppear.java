package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/16.
 */
public class StringStreamFirstAppear {

    public static void main(String[] args) {
        StringStreamFirstAppear appear = new StringStreamFirstAppear();
        appear.Insert('g');
        System.out.println(appear.FirstAppearingOnce());
        appear.Insert('0');
        System.out.println(appear.FirstAppearingOnce());
        appear.Insert('0');
        System.out.println(appear.FirstAppearingOnce());
        appear.Insert('g');
        System.out.println(appear.FirstAppearingOnce());
        appear.Insert('l');
        System.out.println(appear.FirstAppearingOnce());
        appear.Insert('e');
        System.out.println(appear.FirstAppearingOnce());
    }

    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     */
    private List<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        Character o = ch;
        if(list.contains(o)){
            list.remove(o);
        } else {
            list.add(o);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (list.isEmpty()) {
            return '#';
        }
        return list.get(0);
    }

}
