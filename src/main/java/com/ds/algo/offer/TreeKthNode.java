package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/17.
 */
public class TreeKthNode {

    /**
     * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣���磬 ��5��3��7��2��4��6��8���У�
     * �������ֵ��С˳�����С����ֵΪ4��
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
