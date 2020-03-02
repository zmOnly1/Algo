package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/10.
 */
public class TreePath {

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

        rootLeftLeft.left = new TreeNode(3);

        TreeNode rootRightLeft = new TreeNode(6);
        TreeNode rootRightRight = new TreeNode(7);
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;

        TreePath treePath = new TreePath();
        ArrayList<ArrayList<Integer>> result = treePath.FindPath(root, 10);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        path.add(root.val);
        int sum = 0;
        FindPath(root, target, sum, path, result);
        result.sort((o1, o2) -> o2.size() - o1.size());
        return result;
    }

    private void FindPath(TreeNode root, int target, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        sum += root.val;
        if(target == sum){
            result.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            FindPath(root.left, target, sum, path, result);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            path.add(root.right.val);
            FindPath(root.right, target, sum, path, result);
            path.remove(path.size() - 1);
        }
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
