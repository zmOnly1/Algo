package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/17.
 */
public class TreeKthNode {

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，
     * 按结点数值大小顺序第三小结点的值为4。
     */
    private int i = 0;
    private TreeNode kthNode = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        midOrder(pRoot, k);
        return kthNode;
    }

    private void midOrder(TreeNode pRoot, int k) {
        if (kthNode != null) {
            return;
        }
        KthNode(pRoot.left, k);
        i++;
        if (i == k) {
            kthNode = pRoot;
            return;
        }
        KthNode(pRoot.right, k);
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
