package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/10.
 */
public class BFSTree {

    /**
     * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        int length = sequence.length;
        if (length == 0) {
            return false;
        }
        if (length <= 2) {
            return true;
        }
        int i = 0;
        int lastIndex = length - 1;
        int root = sequence[lastIndex];
        while (i < lastIndex) {
            if (sequence[i] > root) {
                break;
            }
            i++;
        }
        while (i < lastIndex) {
            if (sequence[i] < root) {
                break;
            }
            i++;
        }
        return i == lastIndex;
    }

    /**
     * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
