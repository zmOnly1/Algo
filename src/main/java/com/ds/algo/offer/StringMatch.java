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
     * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ���
     * ��'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ��
     * ���磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
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
