package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/9.
 */
public class Tree {

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

        Tree tree = new Tree();
        //System.out.println(tree.IsBalanced_Solution(root));
        System.out.println(tree.Print(root));
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return false;
        }
        Map<TreeNode, Integer> treeDepth = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int leftDepth = TreeDepth1(treeDepth, node.left);
            int rightDepth = TreeDepth1(treeDepth, node.right);
            boolean isBalance = Math.abs(leftDepth - rightDepth) <= 1;
            if (!isBalance) {
                return false;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return true;
    }

    public boolean isMidOrder(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean isLeft = root.left == null || root.left.val < root.val;
        boolean isRight = root.right == null || root.val < root.right.val;
        return isLeft && isRight;
    }


    public int TreeDepth1(Map<TreeNode, Integer> treeDepth, TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (treeDepth.containsKey(root)) {
            return treeDepth.get(root);
        }
        int left = TreeDepth1(treeDepth, root.left);
        int right = TreeDepth1(treeDepth, root.right);
        int depth = Math.max(left, right) + 1;
        treeDepth.put(root, depth);
        return depth;
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public void Mirror(TreeNode root) {
        convert(root);
    }

    private TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = convert(right);
        root.right = convert(left);
        return root;
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }

        return hasSubTree(root1, root2) || hasSubTree(root1.left, root2) || hasSubTree(root1.right, root2);
    }

    private boolean hasSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return hasSubTree(root1.left, root2.left) && hasSubTree(root1.right, root2.right);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        } else {
            if (right == null) {
                return false;
            }
        }
        return left.val == right.val && isSymmetrical(left.right, right.left) && isSymmetrical(left.left, right.right);
    }

    /**
     * 请实现一个函数按照之字形打印二叉树，
     * 即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> oldStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        oldStack.push(pRoot);
        int deep = 1;
        boolean direction = true;//false:left, true: right
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>(deep);
            Stack<TreeNode> newStack = new Stack<>();
            while (deep-- > 0) {
                TreeNode treeNode = oldStack.pop();
                list.add(queue.poll().val);
                if (direction) {
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                        newStack.push(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                        newStack.push(treeNode.left);
                    }
                } else {
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                        newStack.push(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                        newStack.push(treeNode.right);
                    }
                }
            }
            oldStack = newStack;
            result.add(list);
            deep = queue.size();
            direction = !direction;
        }
        return result;
    }

    static class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

}
