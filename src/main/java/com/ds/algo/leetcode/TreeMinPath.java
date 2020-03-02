package com.ds.algo.leetcode;

/**
 * Created by zm on 2020/2/23.
 */
public class TreeMinPath {

    /**
     * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
     */
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null || root.right == null) {
            if (root.left != null) {
                return run(root.left) + 1;
            } else {
                return run(root.right) + 1;
            }
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
