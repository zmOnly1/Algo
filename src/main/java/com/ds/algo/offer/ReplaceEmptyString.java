package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class ReplaceEmptyString {

    public static void main(String[] args) {
        replaceSpace(new StringBuffer());
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

}
