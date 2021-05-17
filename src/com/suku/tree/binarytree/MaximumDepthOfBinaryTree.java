package com.suku.tree.binarytree;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

    static int maxDepth(TreeNode root) {

        //terminating condition
        if (root == null) return 0;

        /* compute the depth of each subtree */
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);

        /* use the larger one */
        if (lHeight > rHeight)
            return lHeight + 1;
        else
            return rHeight + 1;
    }


    /* Driver program to test above functions */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(5);

        System.out.println("Height of tree is : " + maxDepth(root));
    }
}
