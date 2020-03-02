package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class JumpFloor {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     *
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        System.out.println(jumpFloor.JumpFloorII(3));
    }

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }

        int result = 1;
        for (int i = 1; i < target; i++) {
            result += JumpFloorII(target - i);
        }
        return result;
    }

}
