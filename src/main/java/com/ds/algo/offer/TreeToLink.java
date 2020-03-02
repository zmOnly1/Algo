package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/11.
 */
public class TreeToLink {

    /**
     * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
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
