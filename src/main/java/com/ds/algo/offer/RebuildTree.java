package com.ds.algo.offer;

/**
 * Created by zm on 2020/2/9.
 */
public class RebuildTree {

    public static void main(String[] args) {
        int[] pre = new int[] {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[] {4, 7, 2, 1, 5, 3, 8, 6};
        RebuildTree rebuildTree = new RebuildTree();
        TreeNode root = rebuildTree.reConstructBinaryTree(pre, in);
        rebuildTree.print(root);

    }

    public void print(TreeNode root){
        if(root == null){
            return;
        }
        print(root.left);
        System.out.print(root.val);
        System.out.print(",");
        print(root.right);
    }

    /**
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
     * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }

        int inLen = in.length;
        int nodeVal = pre[0];
        TreeNode node = new TreeNode(nodeVal);

        int i = 0;
        while (i < inLen && in[i] != nodeVal) {
            i++;
        }
        int[] inLeft = new int[i];
        int[] inRight = new int[inLen - i - 1];
        System.arraycopy(in, 0, inLeft, 0, inLeft.length);
        System.arraycopy(in, i + 1, inRight, 0, inRight.length);

        int[] preLeft = new int[inLeft.length];
        int[] preRight = new int[inRight.length];
        System.arraycopy(pre, 1, preLeft, 0, preLeft.length);
        System.arraycopy(pre, preLeft.length + 1, preRight, 0, preRight.length);

        node.left = reConstructBinaryTree(preLeft, inLeft);
        node.right = reConstructBinaryTree(preRight, inRight);

        return node;
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
