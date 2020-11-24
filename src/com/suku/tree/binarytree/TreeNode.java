package com.suku.tree.binarytree;

public class TreeNode {
    public TreeNode left;
    public int val;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left =null;
        right =null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "left=" + left.val +
                ", val=" + val +
                ", right=" + right.val +
                '}';
    }
}
