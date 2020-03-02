package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/11.
 */
public class TreeToLink {

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        return Convert1(pRootOfTree, 1);
    }

    /**
     * @param i 0=left, 1=right
     */
    private TreeNode Convert1(TreeNode node, int i) {
        if (node == null) {
            return null;
        }

        TreeNode head;
        TreeNode tail;

        TreeNode left = Convert1(node.left, 0);
        TreeNode right = Convert1(node.right, 1);
        if (left == null) {
            if (right != null) {
                right.left = node;
                tail = right;
            } else {
                tail = node;
            }
            head = node;
        } else {
            left.right = node;
            if (right != null) {
                right.left = node;
                tail = right;
            } else {
                tail = node;
            }
            head = left;
        }
        return i == 0 ? tail : head;
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
