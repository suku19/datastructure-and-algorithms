package com.suku.tree.binarytree;

import com.suku.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//https://leetcode.com/problems/symmetric-tree/
public class SymmetricBinaryTree {

    //Approach iteratative
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }

    //Approach recursive
    public static boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println("Is symmetric binary tree : " + isSymmetric(root));
    }
}
