package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/12.
 */
public class UglyNumber {

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + ":" + uglyNumber.GetUglyNumber_Solution(i));
        }
    }

    public int GetUglyNumber_Solution(int index) {
        if(index == 0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < index; i++) {
            int min = Math.min(result[p2] * 2, Math.min(result[p3] * 3, result[p5] * 5));
            result[i] = min;
            if(min == result[p2] * 2) p2++;
            if(min == result[p3] * 3) p3++;
            if(min == result[p5] * 5) p5++;
        }
        return result[index - 1];
    }

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */
    public int GetUglyNumber_Solution2(int index) {
        if (index == 1) {
            return 1;
        }
        int count = 1;
        int number = 1;
        while (count < index) {
            number++;
            if (isUglyNumber(number)) {
                count++;
            }
        }
        return number;
    }

    private boolean isUglyNumber(int number) {
        int[] factors = new int[] {2, 3, 5};
        int i = 0;
        while (true) {
            int factor = factors[i];
            if (number % factor == 0) {
                number = number / factor;
                i = 0;
            } else {
                if (i == 2) {
                    break;
                }
                i++;
            }
        }
        return number == 1;
    }

    private boolean isUglyNumber2(int number) {
        int[] factors = new int[] {2, 3, 5};
        for (int factor : factors) {
            if (number % factor == 0) {
                number = number / factor;
                return isUglyNumber(number);
            }
        }
        return number == 1;
    }

}
