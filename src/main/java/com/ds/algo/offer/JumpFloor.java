package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class JumpFloor {

    /**
     * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
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
