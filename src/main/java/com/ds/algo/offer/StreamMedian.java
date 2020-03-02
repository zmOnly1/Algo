package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/17.
 */
public class StreamMedian {

    public static void main(String[] args) {
        System.out.println((1+2)/2.0);

        StreamMedian streamMedian = new StreamMedian();
        streamMedian.Insert(5);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(2);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(3);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(4);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(1);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(6);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(7);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(0);System.out.println(streamMedian.GetMedian());
        streamMedian.Insert(8);System.out.println(streamMedian.GetMedian());
    }

    private PriorityQueue<Integer> bigStack = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> littleStack = new PriorityQueue<>();
    private int allNumberCount = 0;

    public void Insert(Integer num) {
        allNumberCount++;
        if (bigStack.isEmpty()) {
            bigStack.add(num);
            return;
        }

        if (num <= bigStack.peek()) {
            if (bigStack.size() < (allNumberCount + 1) / 2) {
                bigStack.add(num);
            } else {
                Integer topNum = bigStack.poll();
                bigStack.add(num);
                moveTopLittleStatck(topNum);
            }
        } else {
            if (littleStack.size() < allNumberCount / 2) {
                littleStack.add(num);
            } else {
                littleStack.add(num);
                Integer topNum = littleStack.poll();
                moveTopBigStatck(topNum);
            }
        }
    }


    private void moveTopLittleStatck(Integer num) {
        littleStack.add(num);
    }

    private void moveTopBigStatck(Integer num) {
        bigStack.add(num);
    }

    public Double GetMedian() {
        if (bigStack.isEmpty()) {
            return null;
        }
        if (allNumberCount % 2 == 1) {
            return Double.valueOf(bigStack.peek());
        } else {
            return (bigStack.peek() + littleStack.peek()) / 2.0;
        }
    }

}
