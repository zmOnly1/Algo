package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/12.
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();
        int[] numbers = new int[] {3, 32, 321};
        System.out.println(printMinNumber.PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        if (numbers.length == 1) {
            return String.valueOf(numbers[0]);
        }

        int maxLen = getMaxNumberLen(numbers);
        sortNumbersStr(numbers, maxLen);
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            result.append(number);
        }
        return result.toString();
    }

    private int getMaxNumberLen(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            int numberLen = String.valueOf(number).length();
            if (numberLen > max) {
                max = numberLen;
            }
        }
        return max;
    }

    private void sortNumbersStr(int[] numbers, int maxLen) {
        int len = numbers.length;
        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int first = numbers[j];
                int second = numbers[j + 1];

                int fillFirstNumber = fillNumber(first, maxLen);
                int fillSecondNumber = fillNumber(second, maxLen);
                if (fillFirstNumber > fillSecondNumber) {
                    swap(numbers, j, j + 1);
                }
            }
        }
    }

    private int fillNumber(int number, int needStrLen) {
        int len = String.valueOf(number).length();
        if (len < needStrLen) {
            int single = number % 10;
            StringBuilder builder = new StringBuilder();
            builder.append(number);
            int j = needStrLen - len;
            while (j > 0) {
                builder.append(single);
                j--;
            }
            return Integer.parseInt(builder.toString());
        }
        return number;
    }

    private void swap(int[] numbers, int src, int dest) {
        int temp = numbers[src];
        numbers[src] = numbers[dest];
        numbers[dest] = temp;
    }

}
