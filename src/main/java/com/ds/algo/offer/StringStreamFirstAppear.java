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
     * ��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
     * ���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
     * ���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
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
