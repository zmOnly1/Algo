package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/15.
 */
public class LastRemaining {

    public static void main(String[] args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.LastRemaining_Solution(5, 3));
    }

    /**
     * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
     * HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ������,�и���Ϸ��������:
     * ����,��С������Χ��һ����Ȧ��Ȼ��,�����ָ��һ����m,
     * �ñ��Ϊ0��С���ѿ�ʼ������ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,
     * Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,��������һ��С���ѿ�ʼ,
     * ����0...m-1����....������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,
     * �����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
     * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
     * <p>
     * ���û��С���ѣ��뷵��-1
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }
        int[] children = new int[n];

        int count = n;
        int index = 0;
        int num = 0;
        while (count > 0) {
            if (num == m - 1) {
                children[index] = 1;
                count--;
            }
            num = (num + 1) % m;
            index = (index + 1) % n;
            while (children[index] == 1) {
                index = (index + 1) % n;
            }
            if (count == 1) {
                break;
            }
        }
        return index;
    }

}
