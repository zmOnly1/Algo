package com.ds.algo.leetcode;

import java.util.*;

/**
 * Created by zm on 2020/2/25.
 */
public class TreePostTravel {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rootLeft = new TreeNode(2);
        TreeNode rootRight = new TreeNode(3);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode rootLeftLeft = new TreeNode(4);
        TreeNode rootLeftRight = new TreeNode(5);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

        TreeNode rootRightLeft = new TreeNode(6);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        TreePostTravel treePostTravel = new TreePostTravel();
        treePostTravel.postOrder(root);
        System.out.println();
        System.out.println(treePostTravel.postorderTraversal(root));
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        pushLeftChild(stack, root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.right != null) {
                pushLeftChild(stack, top.right);
                top.right = null;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
            }
        }
        return result;

    }

    private void pushLeftChild(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
