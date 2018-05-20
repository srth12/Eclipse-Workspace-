package com.hackerrank.code.graph.tree;

/**
 * Height-balanced binary tree :
 * is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1
 *
 */
public class TreeBalancedOrNot {

    private static boolean isNotBalanced = false;

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2= new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node2.left = node4;
        node4.left = node5;
        node5.right = node6;
        int result = isBalancedTree(node1, 0);
        System.out.println(result);
    }

    public static int isBalancedTree(TreeNode node, int nodeHeight){
        if (isNotBalanced)
            return -1;
        if (node == null)
            return nodeHeight;
        int leftHeight = isBalancedTree(node.left, nodeHeight + 1);
        int rightHeight = isBalancedTree(node.right, nodeHeight + 1);
        if (Math.abs( leftHeight - rightHeight) > 1) {
            isNotBalanced = false;
            return -1;
        }
        return Math.max(leftHeight, rightHeight);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
