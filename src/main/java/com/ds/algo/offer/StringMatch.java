package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/16.
 */
public class StringMatch {

    //"",".*"
    //"",".*"
    //"","c*"
    public static void main(String[] args) {
        StringMatch stringMatch = new StringMatch();
        //char[] str = "aaa".toCharArray();
        //char[] pattern = "a.a".toCharArray();
        //char[] pattern = "ab*ac*a".toCharArray();
        //char[] pattern = "aa.a".toCharArray();
        //char[] pattern = "ab*a".toCharArray();
        //char[] str = "".toCharArray();
        //char[] pattern = ".*".toCharArray();
        //char[] pattern = "c*".toCharArray();
        char[] str = "ab".toCharArray();
        char[] pattern = ".*".toCharArray();
        System.out.println(stringMatch.match(str, pattern));
    }

    /**
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     */
    private boolean matched;

    public boolean match(char[] str, char[] pattern) {
        matched = false;
        search(0, 0, str, pattern);
        return matched;
    }

    private void search(int si, int pj, char[] str, char[] pattern) {
        if (matched) {
            return;
        }
        if (pj == pattern.length) {
            if (si == str.length) {
                matched = true;
            }
            return;
        }
        if (pattern[pj] == '.') {
            if (isNextCharStar(pj + 1, pattern)) {
                if (si == str.length) {
                    matched = true;
                    return;
                }
                for (int i = 0; i <= str.length - si; i++) {
                    search(si + i, pj + 2, str, pattern);
                }
            } else {
                search(si + 1, pj + 1, str, pattern);
            }
        } else {
            if (isNextCharStar(pj + 1, pattern)) {
                if (si < str.length && pattern[pj] == str[si]) {
                    int i = 0;
                    for (; i < str.length - si; i++) {
                        if (str[si + i] == str[si]) {
                            search(si + i, pj + 2, str, pattern);
                        } else {
                            break;
                        }
                    }
                    search(si + i, pj + 2, str, pattern);
                } else {
                    search(si, pj + 2, str, pattern);
                }
            } else {
                if (si < str.length && pattern[pj] == str[si]) {
                    search(si + 1, pj + 1, str, pattern);
                }
            }
        }
    }

    private boolean isNextCharStar(int pj, char[] pattern) {
        return pj < pattern.length && pattern[pj] == '*';
    }

}
