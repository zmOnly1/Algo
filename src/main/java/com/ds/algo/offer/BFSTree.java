package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/10.
 */
public class BFSTree {

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
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
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
