package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/15.
 */
public class SumNumber {

    public static void main(String[] args) {
        SumNumber sumNumber = new SumNumber();
        int[] array = new int[] {2, 4, 5, 7, 8, 11, 14, 16, 18, 19, 24, 27, 29};
        System.out.println(sumNumber.FindNumbersWithSum(array, 18));
        System.out.println(sumNumber.Sum_Solution(4));
        System.out.println(sumNumber.Add(111, 899));
    }

    /**
     * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>(2);
        int low = 0;
        int high = array.length - 1;

        while (low < high) {
            int testSum = array[low] + array[high];
            if (testSum < sum) {
                low++;
            } else if (testSum > sum) {
                high--;
            } else {
                result.add(0, array[low]);
                result.add(1, array[high]);
                break;
            }
        }
        return result;
    }

    /**
     * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
     */
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = sum > 0 && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }

    /**
     * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
     */
    public int Add(int num1, int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }

}
