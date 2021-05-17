package com.suku.tree;

import com.suku.tree.binarytree.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBinarySearchTree {


    public static boolean validate(TreeNode root, Integer low, Integer high) {
        // Empty trees are valid BSTs.
        if (root == null) {
            return true;
        }
        // The current node's value must be between low and high.
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
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

