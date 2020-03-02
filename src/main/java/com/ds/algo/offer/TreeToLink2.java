package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/11.
 */
public class TreeToLink2 {

    /**
     * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        midOrder(list, pRootOfTree);

        TreeNode head =list.get(0);
        head.left = null;
        TreeNode prev = head;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode current = list.get(i);
            prev.right = current;
            current.left = prev;

            prev = current;
        }
        return head;
    }

    private void midOrder(List<TreeNode> list, TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(list, node.left);
        list.add(node);
        midOrder(list, node.right);
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
