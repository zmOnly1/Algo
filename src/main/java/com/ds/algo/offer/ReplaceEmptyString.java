package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class ReplaceEmptyString {

    public static void main(String[] args) {
        replaceSpace(new StringBuffer());
    }

    /**
     * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

}
