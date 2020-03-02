package com.ds.algo.offer;

import java.util.*;

/**
 * Created by zm on 2020/2/17.
 */
public class TreeSerial {

    public static void main(String[] args) {
        //String abc = "8!6!10!5!#9!11!7!#####10!";
        String abc = "8,6,5,7,#,#,#,#,10,9,#,#,11,10,#,#,#";
        TreeSerial treeSerial = new TreeSerial();
        TreeNode root = treeSerial.Deserialize(abc);
        treeSerial.print(root);
        System.out.println();
        String serialize = treeSerial.Serialize(root);
        System.out.println(serialize);
        System.out.println(abc.equals(serialize));
    }

    private String Serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            builder.append("#,");
            return builder.toString();
        }
        builder.append(root.val).append(",");
        builder.append(Serialize(root.left));
        builder.append(Serialize(root.right));
        return builder.toString();
    }


    private TreeNode Deserialize(String str) {
        String[] nodeStrings = str.split(",");
        return Deserialize(nodeStrings);
    }

    private int index = -1;
    private TreeNode Deserialize(String[] nodeArrays) {
        index++;

        TreeNode treeNode = null;
        String nodeString = nodeArrays[index];
        if (!"#".equals(nodeString)) {
            treeNode = new TreeNode(Integer.parseInt(nodeString));
            treeNode.left = Deserialize(nodeArrays);
            treeNode.right = Deserialize(nodeArrays);
        }
        return treeNode;
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.print(root.val);
        print(root.right);
    }

    String Serialize1(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null) {
            return builder.toString();
        }
        Map<Integer, String> mapping = new HashMap<>();
        setIndex(root, 0, mapping);
        Integer[] keys = mapping.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        int i = 0;
        int len = keys.length;
        for (; i < len - 1; i++) {
            Integer key = keys[i];
            builder.append(mapping.get(key));
            Integer next = keys[i + 1];
            for (int j = key + 1; j < next; j++) {
                builder.append("#");
            }
        }
        builder.append(mapping.get(keys[i]));
        return builder.toString();
    }

    private void setIndex(TreeNode node, int index, Map<Integer, String> mapping) {
        if (node == null) {
            return;
        }
        mapping.put(index, node.val + "!");
        setIndex(node.left, 2 * index + 1, mapping);
        setIndex(node.right, 2 * index + 2, mapping);
    }

    TreeNode Deserialize1(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] strings = str.split("[!#]");
        int i = 1;
        int len = strings.length;

        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (i < len) {
                TreeNode left = stringToTreeNode(strings[i++]);
                queue.add(left);
                if (treeNode != null) {
                    treeNode.left = left;
                }
            }
            if (i < len) {
                TreeNode right = stringToTreeNode(strings[i++]);
                queue.add(right);
                if (treeNode != null) {
                    treeNode.right = right;
                }
            }
        }
        return root;
    }

    private TreeNode stringToTreeNode(String str) {
        if (!str.isEmpty()) {
            return new TreeNode(Integer.parseInt(str));
        }
        return null;
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
