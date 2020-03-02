package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/16.
 */
public class TreeSuccessor {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            TreeLinkNode parent = pNode.next;
            TreeLinkNode current = pNode;
            while (parent != null && current == parent.right) {
                current = parent;
                parent = parent.next;
            }
            return parent;
        }
    }

    class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
