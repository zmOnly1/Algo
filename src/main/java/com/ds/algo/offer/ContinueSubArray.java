package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/12.
 */
public class ContinueSubArray {

    /**
     * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ����������鿪����,���ַ�����:
     * �ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,������ȫΪ������ʱ��,����ܺý����
     * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�����:{6,-3,-2,7,-15,1,2,2},
     * ����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
     * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int[] sum = new int[length];

        int maxSum = array[0];
        sum[0] = array[0];
        for (int i = 1; i < length; i++) {
            sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
            maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }

}
