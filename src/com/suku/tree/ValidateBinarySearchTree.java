package com.suku.tree;

import com.suku.tree.binarytree.TreeNode;

public class ValidateBinarySearchTree {


    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;

        return true;
    }

    public static boolean  isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println("Is valid bfs : " + isValidBST(root));
    }
}

